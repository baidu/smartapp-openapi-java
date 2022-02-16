package com.baidu.mapp.tp.demo.feed;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-08 11:03
 **/
public class SmartAppAccessResourceSubmitDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String title = "xxx";
        String body = "xxx";
        String path = "xxx";
        String images = "xxx";
        Long mappType = 0L;
        Long mappSubType = 0L;
        String feedType = "xxx";
        String feedSubType = "xxx";
        String tags = "xxx";
        String ext = "xxx";
        try {
            String accessResourceSubmit = smartAppThirdPartyClient.getFeedService().accessResourceSubmit(accessToken, title,
                    body, path, images, mappType, mappSubType, feedType, feedSubType, tags, ext);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
