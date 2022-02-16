package com.baidu.mapp.developer.bean.copuon;

import lombok.Data;

@Data
public class BannerInfo {

    /**
     * 卡券 banner 记录 id
     */
    long bannerId;

    /**
     * 卡券 ID
     */
    String couponId;

    /**
     * 卡券 banner 图标题
     */
    String  title;
    /**
     * 卡券 banner 图片
     */
    String picUrl;

    /**
     * banner 图跳转的小程序页面路径
     */
    String appRedirectPath;

    /**
     * 卡券创建时间
     */
    long createTime;

    /**
     * 卡券更新事件
     */
    long updateTime;
}
