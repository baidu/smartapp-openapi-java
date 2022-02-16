package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 商品退换货售后信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:39
 **/
@Data
public class AftermarketInfo {
    /**
     * 退货商品
     */
    private List<RefundProduct> product;
}
