package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description: 订单业务数据
 * @author: chenhaonan02
 * @create: 2021-12-03 17:17
 **/
@Data
public class PushOrderInfo {
    /**
     * 主订单
     */
    private MainOrderInfo mainOrderInfo;
    /**
     * 子订单
     */
    private MainOrderRefundInfo orderRefundInfo;
}
