package com.baidu.mapp.developer.bean.templatemessage;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class GetTemplateListResult {
    /**
     *模板库标题总数
     */
    @Alias("total_count")
    private String  totalCount;
    /**
     *模板对象数组，对象中包含模板 id 、模板标题 title 、模板内容 content 、模板内容示例 example
     */
    private  TemplateInfo[] list;

}
