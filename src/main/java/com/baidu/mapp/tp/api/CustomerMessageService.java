package com.baidu.mapp.tp.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 客服消息接口
 * https://smartprogram.baidu.com/docs/third/customer/customerability/
 * @author: chenhaonan02
 * @create: 2021-11-15 10:05
 **/
public interface CustomerMessageService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "CustomerMessageService";
    /**
     * 发送客服消息
     * https://smartprogram.baidu.com/docs/third/customer/sendmsg/
     */
    String TP_MESSAGE_CUSTOMER_SEND_BY_TP = SmartAppConstants.OPEN_API_SMART_APP_URL + "message/custom/sendbytp";

    /**
     * 发送客服消息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param userType    1:游客登录 2:百度账号登录
     * @param openId      用户的 OpenID
     * @param msgType     消息类型 text:文本格式 image:图片链接
     * @param content     文本消息内容，msg_type ="text" 时必填
     * @param picUr       图片消息，msg_type ="image" 时必填
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void downLink(String accessToken, Byte userType, String openId, String msgType, String content, String picUr)
            throws SmartAppErrorException, OpenAPIErrorException;
}
