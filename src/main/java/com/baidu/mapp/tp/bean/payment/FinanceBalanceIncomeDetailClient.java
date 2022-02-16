package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 财务-收入货款
 * @author: chenhaonan02
 * @create: 2021-11-11 15:07
 **/
@Data
public class FinanceBalanceIncomeDetailClient {
    /**
     * 类型
     */
    private String optType;
    /**
     * 计算依据价格
     */
    private String money;
    /**
     * 糯米订单号
     */
    private Long orderId;
    /**
     * 操作时间
     */
    private String operateTime;
    /**
     * 第三方订单号
     */
    private String thirdOrderId;
}
