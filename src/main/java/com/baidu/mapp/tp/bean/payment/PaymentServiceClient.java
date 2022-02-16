package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-11 14:39
 **/
@Data
public class PaymentServiceClient {
    /**
     * 服务id
     */
    private Long pmAppId;
    /**
     * 服务名称
     */
    private String appName;
    /**
     * 服务Key
     */
    private String pmAppKey;
    /**
     * 平台公钥
     */
    private String platformPublicKey;
    /**
     * dealId
     */
    private String dealId;
    /**
     * 服务电话
     */
    private String servicePhone;
    /**
     * 银行账户
     */
    private String bankAccount;
    /**
     * 银行卡号
     */
    private String bankCard;
    /**
     * 所属银行
     */
    private String bankName;
    /**
     * 支行信息
     */
    private String bankBranch;
    /**
     * 开户省份
     */
    private String openProvince;
    /**
     * 开户城市
     */
    private String openCity;
    /**
     * 结算周期
     */
    private Integer paymentDays;
    /**
     * 佣金比例 千分之六(6) 百分之一(10)
     */
    private Integer commissionRate;
    /**
     * 打款预留（元）
     */
    private Long poolCashPledge;
    /**
     * 每日退款上限(元)
     */
    private Long dayMaxFrozenAmount;
    /**
     * 开通状态 0新建 1审核中 2审核通过 3驳回
     */
    private Integer openStatus;
    /**
     * 驳回回执
     */
    private String failReason;
    /**
     * 银行卡预留电话
     */
    private String bankPhoneNumber;
}
