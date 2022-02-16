package com.baidu.mapp.developer.bean.templatemessage;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class GetTemplateLibraryByIdResult {
    private String id;
    private  String title;
    @Alias("keyword_count")
    private  int keywordCount;
}
