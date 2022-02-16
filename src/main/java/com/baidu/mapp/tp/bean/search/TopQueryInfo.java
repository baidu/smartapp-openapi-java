package com.baidu.mapp.tp.bean.search;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-16 21:28
 **/
@Data
public class TopQueryInfo {
    /**
     * 总点击
     */
    private Integer totalClickCount;
    /**
     * 总展现
     */
    private Integer totalDisplayCount;
    /**
     * 点展比
     */
    private String rate;
    /**
     * 列表详情
     */
    private List<TopQueryDetail> detail;
    /**
     * 列表详情数
     */
    private Integer totalNum;

    @Data
    public static class TopQueryDetail {
        /**
         * Path
         */
        private String path;
        /**
         * web化url
         */
        private String webUrl;
        /**
         * 点击量
         */
        private Integer clickCount;
        /**
         * 展现量
         */
        private Integer displayCount;
        /**
         * 点展比
         */
        private String rate;
    }
}
