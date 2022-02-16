package com.baidu.mapp.developer.qrcode;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.qrcode.QRCodeData;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppGetQrCodeDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();

        try {
            QRCodeData res = smartAppClient.getQrCodeService().getQrCode(accessToken, "pages/index/index",
                    500, 0, 1);
            System.out.println(res.getBase64Str());
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
