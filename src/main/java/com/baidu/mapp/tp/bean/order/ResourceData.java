package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description: 资产数据，业务数据
 * @author: chenhaonan02
 * @create: 2021-12-03 16:53
 **/
@Data
public class ResourceData {
    /**
     * 用户Id
     */
    private Long uid;
    /**
     * 业务方 Id
     */
    private Integer bizId;
    /**
     * 资源 Id 订单业务：主订单 Id
     */
    private String resourceId;
    /**
     * 应用ID,对于小程序是小程序ID,店铺id或者商户id
     */
    private String bizAppId;
    /**
     * 业务方 - 创建时间，时间戳，秒
     */
    private Long ctime;
    /**
     * 业务方 - 修改时间，时间戳，秒
     */
    private Long mtime;
    /**
     * 数据分类 Id
     */
    private Integer cateId;
    /**
     * 信息描述
     */
    private String title;
    /**
     * 数据状态
     */
    private String status;
    /**
     * 保障信息
     */
    private Safeguard safeguard;
    /**
     * 扩展信息
     */
    private PushOrderInfo pushOrderInfo;
    /**
     * 展示设备
     */
    private Integer platform;
    /**
     * 用户下单时所在的APP
     */
    private String appId;
    /**
     * 用户下单时的设备号ID
     */
    private Integer cuid;
}
