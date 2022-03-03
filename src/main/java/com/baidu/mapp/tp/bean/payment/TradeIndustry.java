package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-11 14:46
 **/
@Data
public class TradeIndustry {
    /**
     * 类目名称
     */
    private String industryName;
    /**
     * 类目描述
     */
    private String permitDesc;
    /**
     * 是否需要资质
     */
    private Integer needPermit;
    /**
     * 类目id
     */
    private Integer industryId;
    /**
     * 父类目id
     */
    private Integer parentIndustryId;
    /**
     * 子类目list 3级类目无子类目
     */
    private List<TradeIndustry> industryList;
}
