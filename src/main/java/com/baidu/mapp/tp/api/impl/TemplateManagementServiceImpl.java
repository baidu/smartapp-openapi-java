package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.TemplateManagementService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.template.AddToTemplate;
import com.baidu.mapp.tp.bean.template.TemplateDraftList;
import com.baidu.mapp.tp.bean.template.TemplateList;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 模板管理实现类
 * @author: chenhaonan02
 * @create: 2021-09-23 14:51
 **/
public class TemplateManagementServiceImpl extends BaseService implements TemplateManagementService {

    private static TemplateManagementService templateManagementService;

    public static TemplateManagementService getInstance() {
        if (templateManagementService == null) {
            templateManagementService =
                    ProxyUtil.proxy(new TemplateManagementServiceImpl(), TimeIntervalAspect.class);
        }
        return templateManagementService;
    }

    @Override
    public TemplateDraftList getTemplateDraftList(String accessToken, Integer page, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("page", page);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_TEMPLATE_DRAFT_LIST, params);

        SmartAppResult<TemplateDraftList> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TemplateDraftList>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public TemplateList getTemplateList(String accessToken, Integer page, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("page", page);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpGet(TP_GET_TEMPLATE_LIST, params);

        SmartAppResult<TemplateList> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TemplateList>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public AddToTemplate addToTemplate(String accessToken, Long draftId, String userDesc)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("drift_id", draftId);
        params.put("user_desc", userDesc);
        String response = SmartAppHttpUtil.sendHttpPost(TP_ADD_TO_TEMPLATE, params);

        SmartAppResult<AddToTemplate> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<AddToTemplate>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void delTemplate(String accessToken, Long templateId) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_DELETE_TEMPLATE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }
}
