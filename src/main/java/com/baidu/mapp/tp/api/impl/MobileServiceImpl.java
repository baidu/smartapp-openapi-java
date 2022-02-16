package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.MobileService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.mobile.MobileAuthStatus;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 获取手机号接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-10 17:16
 **/
public class MobileServiceImpl extends BaseService implements MobileService {

    private static MobileService mobileService;

    public static MobileService getInstance() {
        if (mobileService == null) {
            mobileService =
                    ProxyUtil.proxy(new MobileServiceImpl(), TimeIntervalAspect.class);
        }
        return mobileService;
    }

    @Override
    public void applyMobileAuth(String accessToken, Integer reason, Integer usedScene, String sceneDesc,
                                String sceneDemo) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("reason", reason);
        params.put("used_scene", usedScene);
        params.put("scene_desc", sceneDesc);
        params.put("scene_demo", sceneDemo);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_APPLY_MOBILE_AUTH, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void cancelMobileAuth(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_CANCEL_MOBILE_AUTH, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public MobileAuthStatus getMobileAuthStatus(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_GET_MOBILE_AUTH_STATUS, params);

        SmartAppResult<MobileAuthStatus> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MobileAuthStatus>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
