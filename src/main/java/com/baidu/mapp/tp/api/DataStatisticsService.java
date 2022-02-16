package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.data.DataContentInfo;
import com.baidu.mapp.tp.bean.data.DataInfo;
import com.baidu.mapp.tp.bean.data.MTJDataStatisticsResult;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 数据统计分析接口
 * https://smartprogram.baidu.com/docs/third/data/datastatistics/
 * @author: chenhaonan02
 * @create: 2021-11-12 20:40
 **/
public interface DataStatisticsService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "DataStatisticsService";
    /**
     * 用户趋势
     * https://smartprogram.baidu.com/docs/third/data/getanalysisusertrend/
     */
    String TP_DATA_GET_ANALYSIS_USER_TREND = SmartAppConstants.OPEN_API_SMART_APP_URL + "data/getanalysisusertrend";
    /**
     * 活跃用户
     * https://smartprogram.baidu.com/docs/third/data/getanalysisactivityuser/
     */
    String TP_DATA_GET_ANALYSIS_ACTIVITY_USER = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "data/getanalysisactivityuser";
    /**
     * 活跃用户留存
     * https://smartprogram.baidu.com/docs/third/data/getanalysisretaineduser/
     */
    String TP_DATA_GET_ANALYSIS_RETAINED_USER = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "data/getanalysisretaineduser";
    /**
     * 用户画像
     * https://smartprogram.baidu.com/docs/third/data/getanalysisvisitattribute/
     */
    String TP_DATA_GET_ANALYSIS_VISIT_ATTRIBUTE = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "data/getanalysisvisitattribute";
    /**
     * 地域分布
     * https://smartprogram.baidu.com/docs/third/data/getanalysisregion/
     */
    String TP_DATA_GET_ANALYSIS_REGION = SmartAppConstants.OPEN_API_SMART_APP_URL + "data/getanalysisregion";
    /**
     * 终端分布
     * https://smartprogram.baidu.com/docs/third/data/getanalysisterminal/
     */
    String TP_DATA_GET_ANALYSIS_TERMINAL = SmartAppConstants.OPEN_API_SMART_APP_URL + "data/getanalysisterminal";
    /**
     * 页面分析
     * https://smartprogram.baidu.com/docs/third/data/getanalysisvisitpage/
     */
    String TP_DATA_GET_ANALYSIS_VISIT_PAGE = SmartAppConstants.OPEN_API_SMART_APP_URL + "data/getanalysisvisitpage";
    /**
     * 用户习惯
     * https://smartprogram.baidu.com/docs/third/data/getanalysisvisitcharacter/
     */
    String TP_DATA_GET_ANALYSIS_VISIT_CHARACTER = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "data/getanalysisvisitcharacter";
    /**
     * 来源分析
     * https://smartprogram.baidu.com/docs/third/data/getanalysissource/
     */
    String TP_DATA_GET_ANALYSIS_SOURCE = SmartAppConstants.OPEN_API_SMART_APP_URL + "data/getanalysissource";
    /**
     * TP平台数据汇总
     * https://smartprogram.baidu.com/docs/third/data/gettpdata/
     */
    String TP_DATA_GET_TP_DATA = SmartAppConstants.OPEN_API_SMART_APP_URL + "data/gettpdata";

    /**
     * 用户趋势
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param startIndex  数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     * @param gran        数据粒度：day/hour/week/month
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisUserTrend(String accessToken, Integer startIndex, String startDate,
                                                 String endDate, String gran)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 活跃用户
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param startIndex  数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     *
     * @return 智能小程序异常类
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisActivityUser(String accessToken, Integer startIndex, String startDate,
                                                    String endDate) throws SmartAppErrorException,
            OpenAPIErrorException;

    /**
     * 活跃用户留存
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param reportType  报告数据类型:可选count数量类型、ratio比率类型，决定返回的指标内容
     * @param startIndex  数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     * @param gran        数据粒度：day/week/month
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisRetainedUser(String accessToken, String reportType, Integer startIndex,
                                                    String startDate,
                                                    String endDate, String gran)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 用户画像
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisVisitAttribute(String accessToken, String startDate, String endDate
    ) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 地域分布
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param startIndex  数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     *
     * @return 结束日期：20190415
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisRegion(String accessToken, Integer startIndex, String startDate, String endDate)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 终端分布
     *
     * @param accessToken  授权小程序的接口调用凭据
     * @param terminalType 终端数据类型。
     * @param startIndex   数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate    开始日期：20190410
     * @param endDate      结束日期：20190415
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisTerminalInfo(String accessToken, String terminalType, Integer startIndex,
                                                    String startDate, String endDate)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 页面分析
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param startIndex  数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisVisitPage(String accessToken, Integer startIndex, String startDate,
                                                 String endDate) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 用户习惯
     *
     * @param accessToken   授权小程序的接口调用凭据
     * @param characterType 习惯分类：depth/time/interval/frequency
     * @param startIndex    数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate     开始日期：20190410
     * @param endDate       结束日期：20190415
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisVisitCharacter(String accessToken, String characterType, Integer startIndex,
                                                      String startDate, String endDate)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 来源分析
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param startIndex  数据偏移位置，接口默认返回 20 条数据，可使用该偏移量进行翻页查看
     * @param startDate   开始日期：20190410
     * @param endDate     结束日期：20190415
     *
     * @return MTJDataStatisticsResult
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    MTJDataStatisticsResult getAnalysisSourceInfo(String accessToken, Integer startIndex, String startDate,
                                                  String endDate) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * TP平台数据汇总
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param scene         小程序来源ID (场景值) 。不传则查询所有场景,场景值参数参考: [百度APP 场景值](https://smartprogram.baidu
     *                      .com/docs/data/scene/)
     * @param metrics       指标以逗号分隔
     * @param startDate     起始时间戳,格式如 20190321
     * @param endDate       结束时间戳,格式如 20190325
     * @param startIndex    偏移量,默认为0(分页操作从第几条开始展示)
     * @param maxResults    页面大小,默认值20(分页操作查询条数)
     *
     * @return 调用mtj获得结果后 返回给tp的数据格式
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    DataInfo<DataContentInfo> getData(String tpAccessToken, String scene, String metrics, String startDate,
                                      String endDate, Integer startIndex, Integer maxResults)
            throws SmartAppErrorException, OpenAPIErrorException;
}
