package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 订单信息（退换货／售后订单）
 * @author: chenhaonan02
 * @create: 2021-12-03 17:33
 **/
@Data
public class MainOrderRefundInfo {
    /**
     * 子订单总状态
     */
    private Integer status;
    /**
     * 子订单列表
     */
    private List<OrderRefundInfo> items;
}
