package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.skuresources.BJHMaterial;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppModifyBJHMaterialDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            BJHMaterial bjhMaterial = new BJHMaterial();
            bjhMaterial.setAppId(17900514);
            bjhMaterial.setImageUrl("https://mbs1.bdstatic.com/searchbox/mappconsole" +
                    "/image/20211101/d80d2181-abf5-4d50-a5c6-df5e7b37396b.png");
            bjhMaterial.setTitle("修改测试数据");
            bjhMaterial.setPath("/pages/index/index");
            bjhMaterial.setCategory1Code("7");
            bjhMaterial.setCategory2Code("70001");
            boolean res = smartAppClient.getResourcesService().modifyBJHMaterial(
                    accessToken, bjhMaterial);
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
