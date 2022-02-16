package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description: 特殊付款信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:28
 **/
@Data
public class PaymentSpecInfo {
    /**
     * 展示名称
     */
    private String name;
    /**
     * 金额，单位分
     */
    private Integer value;
    /**
     * 金额，单位分
     */
    private Integer quantity;
    /**
     * 优惠券code
     */
    private String specCode;
    /**
     * 优惠券类型 1：开发者 2：百度
     */
    private String specType;
    /**
     * 优惠券扩展
     */
    private String specExt;
}
