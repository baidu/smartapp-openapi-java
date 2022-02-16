package com.baidu.mapp.tp.demo.data;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.data.MTJDataStatisticsResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-08 11:03
 **/
public class SmartAppGetAnalysisRetainedUserDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String reportType = "xxx";
        Integer startIndex = 0;
        String startDate = "xxx";
        String endDate = "xxx";
        String gran = "xxx";
        try {
            MTJDataStatisticsResult analysisRetainedUser = smartAppThirdPartyClient.getDataStatisticsService()
                    .getAnalysisRetainedUser(accessToken, reportType, startIndex, startDate, endDate, gran);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
