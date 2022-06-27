package com.baidu.mapp.developer.bean.login;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
@Data
public class SessionKey {
    /**
     * openid
     */
    @Alias("open_id")
    private String openid;
    /**
     * session_key
     */
    @Alias("session_key")
    private  String sessionKey;
}
