package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.DataStatisticsService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.data.DataContentInfo;
import com.baidu.mapp.tp.bean.data.DataInfo;
import com.baidu.mapp.tp.bean.data.MTJDataStatisticsResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 数据统计分析接口
 * @author: chenhaonan02
 * @create: 2021-11-12 21:30
 **/
public class DataStatisticsServiceImpl extends BaseService implements DataStatisticsService {

    private static DataStatisticsService dataStatisticsService;

    public static DataStatisticsService getInstance() {
        if (dataStatisticsService == null) {
            dataStatisticsService =
                    ProxyUtil.proxy(new DataStatisticsServiceImpl(), TimeIntervalAspect.class);
        }
        return dataStatisticsService;
    }

    @Override
    public MTJDataStatisticsResult getAnalysisUserTrend(String accessToken, Integer startIndex, String startDate,
                                                        String endDate, String gran)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        params.put("gran", gran);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_USER_TREND, params);

        SmartAppResult<MTJDataStatisticsResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisActivityUser(String accessToken, Integer startIndex, String startDate,
                                                           String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_ACTIVITY_USER, params);

        SmartAppResult<MTJDataStatisticsResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisRetainedUser(String accessToken, String reportType, Integer startIndex,
                                                           String startDate, String endDate, String gran)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("report_type", reportType);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        params.put("gran", gran);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_RETAINED_USER, params);

        SmartAppResult<MTJDataStatisticsResult> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisVisitAttribute(String accessToken, String startDate, String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_VISIT_ATTRIBUTE, params);

        SmartAppResult<MTJDataStatisticsResult> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisRegion(String accessToken, Integer startIndex, String startDate,
                                                     String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_REGION, params);

        SmartAppResult<MTJDataStatisticsResult> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisTerminalInfo(String accessToken, String terminalType, Integer startIndex,
                                                           String startDate, String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("terminal_type", terminalType);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_TERMINAL, params);

        SmartAppResult<MTJDataStatisticsResult> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisVisitPage(String accessToken, Integer startIndex, String startDate,
                                                        String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_VISIT_PAGE, params);

        SmartAppResult<MTJDataStatisticsResult> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisVisitCharacter(String accessToken, String characterType,
                                                             Integer startIndex, String startDate, String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("character_type", characterType);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_VISIT_CHARACTER, params);

        SmartAppResult<MTJDataStatisticsResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MTJDataStatisticsResult getAnalysisSourceInfo(String accessToken, Integer startIndex, String startDate,
                                                         String endDate)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DATA_GET_ANALYSIS_SOURCE, params);

        SmartAppResult<MTJDataStatisticsResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MTJDataStatisticsResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public DataInfo<DataContentInfo> getData(String accessToken, String scene, String metrics, String startDate,
                                             String endDate, Integer startIndex, Integer maxResults)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("scene", scene);
        params.put("metrics", metrics);
        params.put("start_index", startIndex);
        params.put("start_date", startDate);
        params.put("end_date", endDate);
        params.put("max_results", maxResults);
        String response = SmartAppHttpUtil.sendHttpGet(TP_DATA_GET_TP_DATA, params);

        SmartAppResult<DataInfo<DataContentInfo>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<DataInfo<DataContentInfo>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
