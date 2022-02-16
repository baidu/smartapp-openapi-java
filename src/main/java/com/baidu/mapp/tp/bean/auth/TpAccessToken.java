package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-10-25 11:17
 **/
@Data
public class TpAccessToken {
    /**
     * 第三方平台的接口调用凭据
     */
    private String accessToken;
    /**
     * 凭证有效时间，单位：秒，默认20分钟
     */
    private Integer expiresIn;
    /**
     * scope
     */
    private String scope;
}

