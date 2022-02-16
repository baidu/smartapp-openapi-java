package com.baidu.mapp.developer.coupon;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppUpdateCouponBannerDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            boolean res = smartAppClient.getCouponService().updateCouponBanner(accessToken,
                    "8070208897", "https://mbs1.bdstatic.com/searchbox/mappconsole/image/2" +
                            "0211117/6f9c4a6b-fe7e-4102-b79b-0a7f48e17f20.png",  "修改banner",
                    "/test", 80);
            System.out.println(res);
        } catch (
                SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
