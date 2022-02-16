package com.baidu.mapp.tp.api.impl;

import java.util.List;
import java.util.Map;

import com.baidu.mapp.tp.api.AppService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.app.AppNameChecked;
import com.baidu.mapp.tp.bean.app.AppSupportVersion;
import com.baidu.mapp.tp.bean.app.CategoryItem;
import com.baidu.mapp.tp.bean.app.Domain;
import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 基本信息实现类
 * @author: chenhaonan02
 * @create: 2021-10-28 21:15
 **/
public class AppServiceImpl extends BaseService implements AppService {

    private static AppService appService;

    public static AppService getInstance() {
        if (appService == null) {
            appService = ProxyUtil.proxy(new AppServiceImpl(), TimeIntervalAspect.class);
        }
        return appService;
    }

    @Override
    public Examine setNickName(String accessToken, String nickName, String material)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("nike_name", nickName);
        params.put("material", material);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_SET_NICK_NAME, params);

        SmartAppResult<Examine> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Examine>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public AppNameChecked checkNameWithQual(String accessToken, String appName, String materials)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_name", appName);
        params.put("materials", materials);
        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_CHECK_NICK_NAME, params);

        SmartAppResult<AppNameChecked> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<AppNameChecked>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Examine modifyIcon(String accessToken, String imageUrl) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("image_url", imageUrl);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_MODIFY_ICON, params);

        SmartAppResult<Examine> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Examine>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Examine modifySignature(String accessToken, String signature)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("signature", signature);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_MODIFY_SIGNATURE, params);

        SmartAppResult<Examine> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Examine>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Examine categoryUpdate(String accessToken, String categories)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("categories", categories);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_UPDATE_CATEGORY, params);

        SmartAppResult<Examine> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Examine>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<CategoryItem> categoryList(String accessToken, Integer categoryType)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("category_type", categoryType);
        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_CATEGORY_LIST, params);

        SmartAppResult<List<CategoryItem>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<CategoryItem>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void pause(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_PAUSE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void restart(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_RESUME, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void control(String accessToken, Byte type) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("type", type);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_FLOW_CONTROL, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void qrCode(String accessToken, String path, Long packageId, Integer width)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("path", path);
        params.put("package_id", packageId);
        params.put("width", width);
        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_QRCODE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public AppSupportVersion getSupportVersion(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_APP_GET_SUPPORT_VERSION, params);

        SmartAppResult<AppSupportVersion> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<AppSupportVersion>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Domain modifyDomain(String accessToken, String action, String downloadDomain, String requestDomain,
                               String socketDomain, String uploadDomain)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("action", action);
        params.put("download_domain", downloadDomain);
        params.put("request_domain", requestDomain);
        params.put("socket_domain", socketDomain);
        params.put("upload_domain", uploadDomain);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_MODIFY_DOMAIN, params);

        SmartAppResult<Domain> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Domain>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String modifyWebViewDomain(String accessToken, String action, String webViewDomain)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("action", action);
        params.put("web_view_domain", webViewDomain);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_MODIFY_WEB_VIEW_DOMAIN, params);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}