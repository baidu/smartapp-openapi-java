package com.baidu.mapp.developer.bean.templatemessage;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class GetTemplateLibraryListResult {
    @Alias("total_count")
    private  long totalCount;
    private TemplateInfo[] list;
}
