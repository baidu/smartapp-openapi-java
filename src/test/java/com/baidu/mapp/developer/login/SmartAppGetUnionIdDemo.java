package com.baidu.mapp.developer.login;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.login.UnionId;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppGetUnionIdDemo {
    public static void main(String[] args) {
        SmartAppClient smartAppClient = new SmartAppClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "24.3b9506c35ba3a2c995d2adc7f3954fdb.2592000.1642731700.282335-24976143";
        String openId = "k04HERDeW-PAGpFWF611R6Vg";

        try {
            UnionId unionId = smartAppClient.getLoginService().getUnionId(accessToken, openId);
            System.out.println(unionId.getUnionid());
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
