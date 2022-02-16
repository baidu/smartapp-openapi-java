package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description: 财务-收入货款详情
 * @author: chenhaonan02
 * @create: 2021-11-11 15:07
 **/
@Data
public class FinanceBalanceIncomeDetailListClient {
    /**
     * 货款（元）
     */
    private String income;
    /**
     * 验证（成交）数量
     */
    private Long quantity;
    /**
     * 列表数据
     */
    private List<FinanceBalanceIncomeDetailClient> data;
    /**
     * 日期
     */
    private String operateTime;
    /**
     * 验证(成交)总额（元）
     */
    private String incomeAmount;
    /**
     * 退款总额（元）
     */
    private String refundAmount;

    private Long pageSize;

    private Long totalCount;

    private Long currentPage;
}

