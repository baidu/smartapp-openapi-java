package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.json.JSONUtil;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.ResourcesService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.developer.bean.skuresources.BJHMaterial;
import com.baidu.mapp.developer.bean.skuresources.MaterialRueslt;
import com.baidu.mapp.developer.bean.skuresources.Resources;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;
import com.baidu.mapp.common.validator.BaiduAssert;
import cn.hutool.core.lang.TypeReference;


import java.util.Map;

public class ResourcesServiceImpl extends BaseService implements ResourcesService {
    private static ResourcesService resourcesService;

    public static ResourcesService getInstance() {
        if (resourcesService == null) {
            resourcesService = ProxyUtil.proxy(new ResourcesServiceImpl(), TimeIntervalAspect.class);
        }
        return resourcesService;
    }

    @Override
    public String submitSku(String accessToken, Resources[] res) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);


        String body = JSONUtil.toJsonStr(res);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(SUBMIT_SKU_RESOURCES, params, body);
        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String deleteSku(String accessToken, int appId, String pathList) throws SmartAppErrorException,
            OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("path_list", pathList);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(DELETE_SKU_RESOURCES, params);
        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();

    }

    @Override
    public String submitSkuCoupon(String accessToken, Resources[] res)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        String body = JSONUtil.toJsonStr(res);
        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(SUBMIT_SKU_COUPON_RESOURCES, params, body);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String deleteSkuCoupon(String accessToken, int appId, String pathList) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("path_list", pathList);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DELETE_SKU_COUPON_RESOURCES, params);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String submitResource(String accessToken, int appId, String body, String ext, String feedSubType,
                                 String feedType, String images, String mappSubType,
                                 String mappType, String path, String tags, String title)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken) ;
        params.put("app_id", appId);
        params.put("body", body);
        params.put("ext", ext);
        params.put("feed_sub_type", feedSubType);
        params.put("feed_type", feedType);
        params.put("images", images);
        params.put("mapp_sub_type", mappSubType);
        params.put("mapp_type", mappType);
        params.put("path", path);
        params.put("tags", tags);
        params.put("title", title);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(SUBMIT_RESOURCE, params);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String deleteResource(String accessToken, int appId, String path) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("path", path);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(DELETE_RESOURCE, params);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String submitSitmap(String accessToken, int appId, String desc, String frequency, String type, String url)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("desc", desc);
        params.put("type", type);
        params.put("url", url);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(SUBMIT_SITMAP,  params);
        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String deleteSitmap(String accessToken, int appId, String url) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("url", url);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DELETE_SITMAP, params);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public MaterialRueslt addBJHMaterial(String accessToken, BJHMaterial material)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", material.getAppId());
        params.put("imageUrl", material.getImageUrl());
        params.put("title", material.getTitle());
        params.put("path", material.getPath());
        params.put("category1Code", material.getCategory1Code());
        params.put("category2Code", material.getCategory2Code());
        params.put("desc", material.getDesc());
        params.put("labelAttr", material.getLabelAttr());
        params.put("labelDiscount", material.getLabelDiscount());
        params.put("buttonName", material.getButtonName());
        params.put("bigImage", material.getBigImage());
        params.put("verticalImage", material.getVerticalImage());
        params.put("extJson", material.getExtJson());

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(ADD_BJH_MATERIAL,  params);

        SmartAppResult<MaterialRueslt> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<MaterialRueslt>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean modifyBJHMaterial(String accessToken, BJHMaterial material)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", material.getAppId());
        params.put("imageUrl", material.getImageUrl());
        params.put("title", material.getTitle());
        params.put("path", material.getPath());
        params.put("category1Code", material.getCategory1Code());
        params.put("category2Code", material.getCategory2Code());
        params.put("desc", material.getDesc());
        params.put("labelAttr", material.getLabelAttr());
        params.put("labelDiscount", material.getLabelDiscount());
        params.put("buttonName", material.getButtonName());
        params.put("bigImage", material.getBigImage());
        params.put("verticalImage", material.getVerticalImage());
        params.put("extJson", material.getExtJson());

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(MODIFY_BJH_MATERIAL, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean deleteBJHMaterial(String accessToken, int appId, int id, String path)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("id", id);
        params.put("path", path);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DELETE_BJH_MATERIAL, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
