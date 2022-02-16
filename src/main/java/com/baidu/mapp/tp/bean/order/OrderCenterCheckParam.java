package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-03 16:50
 **/
@Data
public class OrderCenterCheckParam {
    /**
     * openId登陆态标识
     */
    private String openId;
    /**
     * swanId设备标识
     */
    private String swanId;
    /**
     * 场景id，用于校验订单
     */
    private String sceneId;
    /**
     * 场景类型
     */
    private Integer sceneType;
    /**
     * 支付服务id
     */
    private String pmAppKey;
    /**
     * 宿主标示
     */
    private String hostname;
}
