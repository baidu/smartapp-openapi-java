package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 商品退款信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:37
 **/
@Data
public class RefundProductInfo {
    /**
     * 退款总金额
     */
    private Long amount;
    /**
     * 退款商品
     */
    private List<RefundProduct> product;
}
