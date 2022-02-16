package com.baidu.mapp.tp.api;

import com.baidu.mapp.common.SmartAppPageA;
import com.baidu.mapp.tp.bean.grade.AppGrade;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @author maduo
 * https://smartprogram.baidu.com/docs/third/app_grade/grade/
 */
public interface AppGradeService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "AppGrade";
    /**
     * 获取小程序等级
     * https://smartprogram.baidu.com/docs/third/app_grade/grade/
     */
    String APP_GRADE = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/grade";

    /**
     * 获取小程序等级
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param pageNo        pageNo
     *
     * @return SmartAppPageA<AppGrade> 小程序等级分页列表
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    SmartAppPageA<AppGrade> appGrade(String tpAccessToken, Long pageNo)
            throws SmartAppErrorException, OpenAPIErrorException;
}
