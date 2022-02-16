/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.common.enums;

/**
 * TP 推送类型
 */
public enum PushTypeEnum {

    /**
     * 所有推送
     */
    ALL(1),

    /**
     * 失败推送
     */
    FAIL(2);

    private Integer code;

    PushTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
