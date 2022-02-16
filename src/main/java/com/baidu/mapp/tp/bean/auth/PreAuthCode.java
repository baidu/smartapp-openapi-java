package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description: TP的预授权码
 * @author: chenhaonan02
 * @create: 2021-10-25 11:20
 **/
@Data
public class PreAuthCode {
    /**
     * 预授权码
     */
    private String preAuthCode;
    /**
     * 凭证有效时间 单位：秒
     */
    private Integer expiresIn;
}
