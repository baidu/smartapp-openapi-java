package com.baidu.mapp.developer.bean.templatemessage;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class Keyword {
    @Alias("keyword_id")
    private  long keywordId;
    private  String name;
    private  String example;
}
