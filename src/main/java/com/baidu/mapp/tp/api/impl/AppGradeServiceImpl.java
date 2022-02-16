package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.AppGradeService;
import com.baidu.mapp.common.SmartAppPageA;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.grade.AppGrade;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author maduo
 */
@Slf4j
public class AppGradeServiceImpl extends BaseService implements AppGradeService {

    private static AppGradeService appGradeService;

    public static AppGradeService getInstance() {
        if (appGradeService == null) {
            appGradeService = ProxyUtil.proxy(new AppGradeServiceImpl(), TimeIntervalAspect.class);
        }
        return appGradeService;
    }

    @Override
    public SmartAppPageA<AppGrade> appGrade(String accessToken, Long pageNo)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("page_no", pageNo);

        String response = SmartAppHttpUtil.sendHttpGet(APP_GRADE, params);

        SmartAppResult<SmartAppPageA<AppGrade>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<SmartAppPageA<AppGrade>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
