package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baidu.mapp.tp.bean.auth.AppInfo;
import com.baidu.mapp.tp.bean.auth.AppInfoModifyCount;
import com.baidu.mapp.tp.bean.auth.AuthorizationCode;
import com.baidu.mapp.tp.bean.auth.Category;
import com.baidu.mapp.tp.bean.auth.OAuthToken;
import com.baidu.mapp.tp.bean.auth.PreAuthCode;
import com.baidu.mapp.tp.bean.auth.Qualification;
import com.baidu.mapp.tp.bean.auth.TpAccessToken;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class AuthorizationProcessServiceImplTest {

    @InjectMocks
    AuthorizationProcessServiceImpl authorizationProcessServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToken() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\" :{\n"
                + "        \"access_token\": \"42.12835b16c449ae00f7d9a61570516b4f.2592000.1535536744"
                + ".aPk4Eh420Yt-2JdTBB_F-34gJWz93WxN4e9rQhN\",\n"
                + "        \"expires_in\": 2592000,\n"
                + "        \"scope\": \"smartapp_tp_smtapp_common public\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        TpAccessToken tpAccessToken = new TpAccessToken();
        tpAccessToken.setAccessToken(
                "42.12835b16c449ae00f7d9a61570516b4f.2592000.1535536744.aPk4Eh420Yt-2JdTBB_F-34gJWz93WxN4e9rQhN");
        tpAccessToken.setExpiresIn(2592000);
        tpAccessToken.setScope("smartapp_tp_smtapp_common public");

        TpAccessToken result = authorizationProcessServiceImpl.token("clientId", "ticket");
        Assert.assertNotNull(result);
        Assert.assertEquals(tpAccessToken, result);
    }

    @Test
    public void testCreatePreAuthCode() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"pre_auth_code\": \"c210YXBwMjAzMTQxODMzMThiMDlhMzhlZmEzMGM2MjAzY2NjMGQ5MTBlNGNmZWI1\",\n"
                + "        \"expires_in\": 1200\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PreAuthCode preAuthCode = new PreAuthCode();
        preAuthCode.setPreAuthCode("c210YXBwMjAzMTQxODMzMThiMDlhMzhlZmEzMGM2MjAzY2NjMGQ5MTBlNGNmZWI1");
        preAuthCode.setExpiresIn(1200);

        PreAuthCode result = authorizationProcessServiceImpl.createPreAuthCode("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(preAuthCode, result);
    }

    @Test
    public void testGetOAuthToken() throws Exception {
        String response = "{\n"
                + "    \"access_token\": \"45.1d4146fdea08ab043a2d291b0e2d86ca.3600.1536147748"
                + ".C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je\",\n"
                + "    \"refresh_token\": \"46.4d79bd6882af6d2bb238b2f851f3a00f.315360000.1851504148"
                + ".C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je\",\n"
                + "    \"expires_in\": 3600\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        OAuthToken oAuthToken = new OAuthToken();
        oAuthToken.setAccessToken(
                "45.1d4146fdea08ab043a2d291b0e2d86ca.3600.1536147748.C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je");
        oAuthToken.setRefreshToken(
                "46.4d79bd6882af6d2bb238b2f851f3a00f.315360000.1851504148"
                        + ".C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je");
        oAuthToken.setExpiresIn(3600);

        OAuthToken result = authorizationProcessServiceImpl.getOAuthToken("accessToken", "code", "grantType");
        Assert.assertNotNull(result);
        Assert.assertEquals(oAuthToken, result);
    }

    @Test
    public void testRefreshOAuthToken() throws Exception {
        String response = "{\n"
                + "    \"access_token\": \"45.1d4146fdea08ab043a2d291b0e2d86ca.3600.1536147748"
                + ".C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je\",\n"
                + "    \"refresh_token\": \"46.4d79bd6882af6d2bb238b2f851f3a00f.315360000.1851504148"
                + ".C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je\",\n"
                + "    \"expires_in\": 3600\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        OAuthToken oAuthToken = new OAuthToken();
        oAuthToken.setAccessToken(
                "45.1d4146fdea08ab043a2d291b0e2d86ca.3600.1536147748.C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je");
        oAuthToken.setRefreshToken(
                "46.4d79bd6882af6d2bb238b2f851f3a00f.315360000.1851504148"
                        + ".C1Q38_EEfQjeNhZ1diO5d7hX8Dx_-mVMFst84kTtF6Sn4je");
        oAuthToken.setExpiresIn(3600);

        OAuthToken result = authorizationProcessServiceImpl.refreshOAuthToken("accessToken", "refreshToken",
                "grantType");
        Assert.assertNotNull(result);
        Assert.assertEquals(oAuthToken, result);
    }

    @Test
    public void testInfo() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"app_id\":111111,\n"
                + "        \"app_name\":\"小程序\",\n"
                + "        \"app_key\":\"1eQayZtM6Vg5C9E3vAgg2IOYjugXqNj2\",\n"
                + "        \"app_desc\":\"1531812276\",\n"
                + "        \"photo_addr\": \"[{\\\"cover\\\": \\\"https://b.bdstatic"
                + ".com/searchbox/mappconsole/image/20180416/1523870283-34303.jpg\\\"}]\",\n"
                + "        \"qualification\":{\n"
                + "            \"name\":\"\",\n"
                + "            \"type\":1,\n"
                + "            \"status\":1,\n"
                + "            \"ad_type\":1,\n"
                + "            \"ad_status\":1\n"
                + "        },\n"
                + "        \"modify_count\":{\n"
                + "            \"name_modify_used\":4,\n"
                + "            \"name_modify_quota\":5,\n"
                + "            \"signature_modify_used\":0,\n"
                + "            \"signature_modify_quota\":5,\n"
                + "            \"image_modify_used\":0,\n"
                + "            \"image_modify_quota\":5,\n"
                + "            \"category_modify_used\":0,\n"
                + "            \"category_modify_quota\":3\n"
                + "        },\n"
                + "        \"category\":[\n"
                + "            {\n"
                + "                \"category_id\":1,\n"
                + "                \"category_name\":\"电商\",\n"
                + "                \"category_desc\":\"电商\",\n"
                + "                \"reason\":\"失败原因\",\n"
                + "                \"audit_status\":1,\n"
                + "                \"parent\":{\n"
                + "                    \"category_id\":2,\n"
                + "                    \"category_name\":\"电商\",\n"
                + "                    \"category_desc\":\"电商\"\n"
                + "                }\n"
                + "            }\n"
                + "        ],\n"
                + "        \"audit_info\":{\n"
                + "            \"audit_app_name_status\":1,\n"
                + "            \"audit_app_name\":\"测试中名称\",\n"
                + "            \"audit_app_name_reason\":\"名称审核审核失败原因\",\n"
                + "            \"audit_app_desc_status\":3,\n"
                + "            \"audit_app_desc\":\"测试中描述\",\n"
                + "            \"audit_app_desc_reason\":\"审核审核失败原因\",\n"
                + "            \"audit_photo_addr_status\":1,\n"
                + "            \"audit_photo_addr\":\"xxx\",\n"
                + "            \"audit_photo_addr_reason\":\"头像审核失败原因\"\n"
                + "        },\n"
                + "        \"auth_info\":[\n"
                + "            {\n"
                + "                \"scope_name\":\"数据权限\",\n"
                + "                \"type\":0\n"
                + "            },\n"
                + "            {\n"
                + "                \"scope_name\":\"账号管理权限\",\n"
                + "                \"type\":0\n"
                + "            },\n"
                + "            {\n"
                + "                \"scope_name\":\"推广权限\",\n"
                + "                \"type\":0\n"
                + "            }\n"
                + "        ],\n"
                + "        \"annual_review_info\": {\n"
                + "            \"annual_review_status\": 2,\n"
                + "            \"annual_review_overdue_time\": 1542688104\n"
                + "        },\n"
                + "        \"app_offline_info\": [\n"
                + "            {\n"
                + "                \"offline_reason\": 1,\n"
                + "                \"illegal_fields\": \"appName\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"offline_reason\": 2\n"
                + "            }\n"
                + "        ],\n"
                + "        \"min_swan_version\":\"1.6.17\",\n"
                + "        \"status\":1,\n"
                + "        \"web_status\":1\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        Qualification qualification = new Qualification();
        qualification.setName("");
        qualification.setType(1);
        qualification.setStatus(1);
        qualification.setAdType(1);
        qualification.setAdStatus(1);

        AppInfoModifyCount appInfoModifyCount = new AppInfoModifyCount();
        appInfoModifyCount.setNameModifyUsed(4);
        appInfoModifyCount.setNameModifyQuota(5);
        appInfoModifyCount.setSignatureModifyUsed(0);
        appInfoModifyCount.setSignatureModifyQuota(5);
        appInfoModifyCount.setImageModifyUsed(0);
        appInfoModifyCount.setImageModifyQuota(5);
        appInfoModifyCount.setCategoryModifyUsed(0);
        appInfoModifyCount.setCategoryModifyQuota(3);

        List<Category> categories = new ArrayList<>();
        Category categoryParent = new Category();
        categoryParent.setCategoryId(2L);
        categoryParent.setCategoryName("电商");
        categoryParent.setCategoryDesc("电商");
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("电商");
        category.setCategoryDesc("电商");
        category.setReason("失败原因");
        category.setAuditStatus(1);
        category.setParent(categoryParent);
        categories.add(category);

        AppInfo.AuditInfo auditInfo = new AppInfo.AuditInfo();
        auditInfo.setAuditAppNameStatus(1);
        auditInfo.setAuditAppName("测试中名称");
        auditInfo.setAuditAppNameReason("名称审核审核失败原因");
        auditInfo.setAuditAppDescStatus(3);
        auditInfo.setAuditAppDesc("测试中描述");
        auditInfo.setAuditAppDescReason("审核审核失败原因");
        auditInfo.setAuditPhotoAddrStatus(1);
        auditInfo.setAuditPhotoAddr("xxx");
        auditInfo.setAuditPhotoAddrReason("头像审核失败原因");

        List<AppInfo.AuthInfo> authInfos = new ArrayList<>();
        AppInfo.AuthInfo authInfo1 = new AppInfo.AuthInfo();
        authInfo1.setScopeName("数据权限");
        authInfo1.setType(0);
        AppInfo.AuthInfo authInfo2 = new AppInfo.AuthInfo();
        authInfo2.setScopeName("账号管理权限");
        authInfo2.setType(0);
        AppInfo.AuthInfo authInfo3 = new AppInfo.AuthInfo();
        authInfo3.setScopeName("推广权限");
        authInfo3.setType(0);
        authInfos.add(authInfo1);
        authInfos.add(authInfo2);
        authInfos.add(authInfo3);

        AppInfo.AnnualReviewInfo annualReviewInfo = new AppInfo.AnnualReviewInfo();
        annualReviewInfo.setAnnualReviewStatus(2);
        annualReviewInfo.setAnnualReviewOverdueTime(1542688104L);

        List<AppInfo.AppOfflineInfo> appOfflineInfos = new ArrayList<>();
        AppInfo.AppOfflineInfo appOfflineInfo1 = new AppInfo.AppOfflineInfo();
        appOfflineInfo1.setOfflineReason((byte) 1);
        appOfflineInfo1.setIllegalFields("appName");
        AppInfo.AppOfflineInfo appOfflineInfo2 = new AppInfo.AppOfflineInfo();
        appOfflineInfo2.setOfflineReason((byte) 2);
        appOfflineInfos.add(appOfflineInfo1);
        appOfflineInfos.add(appOfflineInfo2);

        AppInfo appInfo = new AppInfo();
        appInfo.setAppId(111111L);
        appInfo.setAppName("小程序");
        appInfo.setAppKey("1eQayZtM6Vg5C9E3vAgg2IOYjugXqNj2");
        appInfo.setAppDesc("1531812276");
        appInfo.setPhotoAddr("[{\"cover\": \"https://b.bdstatic"
                + ".com/searchbox/mappconsole/image/20180416/1523870283-34303.jpg\"}]");
        appInfo.setQualification(qualification);
        appInfo.setModifyCount(appInfoModifyCount);
        appInfo.setCategory(categories);
        appInfo.setAuditInfo(auditInfo);
        appInfo.setAuthInfo(authInfos);
        appInfo.setAnnualReviewInfo(annualReviewInfo);
        appInfo.setAppOfflineInfo(appOfflineInfos);
        appInfo.setMinSwanVersion("1.6.17");
        appInfo.setStatus(1);
        appInfo.setWebStatus(1);

        AppInfo result = authorizationProcessServiceImpl.info("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(appInfo, result);
    }

    @Test
    public void testRetrieveAuthorizationCode() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"authorization_code\": \"f5a09b58eb2dc01c728182d097808145\",\n"
                + "        \"expires_in\": 18000\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        AuthorizationCode authorizationCode = new AuthorizationCode();
        authorizationCode.setAuthorizationCode("f5a09b58eb2dc01c728182d097808145");
        authorizationCode.setExpiresIn(18000);

        AuthorizationCode result = authorizationProcessServiceImpl
                .retrieveAuthorizationCode("accessToken", 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(authorizationCode, result);
    }
}