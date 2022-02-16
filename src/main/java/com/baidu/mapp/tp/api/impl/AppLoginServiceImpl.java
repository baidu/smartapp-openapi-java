package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.AppLoginService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.login.AppLogin;
import com.baidu.mapp.tp.bean.login.UnionId;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 小程序登录接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-10 15:37
 **/
public class AppLoginServiceImpl extends BaseService implements AppLoginService {

    private static AppLoginService appLoginService;

    public static AppLoginService getInstance() {
        if (appLoginService == null) {
            appLoginService = ProxyUtil.proxy(new AppLoginServiceImpl(), TimeIntervalAspect.class);
        }
        return appLoginService;
    }

    @Override
    public AppLogin appLogin(String accessToken, String code, String grantType)
            throws OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("code", code);
        params.put("grant_type", grantType);
        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_LOGIN, params);

        AppLogin result = JSONUtil.toBean(response, new TypeReference<AppLogin>() {
        }.getType(), true);

        BaiduAssert.notNull(result, response);
        return result;
    }

    @Override
    public UnionId getUnionId(String accessToken, String openId) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", openId);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_UNION_ID, params);

        SmartAppResult<UnionId> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<UnionId>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
