package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description: 财务-收入其它款项详情
 * @author: chenhaonan02
 * @create: 2021-11-11 15:13
 **/
@Data
public class FinanceBalanceOtherDetailListClient {
    /**
     * 入账金额（元）
     */
    private String totalAmount;
    /**
     * 贷款总额（元）
     */
    private String orderAmount;
    /**
     * 列表数据
     */
    private List<FinanceBalanceOtherDetailClient> data;
    /**
     * 规则类型
     */
    private String ruleType;
    /**
     * 账单周期开始时间
     */
    private String settlementStartTime;
    /**
     * 账单周期结束时间
     */
    private String settlementEndTime;
}
