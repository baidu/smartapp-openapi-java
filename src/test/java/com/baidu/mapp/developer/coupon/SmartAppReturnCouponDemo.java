package com.baidu.mapp.developer.coupon;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppReturnCouponDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            boolean res = smartAppClient.getCouponService().returnCoupon(accessToken, "8070208897",
                    "k04HEREQhWhWWB7WYqYT3ITUGX", 8102216835L);
            System.out.println(res);
        } catch (
                SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
