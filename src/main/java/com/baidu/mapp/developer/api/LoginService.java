package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.GetAccessTokenException;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.developer.bean.login.AccessToken;
import com.baidu.mapp.developer.bean.login.SessionKey;
import com.baidu.mapp.developer.bean.login.UnionId;

public interface LoginService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "LoginService";
    /**
     * 获取unionid
     * https://smartprogram.baidu.com/docs/develop/api/open/log_getunionid/
     */
    String LOGIN_GET_UNION_ID = SmartAppConstants.OPEN_API_SMART_APP_URL + "getunionid";

    /**
     * getsessionkey
     * https://smartprogram.baidu.com/docs/develop/api/open/getSessionKey/
     */
    String LOGIN_GET_SESSIONKEY = SmartAppConstants.OPEN_API_SMART_APP_URL + "getsessionkey";

    /**
     * getAccessToken
     * https://smartprogram.baidu.com/docs/develop/serverapi/power_exp/
     */
    String LOGIN_GET_ACCESS_TOKEN = SmartAppConstants.OPEN_API_SMART_APP_OAUTH_URL + "token";

    /**
     * 获取unionid
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param openId      用户 openid ，需要经过用户登录授权
     *
     * @return UnionId
     *
     * @throws SmartAppErrorException 智能小程序异常类
     */
    UnionId getUnionId(String accessToken, String openId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 通过code换取sessionkey
     *
     * @param accessToken
     * @param code
     *
     * @return
     *
     * @throws SmartAppErrorException
     */
    SessionKey getSessionKey(String accessToken, String code) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取Acesstoken
     *
     * @param clientID
     * @param clientSecret
     *
     * @return
     *
     * @throws GetAccessTokenException
     */
    AccessToken getGetAccessToken(String clientID, String clientSecret) throws GetAccessTokenException;
}
