package com.baidu.mapp.developer.contentsecurity;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.contentsecurity.CommonCheckResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppCheckImageDemo {
    public static void main(String[] args) {
        String accessToken = "24.07be399306db76d52e06a6c5cbb9913e.2592000.1643912228.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            CommonCheckResult res = smartAppClient.getContentSecurityService().checkImage(accessToken,
                    "/root/codes/baidu_smartapp-cserver_openapisdk-java/baidu/smartapp-cserver" +
                            "/openapisdk-java/a.jpg",
                    "porn,ocr-word,ocr-lead");
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }

}
