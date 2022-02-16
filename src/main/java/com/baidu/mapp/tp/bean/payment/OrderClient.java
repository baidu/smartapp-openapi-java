package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 订单流水详情
 * @author: chenhaonan02
 * @create: 2021-11-11 14:54
 **/
@Data
public class OrderClient {
    private String id;
    private String dealId;
    /**
     * 商品名
     */
    private String dealTitle;
    /**
     * 平台订单号
     */
    private String orderId;
    /**
     * 第三方订单号
     */
    private String tpOrderId;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 订单创建时间
     */
    private String createTime;
    /**
     * 订单完成时间
     */
    private String updateTime;
    /**
     * 订单状态
     * 1:待付款
     * 2:已付款
     * 3:已消费
     * 4:退款中
     * 5:已退款
     * 6:退款失败
     * 7:已取消
     */
    private String subStatus;
    /**
     * 订单金额(分)
     */
    private String totalMoney;
    /**
     * 支付金额(分)
     */
    private String payMoney;
    /**
     * 退款金额(分)
     */
    private String segmentRefundedMoney;
    /**
     * 支付渠道
     */
    private String channel;
}
