package com.baidu.mapp.tp.demo.app_package;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.pkg.PackageResp;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-07 21:07
 **/
public class SmartAppSubmitAuditDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String content = "xxx";
        Long packageId = 0L;
        String remark = "xxx";
        String testAccount = "xxx";
        String testPassword = "xxx";
        try {
            PackageResp packageResp = smartAppThirdPartyClient.getPackageManagementService().submitAudit(accessToken, content,
                    packageId, remark, testAccount, testPassword);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
