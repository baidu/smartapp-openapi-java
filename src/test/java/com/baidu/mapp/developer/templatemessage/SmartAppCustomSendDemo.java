package com.baidu.mapp.developer.templatemessage;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppCustomSendDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            boolean res = smartAppClient.getTemplateMessageService().
                    customSend(accessToken, 1, "k04HERDeW-PAGpFWF611R6Vg", "text", "百度改变世界", "");
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
