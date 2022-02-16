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

import com.baidu.mapp.tp.bean.pkg.PackageResp;
import com.baidu.mapp.tp.bean.pkg.TpPkgSubmitAuditQuota;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class PackageManagementServiceImplTest {

    @InjectMocks
    PackageManagementServiceImpl packageManagementServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpload() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        packageManagementServiceImpl.upload("accessToken", 1L, "extJson", "userVersion", "userDesc",
                "testAccount", "testPassword");
    }

    @Test
    public void testSubmitAudit() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        PackageResp result = packageManagementServiceImpl
                .submitAudit("accessToken", "content", 1L, "remark", "testAccount", "testPassword");
        Assert.assertNull(result);
    }

    @Test
    public void testSubmitAuditQuota() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"quota_type\": 2,\n"
                + "        \"quota_times\": 3,\n"
                + "        \"remain_times\": 1\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        TpPkgSubmitAuditQuota tpPkgSubmitAuditQuota = new TpPkgSubmitAuditQuota();
        tpPkgSubmitAuditQuota.setQuotaType(2);
        tpPkgSubmitAuditQuota.setQuotaTimes(3);
        tpPkgSubmitAuditQuota.setRemainTimes(1);

        TpPkgSubmitAuditQuota result = packageManagementServiceImpl.submitAuditQuota("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(tpPkgSubmitAuditQuota, result);
    }

    @Test
    public void testWithdrawAudit() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        packageManagementServiceImpl.withdrawAudit("accessToken");
    }

    @Test
    public void testRelease() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        packageManagementServiceImpl.release("accessToken", 1L);
    }

    @Test
    public void testRollback() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        packageManagementServiceImpl.rollback("accessToken", 1L);
    }

    @Test
    public void testGetPackagesByAppId() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\",\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"version\": \"1.2.6\",\n"
                + "      \"remark\": \"\",\n"
                + "      \"msg\": \"审核通过\",\n"
                + "      \"committer\": \"--\",\n"
                + "      \"status\": 1,\n"
                + "      \"commit_time\": \"2018/09/04 17:13:59\",\n"
                + "      \"version_desc\": \"desc\",\n"
                + "      \"package_id\": 1,\n"
                + "      \"rollback_version\": \"v1.2.5\"\n"
                + "    }\n"
                + "  ]\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PackageResp packageResp = new PackageResp();
        packageResp.setVersion("1.2.6");
        packageResp.setRemark("");
        packageResp.setMsg("审核通过");
        packageResp.setCommitter("--");
        packageResp.setStatus(1);
        packageResp.setCommitTime("2018/09/04 17:13:59");
        packageResp.setVersionDesc("desc");
        packageResp.setPackageId(1L);
        packageResp.setRollbackVersion("v1.2.5");
        List<PackageResp> packageResps = new ArrayList<>();
        packageResps.add(packageResp);

        List<PackageResp> result = packageManagementServiceImpl.getPackagesByAppId("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(packageResps, result);
    }

    @Test
    public void testGetPackageDetail() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\",\n"
                + "  \"data\":  {\n"
                + "        \"version\": \"d0.0.0.2\",\n"
                + "        \"remark\": \"\",\n"
                + "        \"msg\": \"\",\n"
                + "        \"committer\": \"--\",\n"
                + "        \"status\": 4,\n"
                + "        \"commit_time\": \"1970/01/19 02:19:13\",\n"
                + "        \"version_desc\": \"dddd123\",\n"
                + "        \"package_id\": 201\n"
                + "      }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PackageResp packageResp = new PackageResp();
        packageResp.setVersion("d0.0.0.2");
        packageResp.setRemark("");
        packageResp.setMsg("");
        packageResp.setCommitter("--");
        packageResp.setStatus(4);
        packageResp.setCommitTime("1970/01/19 02:19:13");
        packageResp.setVersionDesc("dddd123");
        packageResp.setPackageId(201L);

        PackageResp result = packageManagementServiceImpl.getPackageDetail("accessToken", 1L, 1);
        Assert.assertNotNull(result);
        Assert.assertEquals(packageResp, result);
    }
}