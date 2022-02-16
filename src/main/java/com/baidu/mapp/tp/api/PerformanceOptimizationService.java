package com.baidu.mapp.tp.api;

import java.util.List;

import com.baidu.mapp.tp.bean.performance.DomainItemCheckResult;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 性能优化接口
 * @author: chenhaonan02
 * @create: 2021-11-10 15:47
 **/
public interface PerformanceOptimizationService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "PerformanceOptimizationService";
    /**
     * prelink域名提交
     * https://smartprogram.baidu.com/docs/third/optimization/prelink_submit/
     */
    String PRELINK_SET = SmartAppConstants.OPEN_API_SMART_APP_URL + "prelink/set";
    /**
     * 获取prelink域名
     * https://smartprogram.baidu.com/docs/third/optimization/prelink_get/
     */
    String PRELINK_GET = SmartAppConstants.OPEN_API_SMART_APP_URL + "prelink/get";

    /**
     * prelink域名提交
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param prelinkUrl  prelink链接
     *
     * @return DomainItemCheckResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    DomainItemCheckResult setPrelink(String accessToken, List<String> prelinkUrl)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取prelink域名
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return List<String>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<String> getPrelink(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;
}
