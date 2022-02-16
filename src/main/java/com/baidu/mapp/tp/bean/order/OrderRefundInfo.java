package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 售后信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:34
 **/
@Data
public class OrderRefundInfo {
    /**
     * 子订单ID
     */
    private String subOrderID;
    /**
     * 子订单状态
     */
    private Integer subStatus;
    /**
     * 子订单创建时间
     */
    private Long ctime;
    /**
     * 子订单创建时间
     */
    private Long mtime;
    /**
     * 退款订单类型
     */
    private Integer orderType;
    /**
     * 订单售后详情链接
     */
    private PageInfo orderDetailUrl;
    /**
     * 跳转连接列表
     */
    private List<PageInfo> urlList;
    /**
     * 商品退款信息
     */
    private RefundProductInfo refund;
    /**
     * 商品退换货售后
     */
    private AftermarketInfo aftermarket;
    /**
     * 退换货额外付款信息
     */
    private PaymentInfo payment;
}
