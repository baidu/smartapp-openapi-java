package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description: 财务-支出打款详情
 * @author: chenhaonan02
 * @create: 2021-11-11 15:24
 **/
@Data
public class FinanceExpensePayDetailListClient {
    private List<FinanceExpensePayDetailClient> data;
}
