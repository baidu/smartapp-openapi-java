package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 财务-收入详细信息
 * @author: chenhaonan02
 * @create: 2021-11-11 15:02
 **/
@Data
public class FinanceBalanceClient {
    /**
     * 货款（元）
     */
    private String income;
    /**
     * 日期
     */
    private String operateTime;
    /**
     * 调整款（元）
     */
    private String adjustAmount;
    /**
     * 其他款项
     */
    private String others;
}
