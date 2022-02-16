package com.baidu.mapp.developer.contentsecurity;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppMisjudgeFeedbackDemo {
    public static void main(String[] args) {
        String accessToken = "24.07be399306db76d52e06a6c5cbb9913e.2592000.1643912228.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();

        try {
             boolean res = smartAppClient.getContentSecurityService().misjudgeFeedback(accessToken,
                    "9cb878e0690064803952506287361297db1f37df76f5c084600960e878bc9");
             System.out.println(res);
        } catch (SmartAppErrorException e) {
            e.printStackTrace();
        }
    }
}
