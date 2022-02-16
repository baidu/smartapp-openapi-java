package com.baidu.mapp.developer.skuresources;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSubmitResourceDemo {
    public static void main(String[] args) {

        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            String res = smartAppClient.getResourcesService().submitResource(accessToken, 24976143,
                    "黄油化开备用，黄油化开后加入糖霜，搅拌均匀，加入蛋清，继续打匀，加入切碎的蔓越莓，" +
                            "继续搅拌。蔓越莓放多少根据自己的喜...",
                    "{\"publish_time\": \"2021年 11 月 1 日\"}",
                    "明星八卦（可选有限集合）",
                    "\"娱乐（可选有限集合）",
                    "[\"https://z3.ax1x.com/2021/11/01/IP3kw9.jpg\"]",
                    "1001", "1000", "/pages/detail/detail?id=100030",
                    "电影", "百度智能小程序，给你全新的智能体验");
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
