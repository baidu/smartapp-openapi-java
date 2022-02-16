package com.baidu.mapp.tp.bean.template;

import java.util.List;

import lombok.Data;

/**
 * @description: 模板列表
 * @author: chenhaonan02
 * @create: 2021-10-22 16:51
 **/
@Data
public class TemplateList {
    /**
     * 模板列表
     */
    List<Template> list;
    /**
     * 模板总数
     */
    Integer count;
}
