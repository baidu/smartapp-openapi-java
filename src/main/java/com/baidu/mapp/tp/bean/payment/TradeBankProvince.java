package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-10 20:58
 **/
@Data
public class TradeBankProvince {

    private int provinceId;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 市级
     */
    private List<TradeBankProvince.City> cities;

    @Data
    public static class City {
        private int cityId;
        /**
         * 市名
         */
        private String cityName;
    }
}
