package com.baidu.mapp.tp.bean.search;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-15 17:04
 **/
@Data
public class AppNameChecked {
    /**
     * 小程序名称检测结果
     */
    private Byte checkResult;
    /**
     * 命中的品牌词或高流量词
     */
    private List<String> checkWords;
    /**
     * 必填字段
     */
    private List<Byte> requiredFields;
    /**
     * 可选字段
     */
    private List<Byte> optionalFields;
}
