package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-10 21:00
 **/
@Data
public class TradeBankList {
    /**
     * 首字母
     */
    private String character;
    /**
     * 银行
     */
    private List<TradeBankList.TradeBank> banks;

    @Data
    public static class TradeBank {
        /**
         * 银行 Id
         */
        private int bankId;
        /**
         * 银行名称
         */
        private String bankName;
        private String logoUrl;
    }
}
