package com.baidu.mapp.tp.bean.subscription;

import java.util.List;

import lombok.Data;

/**
 * @description: 关键词库
 * @author: chenhaonan02
 * @create: 2021-11-09 21:30
 **/
@Data
public class LibraryGet {
    /**
     * 模板id
     */
    private String id;
    /**
     * 模板标题
     */
    private String title;
    /**
     * 关键字条数
     */
    private Integer keywordCount;
    /**
     *
     */
    private List<KeywordList> keywordList;

    /**
     * 关键词列表
     */
    @Data
    public static class KeywordList {
        /**
         * 关键词id，添加模板时需要
         */
        private Integer keywordId;
        /**
         * 关键词内容
         */
        private String name;
        /**
         * 关键词内容对应的示例
         */
        private String example;
    }
}