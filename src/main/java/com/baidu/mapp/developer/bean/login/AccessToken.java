package com.baidu.mapp.developer.bean.login;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
@Data
public class AccessToken {
    @Alias("access_token")
    private String accessToken;
    @Alias("expires_in")
    private  String expiresIn;
    private  String error;
    @Alias("error_description")
    private  String errorDescription;

}
