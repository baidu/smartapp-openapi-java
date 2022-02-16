package com.baidu.mapp.tp.bean.template;

import lombok.Data;

/**
 * @description: 模板信息
 * @author: chenhaonan02
 * @create: 2021-10-22 16:52
 **/
@Data
public class Template {
    /**
     * 模板id
     */
    private Long templateId;
    /**
     * 上传者
     */
    private String userName;
    /**
     * 来源小程序
     */
    private String appName;
    /**
     * 版本信息
     */
    private String userVersion;
    /**
     * 模板描述
     */
    private String userDesc;
    /**
     * 创建时间
     */
    private Object createTime;
    /**
     * web化开关
     */
    private boolean webStatus;
}
