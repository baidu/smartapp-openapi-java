package com.baidu.mapp.tp.bean.login;

import lombok.Data;

/**
 * @description: 小程序登陆
 * @author: chenhaonan02
 * @create: 2021-12-03 20:03
 **/
@Data
public class AppLogin {
    /**
     * 用户身份标识，由 appid 和 uid 生成
     * 不同用户登录同一个小程序获取到的 openid 不同，同一个用户使用登录不同一个小程序获取到的 openid 也不同
     */
    private String openid;
    /**
     * 用户的 SessionKey
     */
    private String sessionKey;
}
