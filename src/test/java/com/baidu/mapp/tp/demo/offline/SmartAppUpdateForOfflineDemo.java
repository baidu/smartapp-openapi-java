package com.baidu.mapp.tp.demo.offline;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-08 11:03
 **/
public class SmartAppUpdateForOfflineDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String appName = "xxx";
        String appDesc = "xxx";
        String photoAddr = "xxx";
        String appNameMaterial = "xxx";
        try {
            Examine examine = smartAppThirdPartyClient.getOfflineViolationService().updateForOffline(accessToken, appName,
                    appDesc, photoAddr, appNameMaterial);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
