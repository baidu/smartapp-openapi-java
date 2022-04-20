package com.baidu.mapp.developer.api.impl;

import java.io.File;
import java.util.Map;

import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.ContentSecurityService;
import com.baidu.mapp.developer.bean.contentsecurity.CommonCheckResult;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class ContentSecurityServiceImpl extends BaseService implements ContentSecurityService {
    private static ContentSecurityService contentSecurityService;

    public static ContentSecurityService getInstance() {
        if (contentSecurityService == null) {
            contentSecurityService = ProxyUtil.proxy(new ContentSecurityServiceImpl(), TimeIntervalAspect.class);
        }
        return contentSecurityService;
    }

    @Override
    public CommonCheckResult checkText(String accessToken, String content, String[] type)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        JSONObject obj = JSONUtil.createObj();
        obj.putOnce("conent", content);
        obj.putOnce("type",  type);

        String body = JSONUtil.toJsonStr(obj.toString());

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(CHECK_TEXT , params, body);

        SmartAppResult<CommonCheckResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CommonCheckResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response, true);
        return result.getData();
    }

    @Override
    public CommonCheckResult checkImage(String accessToken, String imagePath, String type)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("type", type);
        params.put("image", new File(imagePath));

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(CHECK_IMG, params);
        SmartAppResult<CommonCheckResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CommonCheckResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String checkPath(String accessToken, String path, String[] type)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        JSONObject obj = JSONUtil.createObj();
        obj.putOnce("path", path);
        obj.putOnce("type",  type);

        String body = JSONUtil.toJsonStr(obj.toString());

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(CHECK_PATH, params, body);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean misjudgeFeedback(String accessToken, String retrieveId) {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("retrieveId", "9cb878e0690064803952506287361297db1f37df76f5c084600960e878bc9");

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(MISJUDGE_FEEDBACK, params);
        SmartAppResult<Object> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Object>>() {
                }.getType(), true);
        return result.getErrno() == 0;
    }
}
