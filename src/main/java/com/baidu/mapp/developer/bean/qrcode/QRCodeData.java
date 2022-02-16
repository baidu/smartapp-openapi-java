package com.baidu.mapp.developer.bean.qrcode;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class QRCodeData {
    /**
     * 二维码图片的base64字符串
     */
    @Alias("base64_str")
    private  String base64Str;
    /**
     * 对应的url
     */
    @Alias("url")
    private  String url;
}
