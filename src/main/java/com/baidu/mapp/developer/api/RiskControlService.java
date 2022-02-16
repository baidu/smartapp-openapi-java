package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public interface RiskControlService {
    /**
     * 检测用户是否是作弊用户
     * https://smartprogram.baidu.com/docs/develop/serverapi/open_risk_power_detectrisk/
     */
    String DETECT_RISK = SmartAppConstants.OPEN_API_SMART_APP_URL + "detectrisk";

    /**
     *检测用户是否是作弊用户
     * @param appkey appkey
     * @param xtoken 小程序通过swan-getSystemRiskInfo获取的内容,格式：{"key":"xxxx","value":"xxxx"}
     * @param type  运营活动的类型，该值由风控平台分配。目前只有一种 marketing
     * @param clientip  客户端的 IP，非小程序服务本地 IP，示例：127.0.0.1
     * @param ts  服务器的时间戳，秒级别，示例：1598528349
     * @param ev 事件类型，预先分配事件 ID 定义。具体见文档
     * @param useragent 客户端请求小程序 Server 的 useragent
     * @param phone 加密后的电话号码，加密方法：sha1
     * @return  检查结果 json 字符串
     * @throws SmartAppErrorException
     */
    String detectRisk(String accessToken, String appkey, String xtoken, String type,
                      String clientip, int ts, String ev,
                      String useragent, String phone) throws SmartAppErrorException, OpenAPIErrorException;

}
