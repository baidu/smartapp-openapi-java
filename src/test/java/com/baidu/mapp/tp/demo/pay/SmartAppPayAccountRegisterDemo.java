package com.baidu.mapp.tp.demo.pay;

import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-08 11:03
 **/
public class SmartAppPayAccountRegisterDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String businessScope = "xxx";
        String businessProvince = "xxx";
        String businessCity = "xxx";
        String businessDetailAddress = "xxx";
        String legalPerson = "xxx";
        String legalId = "xxx";
        String idCardFrontUrl = "xxx";
        String idCardBackUrl = "xxx";
        String legalCardStartTime = "xxx";
        String legalCardEndTime = "xxx";
        String licenseStartTime = "xxx";
        String licenseEndTime = "xxx";
        Integer industryId = 0;
        String managePermitUrl = "xxx";
        Long authCapital = 0L;
        Integer managerSame = 0;
        String manager = "xxx";
        String managerCard = "xxx";
        String managerCardType = "xxx";
        String managerCardFrontUrl = "xxx";
        String managerCardBackUrl = "xxx";
        String managerCardStartTime = "xxx";
        String managerCardEndTime = "xxx";
        Integer benefitSame = 0;
        String benefit = "xxx";
        String benefitCard = "xxx";
        String benefitCardType = "xxx";
        String benefitCardFrontUrl = "xxx";
        String benefitCardBackUrl = "xxx";
        String benefitStartTime = "xxx";
        String benefitEndTime = "xxx";
        try {
            smartAppThirdPartyClient.getPaymentService().payAccountRegister(accessToken, businessScope, businessProvince,
                    businessCity, businessDetailAddress, legalPerson, legalId, idCardFrontUrl, idCardBackUrl,
                    legalCardStartTime, legalCardEndTime, licenseStartTime, licenseEndTime, industryId, managePermitUrl,
                    authCapital, managerSame, manager, managerCard, managerCardType, managerCardFrontUrl,
                    managerCardBackUrl, managerCardStartTime, managerCardEndTime, benefitSame, benefit, benefitCard,
                    benefitCardType, benefitCardFrontUrl, benefitCardBackUrl, benefitStartTime, benefitEndTime);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
