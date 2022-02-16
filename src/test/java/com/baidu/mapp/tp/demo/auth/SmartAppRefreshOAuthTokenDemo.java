package com.baidu.mapp.tp.demo.auth;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.auth.OAuthToken;
import com.baidu.mapp.common.error.OpenAPIErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-06 15:01
 **/
public class SmartAppRefreshOAuthTokenDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String refreshToken = "xxx";
        String grantType = "xxx";
        try {
            OAuthToken oAuthToken = smartAppThirdPartyClient.getAuthorizationProcessService().
                    refreshOAuthToken(accessToken, refreshToken, grantType);
        } catch (OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}