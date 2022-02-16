package com.baidu.mapp.developer.order;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.order.MainOrderData;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppUpdateOrderStatusDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";

        OrderQuery query = new OrderQuery();
        query.setOpenId("k04HEREQhWhWWB7WYqYT3ITUGX");
        query.setSceneID("1698433966726");
        query.setSceneType(2);
        query.setPmAppKey("WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z");

        MainOrderData data = new MainOrderData();
        data.setCateID(5);
        data.setResourceID("G01290942493401602450657344464");
        data.setBizAPPID("WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z");
        data.setStatus(1);

        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            OperationReulst[] res = smartAppClient.getOrderService().updateOrderStatus(accessToken,
                    query, new MainOrderData[]{data});
            System.out.println(res[0]);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }


    }
}
