package com.baidu.mapp.developer.bean.copuon;

import lombok.Data;

@Data
public class CouponData {
    /**
     * 卡券 ID
     */
    private  String couponId;
    /**
     * 卡券类型
     */
    private  String couponType;
    /**
     * 折扣券专用，表示打折力度（格式为百分比），填 80 就是八折。
     */
    private  int discount;
    /**
     * 基本的卡券数据，所有卡券通用。
     */
    private  BaseInfo baseInfo;
    /**
     * 使用须知：卡券使用方法的介绍
     */
    private  String description;
    /**
     * 卡券领取事件推送地址
     */
    private  String callbackUrl;
}
