package com.baidu.mapp.developer.api;

import cn.hutool.core.util.StrUtil;
import com.baidu.mapp.common.SmartAppConstants;

import java.util.HashMap;
import java.util.Map;

public class BaseService {
    public Map<String, Object> getRequestMapper(String accessToken) {
        Map<String, Object> params = new HashMap<>();
        if (StrUtil.isNotEmpty(accessToken)) {
            params.put("access_token", accessToken);
        }
        params.put("sdk.version", SmartAppConstants.SDK_VERSION);
        params.put("sdk.type", SmartAppConstants.SDK_TYPE);
        return params;
    }
}
