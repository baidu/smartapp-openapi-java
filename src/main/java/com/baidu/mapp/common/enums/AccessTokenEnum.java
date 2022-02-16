package com.baidu.mapp.common.enums;

/**
 * @description: accessToken类型枚举类
 * @author: chenhaonan02
 * @create: 2022-01-18 10:08
 **/

public enum AccessTokenEnum {
    /**
     * OAuth Client Credentials授权模式生成的Access Token
     */
    SMART_APP_TOKEN("24", "OAuth Client Credentials授权模式生成的Access Token"),
    /**
     * TP通过client授权方式生成AccessToken
     */
    SMART_APP_TP_CLIENT_TOKEN("42", "TP通过client授权方式生成AccessToken"),
    /**
     * TP通过官方号授权得到AccessToken
     */
    SMART_APP_TP_AUTHORIZER_ACCESS_TOKEN("45", "TP通过官方号授权得到AccessToken");

    /**
     * accessToken类型
     */
    private String type;
    /**
     * accessToken类型描述
     */
    private String msg;

    AccessTokenEnum(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
