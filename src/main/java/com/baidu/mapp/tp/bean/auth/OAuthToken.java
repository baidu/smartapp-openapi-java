package com.baidu.mapp.tp.bean.auth;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @description: openAPI token
 * @author: chenhaonan02
 * @create: 2021-10-25 15:23
 **/
@Data
public class OAuthToken {
    /**
     * 授权小程序的接口调用凭据
     */
    private String accessToken;
    /**
     * 接口调用凭据刷新令牌，有效期10年，使用一次后失效
     */
    private String refreshToken;
    /**
     * Access Token的有效期，单位：秒，默认1小时
     */
    private Integer expiresIn;
    /**
     * 错误码
     */
    private String error;
    /**
     * 错误描述信息
     */
    @Alias("error_description")
    private String errorDescription;
}
