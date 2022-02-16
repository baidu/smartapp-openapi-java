/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.tp.bean.grade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppGrade {
    /**
     * 小程序key
     */
    private String appKey;
    /**
     * 小程序ID
     */
    private Long appId;
    /**
     * 小程序等级
     *
     */
    private String appGrade;
}
