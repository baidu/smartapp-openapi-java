package com.baidu.mapp.common.config;

import lombok.Data;

/**
 * @description: 智能小程序HTTP配置类
 * @author: chenhaonan02
 * @create: 2021-09-27 15:39
 **/
@Data
public class SmartAppConfig {
    private int defaultSocketTimeout = 10000;
    private int defaultConnectTimeout = 10000;
    private int defaultConnectionRequestTimeout = 10000;
    private int defaultReadTimeout = 10000;
    private int retry = 3;
    private boolean blockSensitiveLog = false;

    private static SmartAppConfig smartAppConfig = getInstance();

    private SmartAppConfig() {
    }

    public static SmartAppConfig getInstance() {
        if (smartAppConfig == null) {
            smartAppConfig = new SmartAppConfig();
        }
        return smartAppConfig;
    }
}
