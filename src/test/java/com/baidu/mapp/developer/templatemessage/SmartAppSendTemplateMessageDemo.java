package com.baidu.mapp.developer.templatemessage;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.templatemessage.MsgKey;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSendTemplateMessageDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            MsgKey res = smartAppClient.
                    getTemplateMessageService().sendTemplateMessage(accessToken, "04c6cb35c64841fdb286745b247113b0",
                            "5qFQZgDLuMZsCYYnTc63d24wYb",
                            "{\"keyword1\": {\"value\": \"2018-09-06\"},\"keyword2\": {\"value\": \"kfc\"}}",
                            "1", "13.61dbac9cee28fb767991739574641d17.550928.1635909041.1",
                            1);
            System.out.println(res.getMsgKey());
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
