package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.skuresources.Resources;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSubmitSkuDemo {
    public static void main(String[] args) {
        Resources param = new Resources();

        Resources.ActivityInfo activityInfo = new Resources.ActivityInfo();
        activityInfo.setActivityDesc("满10减2");
        activityInfo.setActivityStartTime(1638262693);
        activityInfo.setActivityEndTime(1638262993);
        activityInfo.setActivityPath("/activity/coupon");
        activityInfo.setActivityType("拼团");

        Resources.PriceInfo priceInfo = new Resources.PriceInfo();
        priceInfo.setOrgPrice("300");
        priceInfo.setOrgUnit("天");
        priceInfo.setRealPrice("200");

        param.setActivityInfo( new Resources.ActivityInfo[]{activityInfo});
        param.setPriceInfo(priceInfo);

        param.setTradeType(5001);
        param.setDesc("C 端测试数据");
        param.setImages(new  String[]{"https://mbs1.bdstatic.com/searchbox/" +
                "mappconsole/image/20200623/90466909-d187-4a3e-a9ee-14ec842eae00.jpg"});
        param.setButtonName("预订/立即预订");
        param.setSchema("{\"hotel_name\":\"北京大酒店\"," +
                "\"hotel_addr\":\"北京西城区\",\"hotel_score\":\"4.7分\",\"hotel_star\":\"经济型酒店\"}");
        param.setPath("/pages/detail/detail?id=100031");
        param.setTitle("C 端测试数据");
        param.setTag("饮食健康;中餐");
        param.setRegion("北京市");

        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            String res = smartAppClient.getResourcesService().submitSku(accessToken, new Resources[]{param});
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }

    }
}
