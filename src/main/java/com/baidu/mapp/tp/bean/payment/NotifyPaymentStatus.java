package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 通知退款状态
 * @author: chenhaonan02
 * @create: 2022-01-18 19:40
 **/
@Data
public class NotifyPaymentStatus {
    /**
     * 用户 Id
     */
    private Long userId;
    /**
     * 订单 Id
     */
    private Long orderId;
    /**
     * 单价
     */
    private Integer unitPrice;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 总金额
     */
    private Integer totalMoney;
    /**
     * 实付金额
     */
    private Integer payMoney;
    /**
     * 营销金额
     */
    private Integer promoMoney;
    /**
     * 红包支付金额
     */
    private Integer hbMoney;
    /**
     * 余额支付金额
     */
    private Integer hbBalanceMoney;
    /**
     * 抵用券金额
     */
    private Integer giftCardMoney;
    /**
     * 百度收银台凭证
     */
    private Long dealId;
    /**
     * 支付时间
     */
    private Integer payTime;
    /**
     * 促销详情
     */
    private Object[] promoDetail;
    /**
     * 支付渠道
     */
    private Integer payType;
    /**
     * 支付平台
     */
    private Integer partnerId;
    /**
     * 订单支付状态
     */
    private Integer status;
    /**
     * 开发者订单 Id
     */
    private String tpOrderId;
    /**
     * 开发者透传数据
     */
    private Object returnData;
    /**
     * rsa 签名
     */
    private String rsaSign;
}