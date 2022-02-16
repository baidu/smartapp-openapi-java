package com.baidu.mapp.developer.bean.skuresources;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class BJHMaterial {
    @Alias("app_id")
    private  int appId;
    @Alias("imageUrl")
    private  String imageUrl;
    @Alias("title")
    private  String title;
    @Alias("path")
    private  String path;
    @Alias("category1Code")
    private  String category1Code;
    @Alias("category2Code")
    private  String category2Code;
    @Alias("desc")
    private  String desc;
    @Alias("labelAttr")
    private  String labelAttr;
    @Alias("labelDiscount")
    private  String labelDiscount;
    @Alias("buttonName")
    private  String buttonName;
    @Alias("bigImage")
    private  String bigImage;
    @Alias("verticalImage")
    private  String verticalImage;
    @Alias("extJson")
    private  String extJson;


}
