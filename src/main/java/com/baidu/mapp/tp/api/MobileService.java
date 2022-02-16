package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.mobile.MobileAuthStatus;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 获取手机号接口
 * @author: chenhaonan02
 * @create: 2021-11-10 16:06
 **/
public interface MobileService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "MobileService";
    /**
     * 申请手机号权限
     * https://smartprogram.baidu.com/docs/third/phone/apply_phone/
     */
    String TP_APP_APPLY_MOBILE_AUTH = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/apply/mobileauth";
    /**
     * 取消手机号权限
     * https://smartprogram.baidu.com/docs/third/phone/cancel_phone/
     */
    String TP_APP_CANCEL_MOBILE_AUTH = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/cancel/mobileauth";
    /**
     * 查询手机号权限状态
     * https://smartprogram.baidu.com/docs/third/phone/phone_privilege/
     */
    String TP_APP_GET_MOBILE_AUTH_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/get/mobileauthstatus";

    /**
     * 申请手机号权限
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param reason      申请原因
     *                    0："用于登录"
     *                    1 ："收货联系方式"
     *                    2 ："其他"
     * @param usedScene   使用场景
     *                    0："网络购物"
     *                    1 ："账号下信息内容同步"
     *                    2 ："票务预订"
     *                    3 ："业务办理"
     *                    4 ："信息查询（如社保、公积金查询"
     *                    5 ：预约"
     * @param sceneDesc   使用场景描述
     * @param sceneDemo   使用场景 demo （场景实例图片）
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void applyMobileAuth(String accessToken, Integer reason, Integer usedScene, String sceneDesc, String sceneDemo)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 取消手机号权限
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void cancelMobileAuth(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查询手机号权限状态
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return 手机权限状态
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MobileAuthStatus getMobileAuthStatus(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;
}
