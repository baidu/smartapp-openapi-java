package com.baidu.mapp.developer.order;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.developer.bean.order.SubsOrderData;
import com.baidu.mapp.developer.bean.order.SubsOrderEXT;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppUpdateSubOrderInfoDemo {
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


        SubsOrderEXT subsOrderEXT = new SubsOrderEXT();
        SubsOrderEXT.SubsOrder subsOrder = new SubsOrderEXT.SubsOrder();
        subsOrder.setStatus(0);
        SubsOrderEXT.SubsOrder.SubsOrderEXTItem item = new SubsOrderEXT.SubsOrder.SubsOrderEXTItem();

        item.setSubOrderID("onlyOne");
        item.setSubStatus(401);
        item.setCTime(1571026203);
        item.setMTime(1571026203);
        item.setOrderType(1);

        SubsOrderEXT.SubsOrder.OrderDetail orderDetail = new SubsOrderEXT.SubsOrder.OrderDetail();
        orderDetail.setStatus("3");
        orderDetail.setSwanSchema("baiduboxapp://swan/B3GF3AWvCSr59myIs61uqaoY" +
                "z7pPCSY1/wjz/bdxd/order-detail/order-detail?orderId=159259079195");
        item.setOrderDetail(orderDetail);

        SubsOrderEXT.SubsOrder.Refund refund = new SubsOrderEXT.SubsOrder.Refund();
        refund.setAmount(1000);
        SubsOrderEXT.SubsOrder.Refund.Product product = new SubsOrderEXT.SubsOrder.Refund.Product();
        product.setID("101409306478");
        product.setQuantity(1);
        product.setAmount(100);
        refund.setProduct(new SubsOrderEXT.SubsOrder.Refund.Product[]{product});
        item.setRefund(refund);

        subsOrder.setItems(new SubsOrderEXT.SubsOrder.SubsOrderEXTItem[]{item});
        subsOrderEXT.setSubsOrder(subsOrder);
        data.setEXT(subsOrderEXT);

        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            OperationReulst[] res = smartAppClient.getOrderService().updateSubOrderInfo(accessToken,
                    query, new SubsOrderData[]{data});
            System.out.println(res[0]);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
