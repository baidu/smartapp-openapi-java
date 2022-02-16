package com.baidu.mapp.tp.api;

import java.util.List;

import com.baidu.mapp.tp.bean.order.OrderCenterCheckParam;
import com.baidu.mapp.tp.bean.order.Payload;
import com.baidu.mapp.tp.bean.order.PushOrderResult;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 订单同步接口
 * https://smartprogram.baidu.com/docs/third/order/intro/
 * @author: chenhaonan02
 * @create: 2021-11-12 20:35
 **/
public interface OrderService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "OrderService";
    /**
     * 导入订单信息
     * https://smartprogram.baidu.com/docs/third/order/add_order/
     */
    String ORDER_ADD_MAIN_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/add/main/info";
    /**
     * 更新订单信息
     * https://smartprogram.baidu.com/docs/third/order/update_order_info/
     */
    String ORDER_UPDATE_MAIN_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/update/main/info";
    /**
     * 更新订单状态
     * https://smartprogram.baidu.com/docs/third/order/update_order_status/
     */
    String ORDER_UPDATE_MAIN_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/update/main/status";
    /**
     * 导入售后订单信息
     * https://smartprogram.baidu.com/docs/third/order/add_post_order/
     */
    String ORDER_APPEND_SUB_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/append/sub/info";
    /**
     * 更新售后订单信息
     * https://smartprogram.baidu.com/docs/third/order/update_post_order_info/
     */
    String ORDER_UPDATE_SUB_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/update/sub/info";
    /**
     * 更新售后订单状态
     * https://smartprogram.baidu.com/docs/third/order/update_post_order_status/
     */
    String ORDER_UPDATE_SUB_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/update/sub/status";

    /**
     * 导入订单信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param param       OrderCenterCheckParam
     * @param payload     订单中心接口参数
     *
     * @return List<PushOrderResult>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<PushOrderResult> addMainInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新订单信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param param       OrderCenterCheckParam
     * @param payload     订单中心接口参数
     *
     * @return List<PushOrderResult>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<PushOrderResult> updateMainInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新订单状态
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param param       OrderCenterCheckParam
     * @param payload     订单中心接口参数
     *
     * @return List<PushOrderResult>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<PushOrderResult> updateMainStatus(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 导入售后订单信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param param       OrderCenterCheckParam
     * @param payload     订单中心接口参数
     *
     * @return List<PushOrderResult>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<PushOrderResult> appendSubInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新售后订单信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param param       OrderCenterCheckParam
     * @param payload     订单中心接口参数
     *
     * @return List<PushOrderResult>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     */
    List<PushOrderResult> updateSubInfo(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新售后订单状态
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param param       OrderCenterCheckParam
     * @param payload     订单中心接口参数
     *
     * @return List<PushOrderResult>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<PushOrderResult> updateSubStatus(String accessToken, OrderCenterCheckParam param, Payload payload)
            throws SmartAppErrorException, OpenAPIErrorException;
}
