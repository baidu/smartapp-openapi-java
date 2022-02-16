/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.tp.bean.pushmsg;

import com.baidu.mapp.common.enums.PushEventNameEnum;
import com.baidu.mapp.common.enums.PushStatusEnum;

import lombok.Data;

/**
 * @author maduo
 */
@Data
public class PushMsg {
    /**
     * 推送id
     */
    private Long id;
    /**
     * 推送内容(加密)
     * https://smartprogram.baidu.com/docs/third/auth/auth_push/
     *
     * @see PushEventNameEnum
     */
    private String content;
    /**
     * 推送状态
     *
     * @see PushStatusEnum
     */
    private Byte status;
}
