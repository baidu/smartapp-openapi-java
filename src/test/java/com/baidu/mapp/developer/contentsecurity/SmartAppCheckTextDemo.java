package com.baidu.mapp.developer.contentsecurity;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.contentsecurity.CommonCheckResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppCheckTextDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();

        try {
            CommonCheckResult res = smartAppClient.getContentSecurityService().checkText(accessToken,
                    "待检测文本", new String[] {"risk", "lead"});
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
