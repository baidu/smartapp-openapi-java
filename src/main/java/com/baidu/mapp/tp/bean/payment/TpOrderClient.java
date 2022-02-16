package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-17 19:40
 **/
@Data
public class TpOrderClient {
    /**
     * 订单号
     */
    private Long orderId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 团单id
     */
    private Long dealId;
    /**
     * 订单状态 1未支付 2已支付
     */
    private Integer status;
    /**
     * 订单子状态
     */
    private Integer subStatus;
    /**
     * ordertype
     */
    private Long type;
    /**
     * 结算金额
     */
    private Integer settlePrice;
    /**
     * 原价
     */
    private Integer oriPrice;
    /**
     * 支付金额
     */
    private Integer payMoney;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 支付单号
     */
    private String tradeNo;
    /**
     * 总金额
     */
    private Integer totalMoney;
    /**
     * tpid
     */
    private Integer tpId;
    /**
     * 外部订单号
     */
    private String tpOrderId;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 购物车订单父订单id
     */
    private Integer parentOrderId;
    /**
     * 订单类型
     */
    private Integer parentType;
    /**
     * 支付渠道
     */
    private Integer payType;
    /**
     * 业务扩展字段
     */
    private String bizInfo;
    /**
     * 用户openid
     */
    private String openId;
    /**
     * 小程序appKey
     */
    private String appKey;
    /**
     * 小程序appId
     */
    private Long appId;
}