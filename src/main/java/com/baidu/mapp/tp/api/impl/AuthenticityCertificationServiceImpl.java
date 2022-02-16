package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.AuthenticityCertificationService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.auth.FaceAuthResponse;
import com.baidu.mapp.tp.bean.auth.PaymentCertification;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 真实性认证接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-09 18:53
 **/
public class AuthenticityCertificationServiceImpl extends BaseService implements AuthenticityCertificationService {

    private static AuthenticityCertificationService authenticityCertificationService;

    public static AuthenticityCertificationService getInstance() {
        if (authenticityCertificationService == null) {
            authenticityCertificationService =
                    ProxyUtil.proxy(new AuthenticityCertificationServiceImpl(), TimeIntervalAspect.class);
        }
        return authenticityCertificationService;
    }

    @Override
    public FaceAuthResponse faceAuthentication(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_FACE_AUTH, params);

        SmartAppResult<FaceAuthResponse> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<FaceAuthResponse>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public PaymentCertification paymentCertification(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAYMENT_CERTIFICATION, params);

        SmartAppResult<PaymentCertification> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PaymentCertification>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
