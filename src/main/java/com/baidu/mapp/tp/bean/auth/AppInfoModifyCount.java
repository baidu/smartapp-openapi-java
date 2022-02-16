package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description: 小程序基础信息修改次数
 * @author: chenhaonan02
 * @create: 2021-10-25 11:29
 **/
@Data
public class AppInfoModifyCount {
    /**
     * 名称已使用修改次数
     */
    private Integer nameModifyUsed;
    /**
     * 名称修改次数总额度
     */
    private Integer nameModifyQuota;
    /**
     * 简介已使用修改次数
     */
    private Integer signatureModifyUsed;
    /**
     * 简介修改次数总额度
     */
    private Integer signatureModifyQuota;
    /**
     * 头像已使用修改次数
     */
    private Integer imageModifyUsed;
    /**
     * 头像修改次数总额度
     */
    private Integer imageModifyQuota;
    /**
     * 类目已使用修改次数
     */
    private Integer categoryModifyUsed;
    /**
     * 类目修改次数总额度
     */
    private Integer categoryModifyQuota;
}
