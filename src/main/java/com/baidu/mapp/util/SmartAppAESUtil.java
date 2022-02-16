package com.baidu.mapp.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

/**
 * @description: 智能小程序加解密工具类
 * @author: chenhaonan02
 * @create: 2022-01-10 14:31
 **/
public class SmartAppAESUtil {
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * 对密文进行解密
     *
     * @param text 需要解密的密文
     *
     * @return 解密得到的明文
     *
     * @throws Exception 异常错误信息
     */
    public static String decrypt(String text, String sessionKey, String ivStr) throws Exception {
        byte[] aesKey = Base64.decode(sessionKey + "=");
        byte[] original;
        try {
            AES aes = new AES(Mode.CBC, Padding.NoPadding, aesKey, Base64.decode(ivStr));
            original = aes.decrypt(Base64.decode(text));
        } catch (Exception e) {
            throw new Exception(e);
        }
        String decryptedText;
        try {
            // 去除补位字符
            byte[] bytes = removeComplementCharacters(original);
            // 分离16位随机字符串,网络字节序和ClientId
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int length = recoverNetworkBytesOrder(networkOrder);
            if (length > 65535) {
                /*
                 * 注意：开发者解密加密数据出现乱码或者偶发OOM，一般是sessionKey过期导致
                 *
                 * 开发者可以根据实际情况，改变判断值大小
                 */
                throw new RuntimeException("aesKey invalid");
            }
            decryptedText = new String(Arrays.copyOfRange(bytes, 20, 20 + length), CHARSET);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return decryptedText;
    }

    /**
     * 还原4个字节的网络字节序
     *
     * @param orderBytes 字节码
     *
     * @return sourceNumber
     */
    private static int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        int length = 4;
        int number = 8;
        for (int i = 0; i < length; i++) {
            sourceNumber <<= number;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * 删除解密后明文的补位字符
     *
     * @param decrypted 解密后的明文
     *
     * @return 删除补位字符后的明文
     */
    private static byte[] removeComplementCharacters(byte[] decrypted) {
        int padding = decrypted[decrypted.length - 1];
        if (padding < 1 || padding > 32) {
            padding = 0;
        }
        return Arrays.copyOfRange(decrypted, 0, decrypted.length - padding);
    }
}