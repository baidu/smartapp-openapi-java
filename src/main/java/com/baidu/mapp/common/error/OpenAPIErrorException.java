package com.baidu.mapp.common.error;

import lombok.Data;

/**
 * @description: OpenAPI异常类
 * @author: chenhaonan02
 * @create: 2021-09-27 14:24
 **/
@Data
public class OpenAPIErrorException extends Exception {

    private Integer code;
    private String msg;

    public OpenAPIErrorException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
