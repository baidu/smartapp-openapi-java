/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.tp.bean.template;

import lombok.Data;

/**
 * @description: 草稿信息
 * @author: chenhaonan02
 * @create: 2021-09-23 14:02
 **/
@Data
public class TemplateDraft {
    /**
     * 草稿 Id
     */
    private Long draftId;
    /**
     * 上传者
     */
    private String userName;
    /**
     * 来源小程序
     */
    private String appName;
    /**
     * 版本信息
     */
    private String userVersion;
    /**
     * 草稿描述
     */
    private String userDesc;
    /**
     * 创建时间
     */
    private Object createTime;
    /**
     * web 化开关
     */
    private boolean webStatus;
}
