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
    private String industryName;
    private String permitDesc;
    private Integer needPermit;
    private Integer industryId;
    private Integer parentIndustryId;
    private List<TradeIndustry> industryList;
}
