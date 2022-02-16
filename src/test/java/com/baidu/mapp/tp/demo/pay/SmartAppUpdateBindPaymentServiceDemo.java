package com.baidu.mapp.tp.demo.pay;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-08 11:03
 **/
public class SmartAppUpdateBindPaymentServiceDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String appName = "xxx";
        String servicePhone = "xxx";
        String bankAccount = "xxx";
        String bankCard = "xxx";
        String bankName = "xxx";
        String bankBranch = "xxx";
        String openProvince = "xxx";
        String openCity = "xxx";
        Integer paymentDays = 0;
        Integer commissionRate = 0;
        Long poolCashPledge = 0L;
        Long dayMaxFrozenAmount = 0L;
        String bankPhoneNumber = "xxx";
        try {
            smartAppThirdPartyClient.getPaymentService().updateBindPaymentService(accessToken, appName, servicePhone, bankAccount,
                    bankCard, bankName, bankBranch, openProvince, openCity, paymentDays, commissionRate, poolCashPledge,
                    dayMaxFrozenAmount, bankPhoneNumber);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
