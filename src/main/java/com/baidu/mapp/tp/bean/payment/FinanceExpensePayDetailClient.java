package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 财务-支出打款
 * @author: chenhaonan02
 * @create: 2021-11-11 15:25
 **/
@Data
public class FinanceExpensePayDetailClient {
    /**
     * 收款金额
     */
    private String paidMoney;
    /**
     * 收款账号
     */
    private String paidAccount;
    /**
     * 备注
     */
    private String remark;
    /**
     * 收款人
     */
    private String receiveUser;
    /**
     * 收款状态
     */
    private String paymentStatus;
}
