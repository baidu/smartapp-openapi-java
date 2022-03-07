package com.baidu.mapp.common.error;

public class GetAccessTokenException extends Exception {

    private String error ;
    private String error_description;

    public GetAccessTokenException(String error, String error_description) {
        this.error = error;
        this.error_description = error_description;
    }
}

