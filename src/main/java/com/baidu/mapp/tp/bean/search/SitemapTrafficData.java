package com.baidu.mapp.tp.bean.search;

import java.util.List;

import lombok.Data;

/**
 * @description: sitemap提交信息概要
 * @author: chenhaonan02
 * @create: 2021-11-16 21:35
 **/
@Data
public class SitemapTrafficData {
    /**
     * 总的小程序点击流量
     */
    private Integer totalClickCount;
    /**
     * 总的小程序展现流量
     */
    private Integer totalDisplayCount;
    /**
     * 点击展现比率
     */
    private String clickDisplayRatio;
    /**
     * 详情列表
     */
    private List<TrafficData> trafficData;

    @Data
    public static class TrafficData {
        /**
         * 日期, 格式为yyyy-MM-dd
         */
        private String date;
        /**
         * 小程序点击流量
         */
        private Integer clickCount;
        /**
         * 小程序展现流量
         */
        private Integer displayCount;
        /**
         * 点击展现比率
         */
        private String clickViewRatio;
    }
}
