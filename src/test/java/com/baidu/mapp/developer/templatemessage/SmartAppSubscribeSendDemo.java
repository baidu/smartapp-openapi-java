package com.baidu.mapp.developer.templatemessage;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.templatemessage.MsgKey;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSubscribeSendDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            MsgKey res = smartAppClient.
                    getTemplateMessageService().subscribeSend(accessToken, "84001b219e1940a8b4df49db911a1fb1",
                            "36GetTsw0nWRMVaYnlswLQ9t7y",
                            "xxxxx",
                            "{\"keyword1\": {\"value\": \"2018-09-06\"},\"keyword2\": {\"value\": \"kfc\"}}",
                            "index?foo=bar");

            System.out.println(res.getMsgKey());
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
