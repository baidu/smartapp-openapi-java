package com.baidu.mapp.tp.bean.data;

import java.util.List;

import lombok.Data;

/**
 * @description: 调用mtj获得结果后 返回给tp的数据格式
 * @author: chenhaonan02
 * @create: 2021-11-12 21:20
 **/
@Data
public class DataInfo<T> {
    private Integer offset;
    private Integer total;
    private List<T> result;
}
