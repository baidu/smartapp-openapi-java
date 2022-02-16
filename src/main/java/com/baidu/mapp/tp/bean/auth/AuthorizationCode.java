package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description: 授权码
 * @author: chenhaonan02
 * @create: 2021-10-25 14:09
 **/
@Data
public class AuthorizationCode {
    /**
     * 授权码
     */
    private String authorizationCode;
    /**
     * 授权码有效时间（单位：秒）
     */
    private Integer expiresIn;
}
