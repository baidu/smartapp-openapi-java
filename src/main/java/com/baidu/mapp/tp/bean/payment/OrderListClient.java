package com.baidu.mapp.tp.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description: 订单流水数据
 * @author: chenhaonan02
 * @create: 2021-11-11 14:53
 **/
@Data
public class OrderListClient {
    private String totalMoney;
    private Long currentPage;
    private Long pageSize;
    private Long totalCount;
    private Long totalPage;
    private List<OrderClient> data;
}
