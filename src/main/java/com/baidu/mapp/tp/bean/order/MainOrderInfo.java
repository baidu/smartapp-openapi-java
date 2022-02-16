package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 主订单信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:18
 **/
@Data
public class MainOrderInfo {
    /**
     * 商品信息
     */
    private List<ProductInfo> products;
    /**
     * 付款信息
     */
    private PaymentInfo payment;
    /**
     * 订单详情链接
     */
    private PageInfo appraise;
    /**
     * 订单详情链接
     */
    private PageInfo orderDetailUrl;
    /**
     * 跳转连接列表
     */
    private List<PageInfo> urlList;
    /**
     * 物流信息
     */
    private List<ExpressInfo> expressInfo;
}
