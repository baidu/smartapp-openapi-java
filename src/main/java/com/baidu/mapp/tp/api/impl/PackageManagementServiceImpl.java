package com.baidu.mapp.tp.api.impl;

import java.util.List;
import java.util.Map;

import com.baidu.mapp.tp.api.PackageManagementService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.pkg.PackageResp;
import com.baidu.mapp.tp.bean.pkg.TpPkgSubmitAuditQuota;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 小程序包管理实现类
 * @author: chenhaonan02
 * @create: 2021-10-26 15:03
 **/
public class PackageManagementServiceImpl extends BaseService implements PackageManagementService {

    private static PackageManagementService packageManagementService;

    public static PackageManagementService getInstance() {
        if (packageManagementService == null) {
            packageManagementService =
                    ProxyUtil.proxy(new PackageManagementServiceImpl(), TimeIntervalAspect.class);
        }
        return packageManagementService;
    }

    @Override
    public void upload(String accessToken, Long templateId, String extJson, String userVersion, String userDesc,
                       String testAccount, String testPassword) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("template_id", templateId);
        params.put("ext_json", extJson);
        params.put("user_version", userVersion);
        params.put("user_desc", userDesc);
        params.put("test_account", testAccount);
        params.put("test_password", testPassword);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PACKAGE_UPLOAD, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public PackageResp submitAudit(String accessToken, String content, Long packageId, String remark,
                                   String testAccount, String testPassword)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("content", content);
        params.put("package_id", packageId);
        params.put("remark", remark);
        params.put("test_account", testAccount);
        params.put("test_password", testPassword);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PACKAGE_SUBMIT_AUDIT, params);

        SmartAppResult<PackageResp> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PackageResp>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public TpPkgSubmitAuditQuota submitAuditQuota(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        String response = SmartAppHttpUtil.sendHttpGet(TP_PACKAGE_AUDIT_QUOTA, params);

        SmartAppResult<TpPkgSubmitAuditQuota> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TpPkgSubmitAuditQuota>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void withdrawAudit(String accessToken, String packageId) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("package_id", packageId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PACKAGE_WITHDRAW, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void release(String accessToken, Long packageId) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("package_id", packageId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PACKAGE_RELEASE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void rollback(String accessToken, Long packageId) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("package_id", packageId);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PACKAGE_ROLLBACK, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public List<PackageResp> getPackagesByAppId(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PACKAGE_GET, params);

        SmartAppResult<List<PackageResp>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<PackageResp>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public PackageResp getPackageDetail(String accessToken, Long packageId, Integer type) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("package_id", packageId);
        params.put("type", type);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PACKAGE_GET_DETAIL, params);

        SmartAppResult<PackageResp> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PackageResp>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
