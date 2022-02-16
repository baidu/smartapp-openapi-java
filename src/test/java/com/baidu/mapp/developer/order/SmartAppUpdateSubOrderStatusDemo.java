package com.baidu.mapp.developer.order;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.developer.bean.order.SubsOrderData;
import com.baidu.mapp.developer.bean.order.SubsOrderEXT;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppUpdateSubOrderStatusDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";

        OrderQuery query = new OrderQuery();
        query.setOpenId("k04HEREQhWhWWB7WYqYT3ITUGX");
        query.setSceneID("1698433966726");
        query.setSceneType(2);
        query.setPmAppKey("WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z");

        SubsOrderData data = new SubsOrderData();
        data.setCateID(1);
        data.setResourceID("1612181027127");
        data.setBizAPPID("WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z");

        SubsOrderEXT ext = new SubsOrderEXT();
        SubsOrderEXT.SubsOrder subsorder = new SubsOrderEXT.SubsOrder();
        subsorder.setStatus(403);

        SubsOrderEXT.SubsOrder.SubsOrderEXTItem item = new SubsOrderEXT.SubsOrder.SubsOrderEXTItem();
        item.setSubOrderID("onlyOne");
        item.setSubStatus(403);
        subsorder.setItems(new SubsOrderEXT.SubsOrder.SubsOrderEXTItem[]{item});
        ext.setSubsOrder(subsorder);

        data.setEXT(ext);

        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            OperationReulst[] res = smartAppClient.getOrderService().updateSubOrderStatus(accessToken,
                    query, new SubsOrderData[]{data});
            System.out.println(res[0]);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
