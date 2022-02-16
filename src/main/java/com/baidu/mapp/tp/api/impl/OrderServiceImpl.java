package com.baidu.mapp.tp.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.mapp.tp.api.OrderService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.enums.SmartAppErrorCode;
import com.baidu.mapp.tp.bean.order.OrderCenterCheckParam;
import com.baidu.mapp.tp.bean.order.Payload;
import com.baidu.mapp.tp.bean.order.PushOrderResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 订单同步接口实现类
 * @author: chenhaonan02
 * @create: 2021-12-03 19:14
 **/
public class OrderServiceImpl extends BaseService implements OrderService {

    private static OrderService orderService;

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService =
                    ProxyUtil.proxy(new OrderServiceImpl(), TimeIntervalAspect.class);
        }
        return orderService;
    }

    @Override
    public List<PushOrderResult> addMainInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", param.getOpenId());
        params.put("swan_id", param.getSwanId());
        params.put("scene_id", param.getSceneId());
        params.put("scene_type", param.getSceneType());
        params.put("pm_app_key", param.getPmAppKey());
        params.put("hostname", param.getHostname());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String response = null;
        try {
            response = SmartAppHttpUtil.sendHttpPost(ORDER_ADD_MAIN_INFO, headers, params);
        } catch (Exception e) {
            throw new SmartAppErrorException(SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getCode(),
                    SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getMsg());
        }

        SmartAppResult<List<PushOrderResult>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PushOrderResult>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<PushOrderResult> updateMainInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", param.getOpenId());
        params.put("swan_id", param.getSwanId());
        params.put("scene_id", param.getSceneId());
        params.put("scene_type", param.getSceneType());
        params.put("pm_app_key", param.getPmAppKey());
        params.put("hostname", param.getHostname());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String response = null;
        try {
            response = SmartAppHttpUtil.sendHttpPost(ORDER_UPDATE_MAIN_INFO, headers, params);
        } catch (Exception e) {
            throw new SmartAppErrorException(SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getCode(),
                    SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getMsg());
        }

        SmartAppResult<List<PushOrderResult>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PushOrderResult>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<PushOrderResult> updateMainStatus(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", param.getOpenId());
        params.put("swan_id", param.getSwanId());
        params.put("scene_id", param.getSceneId());
        params.put("scene_type", param.getSceneType());
        params.put("pm_app_key", param.getPmAppKey());
        params.put("hostname", param.getHostname());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String response = null;
        try {
            response = SmartAppHttpUtil.sendHttpPost(ORDER_UPDATE_MAIN_STATUS, headers, params);
        } catch (Exception e) {
            throw new SmartAppErrorException(SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getCode(),
                    SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getMsg());
        }

        SmartAppResult<List<PushOrderResult>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PushOrderResult>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<PushOrderResult> appendSubInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", param.getOpenId());
        params.put("swan_id", param.getSwanId());
        params.put("scene_id", param.getSceneId());
        params.put("scene_type", param.getSceneType());
        params.put("pm_app_key", param.getPmAppKey());
        params.put("hostname", param.getHostname());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String response = null;
        try {
            response = SmartAppHttpUtil.sendHttpPost(ORDER_APPEND_SUB_INFO, headers, params);
        } catch (Exception e) {
            throw new SmartAppErrorException(SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getCode(),
                    SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getMsg());
        }

        SmartAppResult<List<PushOrderResult>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PushOrderResult>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<PushOrderResult> updateSubInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", param.getOpenId());
        params.put("swan_id", param.getSwanId());
        params.put("scene_id", param.getSceneId());
        params.put("scene_type", param.getSceneType());
        params.put("pm_app_key", param.getPmAppKey());
        params.put("hostname", param.getHostname());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String response = null;
        try {
            response = SmartAppHttpUtil.sendHttpPost(ORDER_UPDATE_SUB_INFO, headers, params);
        } catch (Exception e) {
            throw new SmartAppErrorException(SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getCode(),
                    SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getMsg());
        }

        SmartAppResult<List<PushOrderResult>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PushOrderResult>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<PushOrderResult> updateSubStatus(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("open_id", param.getOpenId());
        params.put("swan_id", param.getSwanId());
        params.put("scene_id", param.getSceneId());
        params.put("scene_type", param.getSceneType());
        params.put("pm_app_key", param.getPmAppKey());
        params.put("hostname", param.getHostname());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String response = null;
        try {
            response = SmartAppHttpUtil.sendHttpPost(ORDER_UPDATE_SUB_STATUS, headers, params);
        } catch (Exception e) {
            throw new SmartAppErrorException(SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getCode(),
                    SmartAppErrorCode.THIRD_SERVER_UNKNOWN_FAIL.getMsg());
        }

        SmartAppResult<List<PushOrderResult>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PushOrderResult>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
