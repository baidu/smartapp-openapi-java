package com.baidu.mapp.tp.demo.pay;

import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.tp.SmartAppThirdPartyClient;
import com.baidu.mapp.tp.bean.payment.TpOrderClient;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-03-03 17:28
 **/
public class SmartAppFindByTpOrderIdDemo {
    public static void main(String[] args) {
        SmartAppThirdPartyClient smartAppThirdPartyClient = new SmartAppThirdPartyClient();
        // 开发者在此设置请求参数，实际参数请参考文档说明填写
        // 如果开发者不想传非必需参数，可以将设置该参数的行注释
        String accessToken = "xxx";
        String pmAppKey = "xxx";
        String tpOrderId = "xxx";
        try {
            TpOrderClient tpOrderClient = smartAppThirdPartyClient.getPaymentService().findByTpOrderId(accessToken,
                    pmAppKey, tpOrderId);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
