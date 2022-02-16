package com.baidu.mapp.developer.bean.copuon;

import lombok.Data;

@Data
public class BatchGetCouponResult {
    /**
     * 页码
     */
    private int pageNo;
    /**
     * 总数量
     */
    private int total;
    /**
     * 卡券信息数组
     */
    private CouponData[] dataList;
}
