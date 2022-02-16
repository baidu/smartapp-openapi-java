package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.login.AppLogin;
import com.baidu.mapp.tp.bean.login.UnionId;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 小程序登录接口
 * @author: chenhaonan02
 * @create: 2021-11-10 15:33
 **/
public interface AppLoginService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "AppLoginService";
    /**
     * 授权小程序登录
     */
    String TP_APP_LOGIN = SmartAppConstants.OPEN_API_DOMAIN + "rest/2.0/oauth/getsessionkeybycode";
    /**
     * 获取unionid
     * https://smartprogram.baidu.com/docs/third/login/unionid/
     */
    String TP_GET_UNION_ID = SmartAppConstants.OPEN_API_SMART_APP_URL + "unionId/get";

    /**
     * 授权小程序登录
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param code        调用 swan.login 后获取的 code
     * @param grantType   授权类型，固定字符串：“authorization_code”
     *
     * @return AppLogin
     *
     * @throws OpenAPIErrorException OpenAPI异常类
     */
    AppLogin appLogin(String accessToken, String code, String grantType)
            throws OpenAPIErrorException;

    /**
     * 获取unionid
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param openId      用户 openid ，需要经过用户登录授权
     *
     * @return UnionId
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    UnionId getUnionId(String accessToken, String openId) throws SmartAppErrorException, OpenAPIErrorException;
}
