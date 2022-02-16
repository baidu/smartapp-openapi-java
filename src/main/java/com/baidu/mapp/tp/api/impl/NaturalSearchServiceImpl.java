package com.baidu.mapp.tp.api.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.baidu.mapp.tp.api.NaturalSearchService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.search.AppNameChecked;
import com.baidu.mapp.tp.bean.search.QueryKeywordClient;
import com.baidu.mapp.tp.bean.search.SitemapTrafficData;
import com.baidu.mapp.tp.bean.search.SubChainInfo;
import com.baidu.mapp.tp.bean.search.TopQueryInfo;
import com.baidu.mapp.tp.bean.search.UrlMapping;
import com.baidu.mapp.tp.bean.search.UrlMappingOverview;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 自然搜索接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-15 16:59
 **/
public class NaturalSearchServiceImpl extends BaseService implements NaturalSearchService {

    private static NaturalSearchService naturalSearchService;

    public static NaturalSearchService getInstance() {
        if (naturalSearchService == null) {
            naturalSearchService =
                    ProxyUtil.proxy(new NaturalSearchServiceImpl(), TimeIntervalAspect.class);
        }
        return naturalSearchService;
    }

    @Override
    public AppNameChecked modifyWebStatus(String accessToken, Integer webStatus)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("web_status", webStatus);
        String response = SmartAppHttpUtil.sendHttpPost(TP_APP_MODIFY_WEB_STATUS, params);

        SmartAppResult<AppNameChecked> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<AppNameChecked>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String uploadRobotsForApp(String accessToken, File robots)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("robots", robots);
        String response = SmartAppHttpUtil.sendHttpPost(TP_ROBOTS_APP_UPLOAD, params);

        SmartAppResult<String> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<String>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public String uploadRobotsForTemplate(String accessToken, Long templateId, File robots)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        params.put("robots", robots);
        String response = SmartAppHttpUtil.sendHttpPost(TP_ROBOTS_TEMPLATE_UPLOAD, params);

        SmartAppResult<String> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<String>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void submitSitemapByApi(String accessToken, Integer type, List<String> urlList)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("type", type);
        params.put("url_list", urlList);
        String response = SmartAppHttpUtil.sendHttpPost(TP_ACCESS_SUBMIT_SITEMAP, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public Boolean bindSite(String accessToken, List<String> sites) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("sites", sites);
        String response = SmartAppHttpUtil.sendHttpPost(TP_FLOW_BIND_SITE, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<String> getBindSite(String accessToken, Integer pageNum, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("page_num", pageNum);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpPost(TP_FLOW_GET_BIND_SITE, params);

        SmartAppResult<List<String>> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<List<String>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean saveUrlMapping(String accessToken, String content, Byte createMethod)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("content", content);
        params.put("create_method", createMethod);
        String response = SmartAppHttpUtil.sendHttpPost(TP_FLOW_SAVE_URL_MAPPING, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public UrlMappingOverview queryUrlMapping(String accessToken, Integer pageNum, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("page_num", pageNum);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpPost(TP_FLOW_QUERY_URL_MAPPING, params);

        SmartAppResult<UrlMappingOverview> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<UrlMappingOverview>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<UrlMapping> getUrlMappingDetail(String accessToken, Long ruleId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("rule_id", ruleId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_FLOW_GET_URL_MAPPING_DETAIL, params);

        SmartAppResult<List<UrlMapping>> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<List<UrlMapping>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean delUrlMapping(String accessToken, String delRuleId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("del_rule_id", delRuleId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_FLOW_DEL_URL_MAPPING, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public SitemapTrafficData getSitemapMeta(String accessToken, Integer timeSpan)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("time_span", timeSpan);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PROMOTION_SITEMAP_GET_ANALYSIS_CTR, params);

        SmartAppResult<SitemapTrafficData> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<SitemapTrafficData>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public TopQueryInfo getTopQueryUrlInfo(String accessToken, Integer timeSpan, Integer pageNum, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("time_span", timeSpan);
        params.put("page_num", pageNum);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PROMOTION_TOP_QUERY_INFO, params);

        SmartAppResult<TopQueryInfo> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<TopQueryInfo>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public QueryKeywordClient getQueryKeyword(String accessToken, String webUrl, Integer timeSpan, Integer pageNum,
                                              Integer pageSize) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("web_url", webUrl);
        params.put("time_span", timeSpan);
        params.put("page_num", pageNum);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PROMOTION_TOP_QUERY_KEYWORD, params);

        SmartAppResult<QueryKeywordClient> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<QueryKeywordClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Long addSubChain(String accessToken, String chainName, String chainDesc, String chainPath, String telephone)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("chain_name", chainName);
        params.put("chain_desc", chainDesc);
        params.put("chain_path", chainPath);
        params.put("telephone", telephone);
        String response = SmartAppHttpUtil.sendHttpPost(TP_SUB_CHAIN_ADD, params);

        SmartAppResult<Long> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Long>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean deleteSubChain(String accessToken, Long subChainId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("subchain_id", subChainId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_SUB_CHAIN_DELETE, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean updateSubChain(String accessToken, Long subChainId, String chainName, String chainDesc,
                                  String chainPath, String telephone)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("subchain_id", subChainId);
        params.put("chain_name", chainName);
        params.put("chain_desc", chainDesc);
        params.put("chain_path", chainPath);
        params.put("telephone", telephone);
        String response = SmartAppHttpUtil.sendHttpPost(TP_SUB_CHAIN_UPDATE, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public SubChainInfo getAllSubChain(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_SUB_CHAIN_GET_ALL, params);

        SmartAppResult<SubChainInfo> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<SubChainInfo>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean rankSubChain(String accessToken, List<Long> subChainIdList)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("subchain_ranklist", subChainIdList);
        String response = SmartAppHttpUtil.sendHttpPost(TP_SUB_CHAIN_RANK, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean stopSubChain(String accessToken, Long subChainId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("subchain_id", subChainId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_SUB_CHAIN_STOP, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean startSubChain(String accessToken, Long subChainId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("subchain_id", subChainId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_SUB_CHAIN_RESTART, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
