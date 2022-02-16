package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.json.JSONUtil;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.RiskControlService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.common.validator.BaiduAssert;
import cn.hutool.core.lang.TypeReference;


import java.util.Map;

public class RiskControlServiceImpl  extends BaseService implements RiskControlService {

    private static RiskControlService riskControlService;

    public static RiskControlService getInstance() {
        if (riskControlService == null) {
            riskControlService = ProxyUtil.proxy(new RiskControlServiceImpl(), TimeIntervalAspect.class);
        }
        return riskControlService;
    }

    @Override
    public String detectRisk(String accessToken, String appkey, String xtoken, String type, String clientip,
                             int ts, String ev, String useragent, String phone) throws
            SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("appkey", appkey);
        params.put("xtoken", xtoken);
        params.put("type", type);
        params.put("clientip", clientip);
        params.put("ts", ts);
        params.put("ev", ev);
        params.put("useragent", useragent);
        params.put("phone", phone);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DETECT_RISK,  params);
        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();

    }
}
