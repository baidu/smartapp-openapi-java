package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description: 详情跳转页面信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:22
 **/
@Data
public class PageInfo {
    /**
     * 状态 0: 隐藏 1: 正常展示，禁止跳转 2：正常展示，允许跳转
     */
    private Integer status;
    /**
     * 展示名称
     */
    private String name;
    /**
     * h5跳转Schema
     */
    private String h5Schema;
    /**
     * 小程序跳转schema
     */
    private String swanSchema;
    /**
     * IPhoneSchema
     */
    private String iphoneSchema;
    /**
     * Android NA Schema
     */
    private String androidSchema;
}
