package com.baidu.mapp.developer.contentsecurity;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppCheckPathDemo {
    public static void main(String[] args) {
        String accessToken = "24.07be399306db76d52e06a6c5cbb9913e.2592000.1643912228.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            String res = smartAppClient.getContentSecurityService().checkPath(accessToken,
                    "/pages/article/article?id=45925&amp;type=0",
                    new String[] { "risk", "porn", "ocr-word", "ocr-lead"});
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
