package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-03 17:15
 **/
@Data
public class Safeguard {
    /**
     * 单生成时刻是否可保，2可保，其他值不可保
     */
    private Integer status;
    /**
     * 业务加入保障时，保障侧分配的appid，第三方小程序：10001
     */
    private Integer sAppID;
    /**
     * 业务方加入保障时，申请保障的唯一key，如第三方小程序为appkey
     */
    private String objectID;
    /**
     * 业务方的唯一订单 Id
     */
    private String sOrderID;
    /**
     * 非必须，订单快照中业务方接入保障申请的保项
     */
    private List<Integer> iConID;
}
