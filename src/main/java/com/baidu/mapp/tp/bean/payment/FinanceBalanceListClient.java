package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description: 财务-收入列表
 * @author: chenhaonan02
 * @create: 2021-11-11 15:01
 **/
@Data
public class FinanceBalanceListClient {
    /**
     * 货款（元）
     */
    private String income;
    /**
     * 当前付款周期（天）
     */
    private Long period;
    /**
     * 列表数据
     */
    private List<FinanceBalanceClient> data;
    /**
     * 调整款（元）
     */
    private String adjustment;
    /**
     * 账户余额（元）
     */
    private String freeBalance;
    /**
     * 支付时间
     */
    private String paymentDue;
    /**
     * 其它款项（元）
     */
    private String others;

    private Long pageSize;

    private Long totalCount;

    private Long currentPage;
}
