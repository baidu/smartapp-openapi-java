package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.auth.FaceAuthResponse;
import com.baidu.mapp.tp.bean.auth.PaymentCertification;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 真实性认证接口
 * @author: chenhaonan02
 * @create: 2021-11-09 18:45
 **/
public interface AuthenticityCertificationService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "AuthenticityCertification";
    /**
     * 法人人脸识别认证
     * https://smartprogram.baidu.com/docs/third/advanced_auth/face_auth/
     */
    String TP_FACE_AUTH = SmartAppConstants.OPEN_API_SMART_APP_URL + "auth/faceauthen";
    /**
     * 对公打款认证
     * https://smartprogram.baidu.com/docs/third/advanced_auth/public_auth/
     */
    String TP_PAYMENT_CERTIFICATION = SmartAppConstants.OPEN_API_SMART_APP_URL + "auth/paymentCertification";

    /**
     * 法人人脸识别认证
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return FaceAuthResponse
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    FaceAuthResponse faceAuthentication(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 对公打款认证
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return 对公打款
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PaymentCertification paymentCertification(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;
}
