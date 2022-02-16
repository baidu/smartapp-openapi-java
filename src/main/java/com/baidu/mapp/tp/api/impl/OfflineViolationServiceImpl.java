package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.OfflineViolationService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.tp.bean.violation.ViolationAppDetails;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-09 20:53
 **/
public class OfflineViolationServiceImpl extends BaseService implements OfflineViolationService {

    private static OfflineViolationService offlineViolationService;

    public static OfflineViolationService getInstance() {
        if (offlineViolationService == null) {
            offlineViolationService =
                    ProxyUtil.proxy(new OfflineViolationServiceImpl(), TimeIntervalAspect.class);
        }
        return offlineViolationService;
    }

    @Override
    public Examine updateForOffline(String accessToken, String appName, String appDesc, String photoAddr,
                                    String appNameMaterial) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_name", appName);
        params.put("app_desc", appDesc);
        params.put("photo_addr", photoAddr);
        params.put("app_name_material", appNameMaterial);

        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_OFFLINE_UPDATE, params);

        SmartAppResult<Examine> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Examine>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public ViolationAppDetails getViolationAppInfo(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_VIOLATION, params);

        SmartAppResult<ViolationAppDetails> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<ViolationAppDetails>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
