package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.OrderService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.developer.bean.order.MainOrderData;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.developer.bean.order.SubsOrderData;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;
import com.baidu.mapp.common.validator.BaiduAssert;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl extends BaseService implements OrderService {
    private static OrderService orderService;

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = ProxyUtil.proxy(new OrderServiceImpl(), TimeIntervalAspect.class);
        }
        return orderService;
    }

    @Override
    public OperationReulst[] addOrderInfo(String accessToken, OrderQuery queryParam,
                                        MainOrderData[] orderData) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object> mapBody = new HashMap<>();
        mapBody.put("Data", orderData);

        String body = JSONUtil.toJsonStr(mapBody);
        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(ADD_ORDER_INFO, params, body);
        System.out.println(response);

        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        System.out.println(result.getData()[0]);
        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OperationReulst[] updateOrderStatus(String accessToken, OrderQuery queryParam, MainOrderData[] orderData)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("Data", orderData);
        String body = JSONUtil.toJsonStr(bodyMap);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(UPDATE_ORDER_STATUS, params, body);

        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OperationReulst[] updateOrderInfo(String accessToken, OrderQuery queryParam, MainOrderData[] orderData)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken)  ;

        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("Data", orderData);
        String body = JSONUtil.toJsonStr(bodyMap);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(UPDATE_ORDER_INFO, params, body);

        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OperationReulst[] addSubOrderInfo(String accessToken, OrderQuery queryParam, SubsOrderData[] subsOrderData)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken)  ;

        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("Data", subsOrderData);

        String body = JSONUtil.toJsonStr(objectMap);
        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(ADD_ORDER_SUB_INFO, params, body);

        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OperationReulst[] updateSubOrderInfo(String accessToken, OrderQuery queryParam,
                                                SubsOrderData[] subsOrderData)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken)  ;
        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("Data", subsOrderData);

        String body = JSONUtil.toJsonStr(bodyMap);
        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(UPDATE_ORDER_SUB_INFO, params, body);

        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OperationReulst[] updateSubOrderStatus(String accessToken, OrderQuery queryParam,
                                                SubsOrderData[] subsOrderData)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken)  ;
        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("Data", subsOrderData);
        String body = JSONUtil.toJsonStr(bodyMap);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(UPDATE_ORDER_SUB_STATUS, params, body);
        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OperationReulst[] submitLogisticsOrder(String accessToken, OrderQuery queryParam, MainOrderData[] orderData)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        params.put("open_id", queryParam.getOpenId());
        params.put("swan_id", queryParam.getSceneID());
        params.put("scene_id", queryParam.getSceneID());
        params.put("scene_type", queryParam.getSceneType());
        params.put("pm_app_key", queryParam.getPmAppKey());

        Map<String, Object>  bodyMap = new HashMap<>();
        bodyMap.put("Data", orderData);

        String body = JSONUtil.toJsonStr(bodyMap);
        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(ADD_ORDER_LOGISTICS, params, body);

        SmartAppResult<OperationReulst[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OperationReulst[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
