package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.auth.AppInfo;
import com.baidu.mapp.tp.bean.auth.AuthorizationCode;
import com.baidu.mapp.tp.bean.auth.OAuthToken;
import com.baidu.mapp.tp.bean.auth.PreAuthCode;
import com.baidu.mapp.tp.bean.auth.TpAccessToken;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 授权流程接口
 * https://smartprogram.baidu.com/docs/third/auth/auth_process/
 * @author: chenhaonan02
 * @create: 2021-10-25 11:00
 **/
public interface AuthorizationProcessService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "AuthorizationProcessService";
    /**
     * 获取第三方平台的接口调用凭据
     * https://smartprogram.baidu.com/docs/third/auth/access_token/
     */
    String TP_GET_ACCESS_TOKEN = SmartAppConstants.OPEN_API_DOMAIN + "public/2.0/smartapp/auth/tp/token";
    /**
     * 获取预授权码
     * https://smartprogram.baidu.com/docs/third/auth/pre_auth_code/
     */
    String TP_GET_PRE_AUTH_CODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "tp/createpreauthcode";
    /**
     * 使用授权码换小程序的接口调用凭据和授权信息
     * https://smartprogram.baidu.com/docs/third/auth/get_auth_info/
     */
    String TP_GET_AUTH_TOKEN = SmartAppConstants.OPEN_API_DOMAIN + "rest/2.0/oauth/token";
    /**
     * 刷新授权小程序的接口调用凭据
     * https://smartprogram.baidu.com/docs/third/auth/refresh_access_token/
     */
    String TP_REFRESH_AUTH_TOKEN = SmartAppConstants.OPEN_API_DOMAIN + "rest/2.0/oauth/token";
    /**
     * 获取小程序基础信息
     * https://smartprogram.baidu.com/docs/third/auth/app_info/
     */
    String TP_GET_APP_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/info";
    /**
     * 找回授权码
     * https://smartprogram.baidu.com/docs/third/auth/refresh_token/
     */
    String TP_RETRIEVE_AUTHORIZATION_CODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "auth/retrieve"
            + "/authorizationcode";

    /**
     * 获取第三方平台的接口调用凭据
     *
     * @param clientId 第三方平台Key
     * @param ticket   第三方平台服务器推送的 ticket，此 ticket 会定时推送，具体请见“1、 推送ticket协议”
     *
     * @return TpAccessToken
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TpAccessToken token(String clientId, String ticket) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取预授权码
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     *
     * @return TP的预授权码
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PreAuthCode createPreAuthCode(String tpAccessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 使用授权码换小程序的接口调用凭据和授权信息
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param code          授权码
     * @param grantType     固定字符串：app_to_tp_authorization_code
     *
     * @return openAPI token
     *
     * @throws OpenAPIErrorException OpenAPI异常类
     */
    OAuthToken getOAuthToken(String tpAccessToken, String code, String grantType)
            throws OpenAPIErrorException;

    /**
     * 刷新授权小程序的接口调用凭据
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param refreshToken  接口调用凭据刷新令牌，有效期10年，使用后失效
     * @param grantType     固定字符串： app_to_tp_refresh_token
     *
     * @return openAPI token
     *
     * @throws OpenAPIErrorException OpenAPI异常类
     */
    OAuthToken refreshOAuthToken(String tpAccessToken, String refreshToken, String grantType)
            throws OpenAPIErrorException;

    /**
     * 获取小程序基础信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return 小程序基础信息
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AppInfo info(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 找回授权码
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param appId         小程序app_id
     *
     * @return 授权码
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AuthorizationCode retrieveAuthorizationCode(String tpAccessToken, Integer appId)
            throws SmartAppErrorException, OpenAPIErrorException;
}
