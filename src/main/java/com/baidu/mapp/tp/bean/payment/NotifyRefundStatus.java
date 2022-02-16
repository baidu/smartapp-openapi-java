package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 通知退款状态
 * @author: chenhaonan02
 * @create: 2022-01-18 20:27
 **/
@Data
public class NotifyRefundStatus {
    /**
     * 用户 Id
     */
    private Long userId;
    /**
     * 订单 Id
     */
    private Long orderId;
    /**
     * 开发者订单 Id
     */
    private String tpOrderId;
    /**
     * 退款批次号
     */
    private String refundBatchId;
    /**
     * 退款状态
     */
    private Integer refundStatus;
    /**
     * 参数签名
     */
    private String rsaSign;
}