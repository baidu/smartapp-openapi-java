package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.TemplateMessageService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.developer.bean.templatemessage.GetTemplateLibraryByIdResult;
import com.baidu.mapp.developer.bean.templatemessage.GetTemplateLibraryListResult;
import com.baidu.mapp.developer.bean.templatemessage.GetTemplateListResult;
import com.baidu.mapp.developer.bean.templatemessage.MsgKey;
import com.baidu.mapp.developer.bean.templatemessage.TemplateID;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import java.util.Map;

public class TemplateMessageServiceImpl extends BaseService implements TemplateMessageService {
    private static TemplateMessageService templateMessageService;
    public static TemplateMessageService getInstance() {
        if (templateMessageService == null) {
            templateMessageService = ProxyUtil.proxy(new TemplateMessageServiceImpl(), TimeIntervalAspect.class);
        }
        return templateMessageService;
    }

    @Override
    public GetTemplateLibraryListResult getTemplateLibraryList(String accessToken, int offset, int count)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("offset", offset);
        params.put("count", count);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(GET_TEMPLATE_LIBRARY_LIST, params);
        SmartAppResult<GetTemplateLibraryListResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<GetTemplateLibraryListResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public GetTemplateLibraryByIdResult getTemplateLibraryById(String accessToken, String id)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("id", id);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(GET_TEMPLATE_LIBARAY_ID, params);
        SmartAppResult<GetTemplateLibraryByIdResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<GetTemplateLibraryByIdResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public TemplateID addTemplate(String accessToken, String id, String keywordIdList)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("id", id);
        params.put("keyword_id_list", keywordIdList);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(ADD_TEMPLATE, params);

        SmartAppResult<TemplateID> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TemplateID>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();

    }

    @Override
    public GetTemplateListResult getTemplateList(String accessToken, int offset, int count)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("offset", offset);
        params.put("count", count);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(GET_TEMPLAET_LIST, params);

        SmartAppResult<GetTemplateListResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<GetTemplateListResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean deleteTemplate(String accessToken, String templateId) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DELETE_TEMPALTE, params);
        SmartAppResult<Object> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Object>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getErrno() == 0;
    }

    @Override
    public MsgKey sendTemplateMessage(String accessToken, String templateId, String touserOpenId,
                                      String data, String page, String sceneId, int sceneType)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        params.put("touser_openId", touserOpenId);
        params.put("data", data);
        params.put("page", page);
        params.put("scene_id", sceneId);
        params.put("scene_type", sceneType);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(SEND_TEMPLATE_MESSAGE, params);
        SmartAppResult<MsgKey> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MsgKey>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MsgKey subscribeSend(String accessToken, String templateId, String touserOpenId,
                                String subscribeId, String data, String page) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        params.put("touser_openId", touserOpenId);
        params.put("data", data);
        params.put("page", page);
        params.put("subscribe_id", subscribeId);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(SUBSCRIBE_TEMPLATE_MESSAGE, params);
        SmartAppResult<MsgKey> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MsgKey>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean customSend(String accessToken, int userType, String openId, String msgType,
                              String content, String picUrl) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("user_type", userType);
        params.put("open_id", openId);
        params.put("msg_type", msgType);
        params.put("content", content);
        params.put("pic_url", picUrl);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(SEND_CUSTOM_MESSAGE, params);
        SmartAppResult<Object> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Object>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getErrno() == 0;
    }
}
