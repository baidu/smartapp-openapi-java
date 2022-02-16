package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppDeleteSkuDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            String res = smartAppClient.getResourcesService().deleteSku(
                    accessToken, 176565381,
                    "[\"/pages/detail/detail?id=100031\",\"/pages/detail/detail?id=100002\"]");
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
