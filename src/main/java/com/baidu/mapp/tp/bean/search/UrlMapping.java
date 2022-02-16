package com.baidu.mapp.tp.bean.search;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-17 15:06
 **/
@Data
public class UrlMapping {
    /**
     * 规则id
     */
    private Long ruleId;
    /**
     * 移动url表达式
     */
    private String h5Pattern;
    /**
     * 小程序Path表达式
     */
    private String appPattern;
    /**
     * 是否匹配topurl生成path
     */
    private Boolean isFetch;
    /**
     * 匹配topurl的数量
     */
    private Integer matchNum;
    /**
     * 适配topurl的数量
     */
    private Integer adapterNum;
    /**
     * 累计替换 URL 量，即累计截止 t-1已完成替换的的 url 数量
     */
    private Long coverNum;
    /**
     * top 流量 URL 替换占比=累计截止 t-1已完成替换的top url 数量/总 top url 数量
     */
    private Long urlRate;
    /**
     * 规则状态
     */
    private Byte adapterStatus;
}
