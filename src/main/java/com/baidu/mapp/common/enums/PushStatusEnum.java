/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.common.enums;

/**
 * TP 推送消息状态
 */
public enum PushStatusEnum {
    /**
     * 待推送
     */
    PENDING(0),

    /**
     * 推送成功
     */
    SUCCESS(1),

    /**
     * 推送失败
     */
    FAIL(2);

    private Integer code;

    PushStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
