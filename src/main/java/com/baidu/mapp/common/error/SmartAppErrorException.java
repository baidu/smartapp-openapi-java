package com.baidu.mapp.common.error;

import com.baidu.mapp.common.enums.SmartAppErrorCode;

import lombok.Data;

/**
 * @description: 智能小程序异常类
 * @author: chenhaonan02
 * @create: 2021-09-27 14:24
 **/
@Data
public class SmartAppErrorException extends Exception {

    /**
     * @see SmartAppErrorCode
     */
    private Integer code;

    private String msg;

    private String traceId;

    public SmartAppErrorException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SmartAppErrorException(Integer code, String msg, String traceId) {
        this.code = code;
        this.msg = msg;
        this.traceId = traceId;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
