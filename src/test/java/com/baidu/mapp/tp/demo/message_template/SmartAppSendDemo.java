package com.baidu.mapp.tp.demo.message_template;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.subscription.PushTemplateMessage;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-08 11:03
 **/
public class SmartAppSendDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String templateId = "xxx";
        String touser = "xxx";
        String touserOpenId = "xxx";
        String data = "xxx";
        String page = "xxx";
        String sceneId = "xxx";
        Integer sceneType = 0;
        String title = "xxx";
        String ext = "xxx";
        String description = "xxx";
        try {
            PushTemplateMessage send = smartAppThirdPartyClient.getTemplateMessageService().send(accessToken, templateId, touser,
                    touserOpenId, data, page, sceneId, sceneType, title, ext, description);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
