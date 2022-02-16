package com.baidu.mapp.tp.bean.data;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-12 20:39
 **/
@Data
public class MTJDataStatisticsResult {
    private String timeSpan;
    private Long offset;
    private Long total;
    private Map<String, Object> sum;
    private List<Object> dataList;
    private String errorCode;
    private String errorMessage;
}
