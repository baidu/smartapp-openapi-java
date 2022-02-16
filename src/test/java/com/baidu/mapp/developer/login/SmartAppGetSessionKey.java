package com.baidu.mapp.developer.login;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.login.SessionKey;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppGetSessionKey {
    public static void main(String[] args) {
        SmartAppClient smartAppClient = new SmartAppClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        String code = "50874b4600351fe7040782aae118cddaNW";
        try {
            SessionKey sessionKey = smartAppClient.getLoginService().getSessionKey(accessToken, code);
            System.out.println(sessionKey);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
