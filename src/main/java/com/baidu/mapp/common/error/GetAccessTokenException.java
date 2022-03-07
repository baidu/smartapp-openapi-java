package com.baidu.mapp.common.error;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class GetAccessTokenException extends Exception {

    private String error ;
    @Alias("error_description")
    private String errorDescription;
    public GetAccessTokenException(String error, String error_description) {
        this.error = error;
        this.errorDescription = error_description;
    }
}

