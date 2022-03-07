package com.baidu.mapp.common;

/**
 * @description: 智能小程序常量类
 * @author: chenhaonan02
 * @create: 2021-09-24 17:30
 **/
public class SmartAppConstants {

    private SmartAppConstants() {
    }

    public static final String OPEN_API_DOMAIN = "https://openapi.baidu.com/";
    public static final String SMART_APP_BASE_URL = "rest/2.0/smartapp/";
    public static final String SMART_APP_BASE_FILE_URL = "file/2.0/smartapp/";
    public static final String SMART_APP_OAUTH = "oauth/2.0/";


    public static final String OPEN_API_SMART_APP_URL = OPEN_API_DOMAIN + SMART_APP_BASE_URL;
    public static final String OPEN_API_SMART_APP_FILE_URL = OPEN_API_DOMAIN + SMART_APP_BASE_FILE_URL;
    public static final String OPEN_API_SMART_APP_OAUTH_URL = OPEN_API_DOMAIN + SMART_APP_OAUTH;


    public static final String SDK_VERSION = "1.1.0-SNAPSHOT";
    public static final String SDK_TYPE = "Java";
}