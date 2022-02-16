package com.baidu.mapp.developer.coupon;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.copuon.BaseInfo;
import com.baidu.mapp.developer.bean.copuon.CouponId;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppCreateCouponDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();


        try {
            BaseInfo baseInfo = new BaseInfo();
            baseInfo.setTitle("自动化创建代金券100-10");
            baseInfo.setColor("B080");
            baseInfo.setGetLimit(3);
            baseInfo.setCodeType(1);
            baseInfo.setQuantity(100);
            BaseInfo.DateInfo dataInfo = new BaseInfo.DateInfo();
            dataInfo.setGetStartTimestamp(1637042658);
            dataInfo.setGetEndTimestamp(1668578658);
            dataInfo.setType(1);
            dataInfo.setTimeUnit(2);
            dataInfo.setTimeValue(2);
            dataInfo.setBeginTimestamp(1637042658);
            dataInfo.setEndTimestamp(1668578658);
            baseInfo.setDateInfo(dataInfo);

            CouponId res = smartAppClient.getCouponService().createCoupon(accessToken,
                    "CASH", 10000,
                    1000, "80",
                    baseInfo, "使用描述", "/test");
            System.out.println(res);
        } catch (
                SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
