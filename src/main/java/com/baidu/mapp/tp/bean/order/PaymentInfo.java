package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 付款详情
 * @author: chenhaonan02
 * @create: 2021-12-03 17:25
 **/
@Data
public class PaymentInfo {
    /**
     * 付款时间
     */
    private Long time;
    /**
     * 付款方法
     */
    private Integer method;
    /**
     * 优惠信息
     */
    private List<PaymentSpecInfo> preferentialInfo;
    /**
     * 付款信息
     */
    private List<PaymentSpecInfo> paymentInfo;
    /**
     * 合计金额，单位分
     */
    private Long amount;
    /**
     * 是否付款
     */
    private Boolean isPayment;
}
