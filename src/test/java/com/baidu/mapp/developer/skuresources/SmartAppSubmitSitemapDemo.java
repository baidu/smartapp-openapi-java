package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSubmitSitemapDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            String res = smartAppClient.getResourcesService().submitSitmap(accessToken, 17900514,
                    "智能小程序示例" +
                            "继续搅拌。蔓越莓放多少根据自己的喜...",
                    "3",
                    "1",
                    "https://mbs1.bdstatic.com/searchbox/mappconsole/image" +
                            "/20210411/115c70eb-e461-4b58-88ed-7f329a4e0d37.json");
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
