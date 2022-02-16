package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.tp.bean.violation.ViolationAppDetails;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 违规下线接口
 * https://smartprogram.baidu.com/docs/third/offline/intro/
 * @author: chenhaonan02
 * @create: 2021-11-09 20:45
 **/
public interface OfflineViolationService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "OfflineViolation";
    /**
     * 制下线后修改基本信息
     * https://smartprogram.baidu.com/docs/third/offline/updateinfo/
     */
    String TP_APP_OFFLINE_UPDATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/offline/update";
    /**
     * 获取小程序违规任务详情
     * https://smartprogram.baidu.com/docs/third/offline/violationinfo/
     */
    String TP_APP_VIOLATION = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/violation";

    /**
     * 强制下线后修改基本信息
     *
     * @param accessToken     授权小程序的接口调用凭据
     * @param appName         小程序名称
     * @param appDesc         小程序描述
     * @param photoAddr       小程序图片
     * @param appNameMaterial 名称相关物料
     *
     * @return 修改小程序信息审核
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Examine updateForOffline(String accessToken, String appName, String appDesc, String photoAddr,
                             String appNameMaterial) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取小程序违规任务详情
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return 小程序违规原因
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    ViolationAppDetails getViolationAppInfo(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;
}
