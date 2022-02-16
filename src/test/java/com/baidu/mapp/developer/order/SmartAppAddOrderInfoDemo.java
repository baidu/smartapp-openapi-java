package com.baidu.mapp.developer.order;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.order.MainOrderEXT;
import com.baidu.mapp.developer.bean.order.MainOrderData;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppAddOrderInfoDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";

        OrderQuery query = new OrderQuery();
        query.setOpenId("k04HEREQhWhWWB7WYqYT3ITUGX");
        query.setSceneID("1698433966726");
        query.setSceneType(2);
        query.setPmAppKey("baiduboxapp");

        MainOrderData data = new MainOrderData();
        data.setCateID(1);
        data.setTitle("test");
        data.setResourceID("1612181027127");
        data.setBizAPPID("WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z");
        data.setCtime(1233212343);
        data.setMtime(1233212343);
        data.setStatus(200);

        MainOrderEXT mainOrderExt = new MainOrderEXT();
        MainOrderEXT.ExtMainOrder mainOrder = new MainOrderEXT.ExtMainOrder();

        MainOrderEXT.ExtMainOrder.Products products = new MainOrderEXT.ExtMainOrder.Products();
        products.setID("1612181027127");
        products.setName("四川大凉山丑苹果脆甜红将军盐源丑苹果");
        products.setDesc("四川大凉山丑苹果脆甜:5斤小果25个左右偏小");
        products.setQuantity(1);
        products.setPrice(2390);
        products.setPayPrice(2390);
        products.setImgList(new String[]{"https://imagelib.cdn.bcebos.com/cip_ml_picbc34db9a-7e10-4a96-" +
                "bf8e-1c690640c6a4.jpeg"});

        MainOrderEXT.ExtMainOrder.Products.DetailPage detailPage = new MainOrderEXT.ExtMainOrder.Products.DetailPage();
        detailPage.setStatus("2");
        detailPage.setSwanSchema("baiduboxapp://swan/B3GF3AWvCSr59myIs61uqaoYz7pPCSY1/wjz/bdxd/ord" +
                "er-detail/order-detail?orderId=159259079195");
        products.setDetailPage(detailPage);

        MainOrderEXT.ExtMainOrder.Products.SkuAttr skuAttr = new MainOrderEXT.ExtMainOrder.Products.SkuAttr();
        skuAttr.setName("四川大凉山丑苹果脆甜");
        skuAttr.setValue("5斤小果25个左右偏小");
        products.setSkuAttr(new MainOrderEXT.ExtMainOrder.Products.SkuAttr[]{ skuAttr });
        mainOrder.setProducts(new MainOrderEXT.ExtMainOrder.Products[]{products});

        MainOrderEXT.ExtMainOrder.Payment  payment = new MainOrderEXT.ExtMainOrder.Payment();
        payment.setTime(0);
        payment.setMethod(1);
        payment.setAmount(2390);
        payment.setPayment(false);
        mainOrder.setPayment(payment);

        MainOrderEXT.ExtMainOrder.Appraise appraise = new MainOrderEXT.ExtMainOrder.Appraise();
        appraise.setStatus(0);
        appraise.setSwanSchema("baiduboxapp://swan/B3GF3AWvCSr59myIs61uqaoYz" +
                "7pPCSY1/wjz/bdxd/order-detail/order-detail?orderId=159259079195");
        mainOrder.setAppraise(appraise);

        MainOrderEXT.ExtMainOrder.OrderDetail orderDetail = new MainOrderEXT.ExtMainOrder.OrderDetail();
        orderDetail.setStatus(0);
        orderDetail.setSwanSchema("baiduboxapp://swan/B3GF3AWvCSr59myIs61uqaoYz7pPCSY1/wjz/bdxd/" +
                "order-detail/order-detail?orderId=159259079195");

        mainOrder.setOrderDetail(orderDetail);
        mainOrderExt.setMainOrder(mainOrder);
        data.setEXT(mainOrderExt);
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            OperationReulst[] res = smartAppClient.getOrderService().addOrderInfo(accessToken,
                    query, new MainOrderData[]{data});
            System.out.println(res[0]);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }

    }
}
