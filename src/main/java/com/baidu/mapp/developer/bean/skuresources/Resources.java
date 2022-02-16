package com.baidu.mapp.developer.bean.skuresources;

import cn.hutool.core.annotation.Alias;

import lombok.Data;

@Data
public class Resources {
    @Data
    public static class PriceInfo {
        @Alias("org_unit")
        private String orgUnit;

        @Alias("org_price")
        private String orgPrice;

        @Alias("real_price")
        private String realPrice;

        @Alias("range_min_price")
        private String rangeMinPrice;

        @Alias("range_max_price")
        private String rangeMaxPrice;
    }

    @Data
    public static class  ActivityInfo {

        @Alias("activity_type")
        private String activityType;

        @Alias("activity_desc")
        private String activityDesc;

        @Alias("activity_path")
        private String activityPath;

        @Alias("activity_start_time")
        private long activityStartTime;

        @Alias("activity_end_time")
        private long activityEndTime;
    }


    @Alias("path")
    private String path;

    @Alias("trade_type")
    private int tradeType;

    @Alias("title")
    private String title;

    @Alias("desc")
    private String desc;

    @Alias("region")
    private String region;

    @Alias("tag")
    private String tag;

    @Alias("button_name")
    private String buttonName;

    @Alias("schema")
    private String schema;

    @Alias("images")
    private String[] images;

    @Alias("price_info")
    private PriceInfo priceInfo;

    @Alias("activity_info")
    private ActivityInfo[] activityInfo;

}
