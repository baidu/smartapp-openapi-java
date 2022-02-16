package com.baidu.mapp.tp.bean.subscription;

import lombok.Data;

/**
 * @description: 模板对象数组
 * @author: chenhaonan02
 * @create: 2021-11-09 21:47
 **/
@Data
public class TemplateList {
    /**
     * 模板id
     */
    private String templateId;
    /**
     * 模板标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 示例
     */
    private String example;
}
