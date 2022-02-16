package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.TemplateMessageService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.subscription.AddMessageTemplate;
import com.baidu.mapp.tp.bean.subscription.LibraryGet;
import com.baidu.mapp.tp.bean.subscription.PushTemplateMessage;
import com.baidu.mapp.tp.bean.subscription.TemplateExistsList;
import com.baidu.mapp.tp.bean.subscription.TemplateTitleList;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 模板消息接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-10 10:36
 **/
public class TemplateMessageServiceImpl extends BaseService implements TemplateMessageService {

    private static TemplateMessageService templateMessageService;

    public static TemplateMessageService getInstance() {
        if (templateMessageService == null) {
            templateMessageService =
                    ProxyUtil.proxy(new TemplateMessageServiceImpl(), TimeIntervalAspect.class);
        }
        return templateMessageService;
    }

    @Override
    public TemplateTitleList libraryList(String accessToken, Integer offset, Integer count)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("offset", offset);
        params.put("count", count);
        String response = SmartAppHttpUtil.sendHttpGet(TP_TEMPLATE_LIBRARY_LIST, params);

        SmartAppResult<TemplateTitleList> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TemplateTitleList>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public LibraryGet libraryGet(String accessToken, String id) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("id", id);
        String response = SmartAppHttpUtil.sendHttpGet(TP_TEMPLATE_LIBRARY_GET, params);

        SmartAppResult<LibraryGet> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<LibraryGet>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public TemplateExistsList templateList(String accessToken, Integer offset, Integer count)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("offset", offset);
        params.put("count", count);
        String response = SmartAppHttpUtil.sendHttpGet(TP_TEMPLATE_LIST, params);

        SmartAppResult<TemplateExistsList> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TemplateExistsList>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public AddMessageTemplate templateAdd(String accessToken, Integer id, String keywordIdList)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("id", id);
        params.put("keyword_id_list", keywordIdList);
        String response = SmartAppHttpUtil.sendHttpPost(TP_TEMPLATE_ADD, params);

        SmartAppResult<AddMessageTemplate> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<AddMessageTemplate>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void templateDel(String accessToken, String templateId) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_TEMPLATE_DEL, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public PushTemplateMessage send(String accessToken, String templateId, String touser, String touserOpenId,
                                    String data, String page, String sceneId, Integer sceneType, String title,
                                    String ext, String description) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        params.put("touser", touser);
        params.put("touser_openId", touserOpenId);
        params.put("data", data);
        params.put("page", page);
        params.put("scene_id", sceneId);
        params.put("scene_type", sceneType);
        params.put("title", title);
        params.put("ext", ext);
        params.put("description", description);
        String response = SmartAppHttpUtil.sendHttpPost(TP_TEMPLATE_SEND_MESSAGE, params);

        SmartAppResult<PushTemplateMessage> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PushTemplateMessage>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
