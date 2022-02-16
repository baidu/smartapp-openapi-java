package com.baidu.mapp.developer.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-17 19:54
 **/
@Data
public class ApplyOrderRefundClient {
    /**
     * 交易平台订单id
     */
    private Long orderId;
    /**
     * 交易平台用户id
     */
    private Long userId;
    /**
     * 退款类型 1：用户发起退款；2：业务方客服退款；3：业务方服务异常退款
     */
    private Byte refundType;
    /**
     * 退款原因
     */
    private String refundReason;
    /**
     * 业务方订单号
     */
    private String tpOrderId;
    /**
     * 退款金额，单位：分
     */
    private Integer applyRefundMoney;
    /**
     * 业务方退款批次
     */
    private String bizRefundBatchId;
    /**
     * 是否跳过审核 默认不跳过业务方审核 0 不跳过业务方审核 1 跳过业务方审核
     */
    private Byte isSkipAudit;
    /**
     * 退款通知url
     */
    private String refundNotifyUrl;
    /**
     * 交易扩展字段
     */
    private String dealVos;
}