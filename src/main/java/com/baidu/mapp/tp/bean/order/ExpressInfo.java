package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-03 17:30
 **/
@Data
public class ExpressInfo {
    /**
     * 快递当前状态(预留字段，默认取值为0)
     */
    private Integer status;
    /**
     * 快递类型，1：商家给用户发货，2：用户给商家退货
     */
    private Integer type;
    /**
     * 快递单号
     */
    private String id;
    /**
     * 快递公司对应的编号,会做校验
     */
    private String code;
    /**
     * 快递公司名称
     */
    private String name;
}

