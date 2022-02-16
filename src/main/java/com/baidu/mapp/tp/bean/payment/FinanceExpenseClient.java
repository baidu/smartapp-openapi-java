package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 财务-支出
 * @author: chenhaonan02
 * @create: 2021-11-11 15:20
 **/
@Data
public class FinanceExpenseClient {
    /**
     * 金额
     */
    private String money;
    /**
     * 日期
     */
    private String operateTime;
    /**
     * 账期开始时间
     */
    private String startTime;
    /**
     * 类型
     */
    private String typeId;
    /**
     * 账期结束时间
     */
    private String endTime;
    /**
     * 状态
     */
    private String payStatus;
    /**
     * 支付凭证
     */
    private Long taskId;
}
