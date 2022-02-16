package com.baidu.mapp.tp.bean.app;

import java.util.List;

import lombok.Data;

/**
 * @description: AppSupportVersion
 * @author: chenhaonan02
 * @create: 2021-10-29 10:44
 **/
@Data
public class AppSupportVersion {

    private String nowVersion;
    private List<Item> items;

    @Data
    public static class Item {
        private String version;
        private Double percentage;

        public Item(String version) {
            this.version = version;
        }
    }
}