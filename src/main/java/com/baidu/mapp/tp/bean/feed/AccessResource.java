/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.tp.bean.feed;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class AccessResource {

    /**
     * 物料id
     */
    private String rid;
    /**
     * 小程序id
     */
    @Alias("app_id")
    private Long appId;
    /**
     * 标题
     */
    private String title;
    /**
     * 提交时间
     */
    @Alias("create_time")
    private String createTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 审核信息
     */
    private String message;
    /**
     * 审核时间
     */
    @Alias("audit_time")
    private String auditTime;
    /**
     * 物料来源
     */
    private String source;

}
