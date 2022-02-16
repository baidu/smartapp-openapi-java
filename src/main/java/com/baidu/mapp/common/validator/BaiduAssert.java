package com.baidu.mapp.common.validator;

import java.util.Objects;

import com.baidu.mapp.common.OpenAPIErrorCode;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.enums.SmartAppErrorCode;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;

/**
 * @description: 减少手动判空，抛出业务异常的代码
 * @author: chenhaonan02
 * @create: 2021-10-27 11:27
 **/
public class BaiduAssert {

    /**
     * 第三方平台json解析有误
     *
     * @param result   解析对象
     * @param response 响应
     *
     * @throws OpenAPIErrorException OpenAPI异常类
     */
    public static void notNull(SmartAppResult result, String response) throws OpenAPIErrorException {
        if (result.getErrno() == null && result.getMsg() == null && result.getData() == null) {
            OpenAPIErrorCode openAPIErrorCode = JSONUtil.toBean(response, OpenAPIErrorCode.class);
            throw new OpenAPIErrorException(openAPIErrorCode.getErrorCode(), openAPIErrorCode.getErrorMsg());
        }
    }

    /**
     * 第三方平台json解析有误
     *
     * @param object   解析对象
     * @param response 响应
     *
     * @throws OpenAPIErrorException OpenAPI异常类
     */
    public static void notNull(Object object, String response) throws OpenAPIErrorException {
        if (BeanUtil.isEmpty(object)) {
            OpenAPIErrorCode openAPIErrorCode = JSONUtil.toBean(response, OpenAPIErrorCode.class);
            throw new OpenAPIErrorException(openAPIErrorCode.getErrorCode(), openAPIErrorCode.getErrorMsg());
        }
    }

    /**
     * 第三方平台请求返回响应有误
     *
     * @param object 解析对象
     *
     * @throws SmartAppErrorException 智能小程序异常类
     */
    public static void error(SmartAppResult object) throws SmartAppErrorException {
        if (!Objects.equals(object.getErrno(), SmartAppErrorCode.OK.getCode())) {
            throw new SmartAppErrorException(object.getErrno(), object.getMsg(), object.getTraceId());
        }
    }

    /**
     * 解析响应有误
     *
     * @param result   解析对象
     * @param response 响应结果
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    public static void error(SmartAppResult result, String response)
            throws SmartAppErrorException, OpenAPIErrorException {
        BaiduAssert.notNull(result, response);
        BaiduAssert.error(result);
    }

    public static void error(SmartAppResult result, String response, boolean isIgnoreSmartAppException)
            throws SmartAppErrorException, OpenAPIErrorException {
        BaiduAssert.notNull(result, response);
        BaiduAssert.error(result, isIgnoreSmartAppException);
    }

    public static void error(SmartAppResult object, boolean isIgnoreSmartAppException) throws SmartAppErrorException {
        if (object.getErrno() != SmartAppErrorCode.OK.getCode() && !isIgnoreSmartAppException) {
            throw new SmartAppErrorException(object.getErrno(), object.getMsg(), object.getTraceId());
        }
    }
}

