package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.FeedService;
import com.baidu.mapp.common.SmartAppPageB;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.feed.AccessResource;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

public class FeedServiceImpl extends BaseService implements FeedService {
    private static FeedService feedService;

    public static FeedService getInstance() {
        if (feedService == null) {
            feedService =
                    ProxyUtil.proxy(new FeedServiceImpl(), TimeIntervalAspect.class);
        }
        return feedService;
    }

    @Override
    public String accessResourceSubmit(String accessToken, String title, String body, String path, String images,
                                       Long mappType, Long mappSubType, String feedType, String feedSubType,
                                       String tags, String ext) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("title", title);
        params.put("body", body);
        params.put("path", path);
        params.put("images", images);
        params.put("mapp_tpe", mappType);
        params.put("mapp_sub_type", mappSubType);
        params.put("feed_type", feedType);
        params.put("feed_sub_type", feedSubType);
        params.put("tags", tags);
        params.put("ext", ext);

        String response = SmartAppHttpUtil.sendHttpPost(RESOURCE_SUBMIT, params);

        SmartAppResult<String> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<String>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public SmartAppPageB<AccessResource> accessResourceQuery(String accessToken, String title, Integer status,
                                                             Long begin, Long end, Integer pageNo, Integer pageSize,
                                                             Integer imageType)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("title", title);
        params.put("status", status);
        params.put("begin", begin);
        params.put("end", end);
        params.put("page_no", pageNo);
        params.put("page_size", pageSize);
        params.put("image_type", imageType);

        String response = SmartAppHttpUtil.sendHttpGet(RESOURCE_QUERY, params);

        SmartAppResult<SmartAppPageB<AccessResource>> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<SmartAppPageB<AccessResource>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Object deleteResource(String accessToken, Long appId, String path)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("path", path);

        String response = SmartAppHttpUtil.sendHttpPost(RESOURCE_DELETE, params);

        SmartAppResult<Object> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Object>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean submitSitemap(String accessToken, Long appId, String desc, Long frequency, Long type, String url)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("desc", desc);
        params.put("frequency", frequency);
        params.put("type", type);
        params.put("url", url);

        String response = SmartAppHttpUtil.sendHttpPost(SITEMAP_SUBMIT, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Object deleteSitemap(String accessToken, Long appId, String url)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_id", appId);
        params.put("url", url);

        String response = SmartAppHttpUtil.sendHttpPost(SITEMAP_DELETE, params);

        SmartAppResult<Object> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Object>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
