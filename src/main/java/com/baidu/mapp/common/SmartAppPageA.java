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
public class SmartAppPageA<T> {

    private long pageNo;
    private long total;
    private List<T> dataList;
    private int pageSize;

    public int getTotalPage() {
        return this.getPageSize() == 0L ? 1 : (int) Math.ceil((double) this.total / (double) this.getPageSize());
    }
}
