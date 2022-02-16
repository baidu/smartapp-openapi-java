package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.QrCodeService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.developer.bean.qrcode.QRCodeData;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;
import com.baidu.mapp.common.validator.BaiduAssert;

import java.util.Map;

public class QrCodeServiceImpl extends BaseService implements QrCodeService {
    private static QrCodeService qrCodeService;

    public static QrCodeService getInstance() {
        if (qrCodeService == null) {
            qrCodeService = ProxyUtil.proxy(new QrCodeServiceImpl(), TimeIntervalAspect.class);
        }
        return qrCodeService;
    }

    @Override
    public QRCodeData getQrCode(String accessToken, String path, int width, int mf, int imgFlag)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("path", path);
        params.put("width", width);
        params.put("mf", mf);
        params.put("img_flag", imgFlag);


        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(QR_CODE, params);

        SmartAppResult<QRCodeData> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<QRCodeData>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public QRCodeData getUnlimitedQrCode(String accessToken, String path, int width, int mf, int imgFlag)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("path", path);
        params.put("width", width);
        params.put("mf", mf);
        params.put("img_flag", imgFlag);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(UNLIMITED_QR_CODE, params);

        SmartAppResult<QRCodeData> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<QRCodeData>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
