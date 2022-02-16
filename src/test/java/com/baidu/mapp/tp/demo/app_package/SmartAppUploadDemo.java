package com.baidu.mapp.tp.demo.app_package;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-07 21:07
 **/
public class SmartAppUploadDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        Long templateId = 0L;
        String extJson = "xxx";
        String userVersion = "xxx";
        String userDesc = "xxx";
        String testAccount = "xxx";
        String testPassword = "xxx";
        try {
            smartAppThirdPartyClient.getPackageManagementService().upload(accessToken, templateId, extJson, userVersion,
                    userDesc, testAccount, testPassword);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
