package com.baidu.mapp.tp.bean.app;

import java.util.List;

import lombok.Data;

/**
 * @description: AppNameChecked
 * @author: chenhaonan02
 * @create: 2021-10-29 09:53
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
     *
     */
    private List<Byte> optionalFields;
}
