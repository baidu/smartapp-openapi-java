package com.baidu.mapp.developer.bean.login;

import lombok.Data;
@Data
public class SessionKey {
    /**
     * openid
     */
    private String openid;
    /**
     * session_key
     */
    private  String sessionKey;
}
