package com.baidu.mapp.tp.api.impl;

import java.util.List;
import java.util.Map;

import com.baidu.mapp.tp.api.ThirdPartyDomainService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.domain.Domains;
import com.baidu.mapp.common.enums.ActionEnum;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 设置第三方域名接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-15 10:47
 **/
public class ThirdPartyDomainServiceImpl extends BaseService implements ThirdPartyDomainService {

    private static ThirdPartyDomainService thirdPartyDomainService;

    public static ThirdPartyDomainService getInstance() {
        if (thirdPartyDomainService == null) {
            thirdPartyDomainService =
                    ProxyUtil.proxy(new ThirdPartyDomainServiceImpl(), TimeIntervalAspect.class);
        }
        return thirdPartyDomainService;
    }

    @Override
    public Domains modifyDomain(String accessToken, ActionEnum action, String requestDomain, String uploadDomain,
                                String downloadDomain, String socketDomain)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("action", action);
        params.put("request_domain", requestDomain);
        params.put("upload_domain", uploadDomain);
        params.put("download_domain", downloadDomain);
        params.put("socket_domain", socketDomain);
        String response = SmartAppHttpUtil.sendHttpPost(TP_MODIIFY_DOMAIN, params);

        SmartAppResult<Domains> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Domains>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<String> modifyWebViewDomain(String accessToken, ActionEnum action, String webViewDomain)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("action", action);
        params.put("web_view_domain", webViewDomain);
        String response = SmartAppHttpUtil.sendHttpPost(TP_MODIFY_WEB_VIEW_DOMAIN, params);

        SmartAppResult<List<String>> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<List<String>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void publish(String accessToken) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("access_token", accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_DOWNLOAD_DOMAINCER, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }
}
