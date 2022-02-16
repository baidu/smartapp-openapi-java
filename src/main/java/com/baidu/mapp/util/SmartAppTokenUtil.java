package com.baidu.mapp.util;

import java.util.Arrays;

import com.baidu.mapp.common.enums.AccessTokenEnum;

/**
 * @description: 智能小程序accessToken类型工具类
 * @author: chenhaonan02
 * @create: 2022-01-19 20:25
 **/
public class SmartAppTokenUtil {
    public static AccessTokenEnum getAccessTokenType(String accessToken) {
        String type = accessToken.split("\\.")[0];
        AccessTokenEnum[] values = AccessTokenEnum.values();
        return Arrays.stream(values).filter(x -> x.getType().equals(type)).findFirst().orElse(null);
    }
}