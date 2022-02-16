package com.baidu.mapp.tp.bean.mobile;

import lombok.Data;

/**
 * @description: 手机权限状态
 * @author: chenhaonan02
 * @create: 2021-11-10 17:11
 **/
@Data
public class MobileAuthStatus {
    /**
     * 状态
     */
    private Integer status;
    /**
     * 原因
     */
    private String reason;
}
