package com.baidu.mapp.tp.bean.search;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-16 21:39
 **/
@Data
public class QueryKeywordClient {
    private List<KeyWordDetail> detail;
    private Integer totalNum;

    @Data
    public static class KeyWordDetail {
        private String query;
        private Integer clickCount;
        private Integer displayCount;
        private String rate;
    }
}