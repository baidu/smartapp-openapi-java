package com.baidu.mapp.developer.api.impl;

import java.util.Map;

import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.SmartAppResultC;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.LoginService;
import com.baidu.mapp.developer.bean.login.SessionKey;
import com.baidu.mapp.developer.bean.login.UnionId;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

public class LoginServiceImpl extends BaseService implements LoginService {
    private static LoginService loginService;

    public static LoginService getInstance() {
        if (loginService == null) {
            loginService = ProxyUtil.proxy(new LoginServiceImpl(), TimeIntervalAspect.class);
        }
        return loginService;
    }

    @Override
    public UnionId getUnionId(String accessToken, String openId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("openid", openId);

        String response = SmartAppHttpUtil.sendHttpPost(LOGIN_GET_UNION_ID, params);
        System.out.println(response);
        SmartAppResultC<UnionId> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<UnionId>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public SessionKey getSessionKey(String accessToken, String code) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("code", code);
        String response = SmartAppHttpUtil.sendHttpPost(LOGIN_GET_SESSIONKEY, params);
        System.out.println(response);
        SmartAppResultC<SessionKey> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<SessionKey>>() {
                }.getType(), true);
        BaiduAssert.error(result, response);
        return result.getData();
    }
}