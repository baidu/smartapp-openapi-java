package com.baidu.mapp.developer.bean.templatemessage;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class TemplateInfo {
    /**
     * 模板标题 id（获取模板标题下的关键词库时需要）
     */
    private String id;
    /**
     * 模板标题内容
     */
    private  String title;

    /**
     *模板 id,发送小程序模板消息时所需
     */
    @Alias("template_id")
    private String templateId;
    /**
     * 模板内容
     */
    private  String content;
    /**
     * 模板内容示例
     */
    private  String example;
}
