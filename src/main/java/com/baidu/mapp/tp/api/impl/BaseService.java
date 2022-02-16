package com.baidu.mapp.tp.api.impl;

import java.util.HashMap;
import java.util.Map;

import com.baidu.mapp.common.SmartAppConstants;

import cn.hutool.core.util.StrUtil;

/**
 * @author maduo
 */
public abstract class BaseService {

    Map<String, Object> getRequestMapper(String accessToken) {
        Map<String, Object> params = new HashMap<>();
        if (StrUtil.isNotEmpty(accessToken)) {
            params.put("access_token", accessToken);
        }
        params.put("sdk.version", SmartAppConstants.SDK_VERSION);
        params.put("sdk.type", SmartAppConstants.SDK_TYPE);
        return params;
    }
}
