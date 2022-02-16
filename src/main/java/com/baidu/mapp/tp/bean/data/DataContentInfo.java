package com.baidu.mapp.tp.bean.data;

import lombok.Data;

/**
 * @description: 调用mtj获得结果后 返回给tp的数据内容
 * @author: chenhaonan02
 * @create: 2021-11-12 21:21
 **/
@Data
public class DataContentInfo {
    private String date;
    private Indicator indicator;
}
