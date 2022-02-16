/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.tp.bean.template;

import java.util.List;

import lombok.Data;

/**
 * @description: 模板草稿列表
 * @author: chenhaonan02
 * @create: 2021-09-23 14:02
 **/
@Data
public class TemplateDraftList {
    /**
     * 草稿列表
     */
    List<TemplateDraft> list;
    /**
     * 草稿总数
     */
    Integer count;
}
