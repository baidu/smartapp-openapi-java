package com.baidu.mapp.developer.order;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.order.MainOrderData;
import com.baidu.mapp.developer.bean.order.MainOrderEXT;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppSubmitLogisticsDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";

        OrderQuery query = new OrderQuery();
        query.setOpenId("k04HEREQhWhWWB7WYqYT3ITUGX");
        query.setSceneID("1698433966726");
        query.setSceneType(2);
        query.setPmAppKey("baiduboxapp");

        MainOrderData data = new MainOrderData();
        data.setCateID(2);
        data.setResourceID("1612181027127");
        data.setBizAPPID("WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z");

        MainOrderEXT mainOrderExt = new MainOrderEXT();
        MainOrderEXT.ExtMainOrder mainOrder = new MainOrderEXT.ExtMainOrder();

        MainOrderEXT.ExtMainOrder.Express express = new MainOrderEXT.ExtMainOrder.Express();
        express.setID("1014093064");
        express.setName("顺丰快递");
        express.setCode("SFEXPRESS");
        express.setType(1);
        express.setStatus(0);
        mainOrder.setExpress(new MainOrderEXT.ExtMainOrder.Express[]{express});
        mainOrderExt.setMainOrder(mainOrder);
        data.setEXT(mainOrderExt);
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            OperationReulst[] res = smartAppClient.getOrderService().submitLogisticsOrder(accessToken,
                    query, new MainOrderData[]{data});
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
