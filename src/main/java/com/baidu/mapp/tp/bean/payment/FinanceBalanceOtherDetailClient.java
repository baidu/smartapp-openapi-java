package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description: 财务-收入其它款项
 * @author: chenhaonan02
 * @create: 2021-11-11 15:14
 **/
@Data
public class FinanceBalanceOtherDetailClient {
    /**
     * 类型
     */
    private String optType;
    /**
     * 糯米订单号
     */
    private Long orderId;
    /**
     * 操作时间
     */
    private String operateTime;
    /**
     * 计算依据价格
     */
    private String refMoney;
    /**
     * 第三方订单号
     */
    private String thirdOrderId;
}
