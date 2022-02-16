package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-17 19:53
 **/
@Data
public class ApplyOrderRefundResponseClient {
    /**
     * 平台退款批次号
     */
    private String refundBatchId;
    /**
     * 平台可退退款金额【分为单位】
     */
    private Integer refundPayMoney;
}