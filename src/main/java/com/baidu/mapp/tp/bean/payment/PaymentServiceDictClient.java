package com.baidu.mapp.tp.bean.payment;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-10 20:57
 **/
@Data
public class PaymentServiceDictClient {
    /**
     * 城市
     */
    private List<TradeBankProvince> provinceList;
    /**
     * 银行
     */
    private List<TradeBankList> bankList;
    /**
     * 佣金比例
     */
    Map<Integer, String> commissionRate;
    /**
     * 结算周期
     */
    Map<Integer, String> paymentDays;
}
