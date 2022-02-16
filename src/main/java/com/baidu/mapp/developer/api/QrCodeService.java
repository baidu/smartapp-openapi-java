package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.developer.bean.qrcode.QRCodeData;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public interface QrCodeService {
    /**
     * 二维码短链
     * https://smartprogram.baidu.com/docs/develop/serverapi/get_qrcode/
     */
    String QR_CODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "qrcode/getv2";

    /**
     * 二维码长链
     * https://smartprogram.baidu.com/docs/develop/serverapi/get_unlimited_qrcode/
     */
    String UNLIMITED_QR_CODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "qrcode/getunlimitedv2";

    /**
     *
     * @param accessToken
     * @param path 扫码进入的小程序页面路径，最大长度 4000 字节，可以为空
     * @param width 二维码的宽度（单位：px）。最小 280px，最大 1280px
     * @param mf 是否包含二维码内嵌 logo 标识，1001 为不包含，默认包含
     * @param imgFlag 返回值选项，默认或传 1 时只返回二维码 base64 编码字符串，传 0 只返回 url
     * @return 二维码信息
     * @throws SmartAppErrorException
     */
    QRCodeData getQrCode(String accessToken, String path, int width, int mf, int imgFlag)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     *
     * @param accssToken
     * @param path 扫码进入的小程序页面路径，最大长度 4000 字节，可以为空
     * @param width 二维码的宽度（单位：px）。最小 280px，最大 1280px
     * @param mf 是否包含二维码内嵌 logo 标识，1001 为不包含，默认包含
     * @param imgFlag 返回值选项，默认或传 1 时只返回二维码 base64 编码字符串，传 0 只返回 url
     * @return 二维码信息
     * @throws SmartAppErrorException
     */
    QRCodeData getUnlimitedQrCode(String accssToken, String path, int width, int mf, int imgFlag)
            throws SmartAppErrorException, OpenAPIErrorException;
}

