package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppDeleteBJHMaterialDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            boolean res = smartAppClient.getResourcesService().deleteBJHMaterial(
                    accessToken, 17900514, 10161, "/pages/index/index");
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
