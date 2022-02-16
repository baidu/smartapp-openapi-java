package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.skuresources.Resources;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSubmitSkuCoupon {
    public static void main(String[] args) {

        Resources param = new Resources();

        Resources.ActivityInfo activityInfo = new Resources.ActivityInfo();
        activityInfo.setActivityDesc("满10减2");
        activityInfo.setActivityStartTime(1638262693);
        activityInfo.setActivityEndTime(1638262993);
        activityInfo.setActivityPath("/activity/coupon");
        activityInfo.setActivityType("拼团");

        Resources.PriceInfo priceInfo = new Resources.PriceInfo();
        priceInfo.setOrgPrice("1990");
        priceInfo.setOrgUnit("天");
        priceInfo.setRealPrice("990");

        param.setActivityInfo( new Resources.ActivityInfo[]{activityInfo});
        param.setPriceInfo(priceInfo);

        param.setTradeType(2004);
        param.setDesc("C 端测试数据");
        param.setImages(new  String[]{"https://mbs1.bdstatic.com/searchbox/mappconsole/" +
                "image/20200623/90466909-d187-4a3e-a9ee-14ec842eae00.jpg"});

        param.setSchema("{\"coupon_brand_name\":\"三只松鼠\",\"collect_coupon_begin_time\":\"2021-12-20 23:12:12\"," +
                "\"coupon_use_time\":\"2021-12-21 00:00:00~2022-12-01 00:00:00\",\"coupon_sort\":\"PAY\"," +
                "\"collect_coupon_end_time\":\"2022-02-02 12:12:12\",\"coupon_brand_logo\":" +
                "[\"https://mbs1.bdstatic.com/searchbox/mappconsole/image/20210812/e29a9068-53f9-4ba0-aa1f-71c4e" +
                "256f1ad.jpg\"],\"coupon_stock_value\":30,\"adapt_system_types\":[\"android\"]}");

        param.setPath("/test/test/coupon000130");
        param.setTitle("C 端测试数据");
        param.setTag("饮食健康;中餐");
        param.setRegion("北京市");

        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            String res = smartAppClient.getResourcesService().submitSkuCoupon(accessToken, new Resources[]{param});
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }

    }
}
