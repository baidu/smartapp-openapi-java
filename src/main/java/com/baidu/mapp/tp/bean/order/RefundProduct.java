package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description: 售后商品信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:38
 **/
@Data
public class RefundProduct {
    /**
     * 商品ID
     */
    private String id;
    /**
     * 商品退款数量
     */
    private Long quantity;
    /**
     * 应退金额
     */
    private Long amount;
}
