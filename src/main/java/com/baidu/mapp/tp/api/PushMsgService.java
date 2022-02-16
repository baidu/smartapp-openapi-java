package com.baidu.mapp.tp.api;

import com.baidu.mapp.common.SmartAppPageB;
import com.baidu.mapp.tp.bean.pushmsg.PushMsg;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @author maduo
 * https://smartprogram.baidu.com/docs/third/push/push_reference/
 */
public interface PushMsgService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "PushMsg";
    /**
     * 找回推送API
     * https://smartprogram.baidu.com/docs/third/push/find_push_list/
     */
    String GET_MSG = SmartAppConstants.OPEN_API_SMART_APP_URL + "pushmsg/getmsg";

    /**
     * 推送消息查询
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param start         起始时间,默认值时间范围为近一天,起始时间不可超过一个月
     * @param end           截止时间,默认值时间范围为为近一天,最大时间范围不可超过一周
     * @param pushType      找回的推送类型 1:所有推送 2:失败推送 @see PushTypeEnum
     * @param offset        分页参数(起始条数),默认值为0
     * @param count         分页参数(显示条数),默认值为100,最大值为100
     * @param idList        推送id,多个用逗号(,)拼接,若传入该字段,以上参数字段不影响结果
     *
     * @return SmartAppPageB<PushMsg>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    SmartAppPageB<PushMsg> getMsg(String tpAccessToken, Long start, Long end, Byte pushType, Integer offset,
                                  Integer count, String idList) throws SmartAppErrorException, OpenAPIErrorException;
}
