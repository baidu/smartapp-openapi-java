package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.AuthorizationProcessService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.auth.AppInfo;
import com.baidu.mapp.tp.bean.auth.AuthorizationCode;
import com.baidu.mapp.tp.bean.auth.OAuthToken;
import com.baidu.mapp.tp.bean.auth.PreAuthCode;
import com.baidu.mapp.tp.bean.auth.TpAccessToken;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 授权流程实现类
 * @author: chenhaonan02
 * @create: 2021-10-25 14:14
 **/
public class AuthorizationProcessServiceImpl extends BaseService implements AuthorizationProcessService {

    private static AuthorizationProcessService authorizationProcessService;

    public static AuthorizationProcessService getInstance() {
        if (authorizationProcessService == null) {
            authorizationProcessService =
                    ProxyUtil.proxy(new AuthorizationProcessServiceImpl(), TimeIntervalAspect.class);
        }
        return authorizationProcessService;
    }

    @Override
    public TpAccessToken token(String clientId, String ticket) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(null);
        params.put("client_id", clientId);
        params.put("ticket", ticket);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_ACCESS_TOKEN, params);

        SmartAppResult<TpAccessToken> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TpAccessToken>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public PreAuthCode createPreAuthCode(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_PRE_AUTH_CODE, params);

        SmartAppResult<PreAuthCode> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PreAuthCode>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OAuthToken getOAuthToken(String accessToken, String code, String grantType)
            throws OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("code", code);
        params.put("grant_type", grantType);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_AUTH_TOKEN, params);

        OAuthToken result = JSONUtil.toBean(response, new TypeReference<OAuthToken>() {
        }.getType(), true);

        BaiduAssert.notNull(result, response);
        return result;
    }

    @Override
    public OAuthToken refreshOAuthToken(String accessToken, String refreshToken, String grantType)
            throws OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("refresh_token", refreshToken);
        params.put("grant_type", grantType);
        String response = SmartAppHttpUtil.sendHttpGet(TP_REFRESH_AUTH_TOKEN, params);

        OAuthToken result = JSONUtil.toBean(response, new TypeReference<OAuthToken>() {
        }.getType(), true);

        BaiduAssert.notNull(result, response);
        return result;
    }

    @Override
    public AppInfo info(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_APP_INFO, params);
        SmartAppResult<AppInfo> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<AppInfo>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public AuthorizationCode retrieveAuthorizationCode(String accessToken, Integer appId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_RETRIEVE_AUTHORIZATION_CODE, params);

        SmartAppResult<AuthorizationCode> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<AuthorizationCode>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
