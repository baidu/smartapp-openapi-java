package com.baidu.mapp.developer.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-17 20:35
 **/
@Data
public class OrderRefundDetailClient {
    /**
     * 退款批次 Id
     */
    private Long refundBatchId;
    /**
     * 业务方退款批次 Id
     */
    private String bizRefundBatchId;
    /**
     * 退款订单号
     */
    private Long orderId;
    /**
     * 退款用户 Id
     */
    private Long userId;
    /**
     * 退款状态 1 退款中 2 退款成功 3 退款失败
     */
    private Byte refundStatus;
}