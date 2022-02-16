package com.baidu.mapp.tp.api.impl;

import java.util.List;
import java.util.Map;

import com.baidu.mapp.tp.api.PerformanceOptimizationService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.performance.DomainItemCheckResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 性能优化接口实现类
 * @author: chenhaonan02
 * @create: 2021-12-03 16:12
 **/
public class PerformanceOptimizationServiceImpl extends BaseService implements PerformanceOptimizationService {

    private static PerformanceOptimizationService performanceOptimizationService;

    public static PerformanceOptimizationService getInstance() {
        if (performanceOptimizationService == null) {
            performanceOptimizationService =
                    ProxyUtil.proxy(new PerformanceOptimizationServiceImpl(), TimeIntervalAspect.class);
        }
        return performanceOptimizationService;
    }

    @Override
    public DomainItemCheckResult setPrelink(String accessToken, List<String> prelinkUrl)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("prelink_url", prelinkUrl);
        String response = SmartAppHttpUtil.sendHttpPost(PRELINK_SET, params);

        SmartAppResult<DomainItemCheckResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<DomainItemCheckResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<String> getPrelink(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(PRELINK_GET, params);

        SmartAppResult<List<String>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<String>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
