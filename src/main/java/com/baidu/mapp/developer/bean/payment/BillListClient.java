package com.baidu.mapp.developer.bean.payment;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-17 20:39
 **/
@Data
public class BillListClient {
    /**
     * 对账单列表
     */
    private List<BillDetailClient> data;
    /**
     * 总数
     */
    private Long totalCount;
}