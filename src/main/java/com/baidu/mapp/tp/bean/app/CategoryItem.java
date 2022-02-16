package com.baidu.mapp.tp.bean.app;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: CategoryItem
 * @author: chenhaonan02
 * @create: 2021-10-29 10:30
 **/
@Data
public class CategoryItem {
    private Long id;
    private String categoryName;
    private Integer categoryType;
    private Map<Long, CategorySubItemVo> subItems;

    @Data
    @NoArgsConstructor
    public static class CategorySubItemVo {
        private Long id;
        private String categoryName;
        private Integer categoryType;
        private Integer needQuali;
        private CategoryQualiVo categoryQuali;
    }

    @Data
    @NoArgsConstructor
    public static class CategoryQualiVo {
        private String desc;
        private List<List<CategoryQualiItemVo>> list;
    }

    @Data
    @AllArgsConstructor
    public static class CategoryQualiItemVo {
        private Long id;
        private Integer must;
        private String name;
        private String desc;
    }
}

