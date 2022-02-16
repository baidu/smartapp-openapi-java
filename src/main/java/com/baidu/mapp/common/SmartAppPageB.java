/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.common;

import java.util.List;

import lombok.Data;

/**
 * 分页
 *
 * @author : maduo
 * @date : 2018/8/9 上午11:11
 */
@Data
public class SmartAppPageB<T> {
    private long page;
    private long count;
    private List<T> list;
    private int pageSize;
}
