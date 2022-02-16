package com.baidu.mapp.tp.bean.subscription;

import java.util.List;

import lombok.Data;

/**
 * @description: 已存在的模板列表
 * @author: chenhaonan02
 * @create: 2021-11-09 21:39
 **/
@Data
public class TemplateExistsList {
    /**
     * 模板库标题总数
     */
    private int totalCount;
    /**
     * 模板对象数组，对象中包含模板 id 、模板标题 title 、模板内容 content 、模板内容示例 example
     */
    private List<TemplateList> templateList;
}
