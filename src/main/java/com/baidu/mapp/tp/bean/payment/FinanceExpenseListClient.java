package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description: 财务-支出打款列表
 * @author: chenhaonan02
 * @create: 2021-11-11 15:19
 **/
@Data
public class FinanceExpenseListClient {
    /**
     * 支出次数
     */
    private Long expenseCount;
    /**
     * 列表数据
     */
    private List<FinanceExpenseClient> data;
    /**
     * 支出金额（元）
     */
    private String expenseMoney;
    /**
     * 数据总条数
     */
    private Long totalCount;
}
