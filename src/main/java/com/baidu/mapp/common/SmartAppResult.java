package com.baidu.mapp.common;

import com.baidu.mapp.common.enums.SmartAppErrorCode;

import lombok.Data;

/**
 * 自定义响应结构
 *
 * @author magenm
 * @date 2018/8/7 12:40
 */
@Data
public class SmartAppResult<T> {

    public static final Integer CODE_SUCCESS = SmartAppErrorCode.OK.getCode();
    public static final Integer CODE_FAIL = SmartAppErrorCode.UNKNOW_FAIL.getCode();
    public static final String MSG_SUCCESS = SmartAppErrorCode.OK.getMsg();
    public static final String MSG_FAIL = SmartAppErrorCode.UNKNOW_FAIL.getMsg();

    /**
     * 响应业务状态 0 成功， 1失败
     */
    private Integer errno;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应中的数据
     */
    private T data;
    /**
     * 请求 ID
     */
    private String requestId;
    /**
     * 跟踪 ID
     */
    private String traceId;

    /**
     * 时间戳
     */
    private Long timestamp;
}
