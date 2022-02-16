package com.baidu.mapp.util;

import java.util.Map;

import com.baidu.mapp.common.TimeIntervalContext;
import com.baidu.mapp.common.config.SmartAppConfig;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: Http工具类
 * @author: chenhaonan02
 * @create: 2021-09-23 17:01
 **/
@Slf4j
public class SmartAppHttpUtil extends HttpUtil {

    private static final SmartAppConfig SMART_APP_CONFIG = SmartAppConfig.getInstance();

    /**
     * 发送 get请求
     */
    public static String sendHttpGet(String url, Map<String, Object> params) {
        return sendHttpGet(url, null, params);
    }

    /**
     * 发送 get请求
     */
    public static String sendHttpGet(String url, Map<String, String> headers, Map<String, Object> params) {
        return sendHttpGet(url, headers, params, SMART_APP_CONFIG.getDefaultConnectTimeout(),
                SMART_APP_CONFIG.getDefaultReadTimeout());
    }

    /**
     * 发送 get请求
     */
    private static String sendHttpGet(String httpUrl, Map<String, String> headers, Map<String, Object> params,
                                      int connectionTimeoutMillis, int readTimeoutMillis) {
        HttpRequest httpRequest =
                createGet(httpUrl).headerMap(headers, true).form(params).setConnectionTimeout(connectionTimeoutMillis)
                        .setReadTimeout(readTimeoutMillis);
        TimeIntervalContext timeIntervalContext = TimeIntervalContext.get();
        TimeIntervalContext.RequestContext requestContext = timeIntervalContext.getRequest();
        requestContext.setHeaders(headers);
        requestContext.setParams(params);
        requestContext.setMethod(httpRequest.getMethod().name());
        return execute(httpRequest, timeIntervalContext);
    }

    /**
     * 发送 post请求
     */
    public static String sendHttpPost(String url, Map<String, Object> params) {
        return sendHttpPost(url, null, params, null, SMART_APP_CONFIG.getDefaultConnectTimeout(),
                SMART_APP_CONFIG.getDefaultReadTimeout());
    }

    /**
     * 发送 post请求
     */
    public static String sendHttpPost(String url, Map<String, String> headers, Map<String, Object> params) {
        return sendHttpPost(url, headers, params, null, SMART_APP_CONFIG.getDefaultConnectTimeout(),
                SMART_APP_CONFIG.getDefaultReadTimeout());
    }

    /**
     * 发送 post请求
     */
    public static String sendHttpPost(String url, Map<String, Object> params, String body) {
        return sendHttpPost(url, null, params, body, SMART_APP_CONFIG.getDefaultConnectTimeout(),
                SMART_APP_CONFIG.getDefaultReadTimeout());
    }

    /**
     * 发送 post请求
     */
    private static String sendHttpPost(String url, Map<String, String> headers, Map<String, Object> params, String body,
                                       int connectionTimeoutMillis, int readTimeoutMillis) {
        HttpRequest httpRequest = createPost(url).headerMap(headers, true).body(body).form(params)
                .setConnectionTimeout(connectionTimeoutMillis).setReadTimeout(readTimeoutMillis);
        TimeIntervalContext timeIntervalContext = TimeIntervalContext.get();
        TimeIntervalContext.RequestContext requestContext = timeIntervalContext.getRequest();
        requestContext.setBody(body);
        requestContext.setHeaders(headers);
        requestContext.setParams(params);
        requestContext.setMethod(httpRequest.getMethod().name());
        return execute(httpRequest, timeIntervalContext);
    }

    private static String execute(HttpRequest httpRequest, TimeIntervalContext timeIntervalContext) {
        HttpResponse httpResponse = httpRequest.execute();
        TimeIntervalContext.ResponseContext responseContext = timeIntervalContext.getResponse();
        responseContext.setHttpStatus(httpResponse.getStatus());
        responseContext.setTraceId(httpResponse.header("X-B3-Traceid"));
        String body = httpResponse.body();
        responseContext.setBody(body);
        return body;
    }

}
