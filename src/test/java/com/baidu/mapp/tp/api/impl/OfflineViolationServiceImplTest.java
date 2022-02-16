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

import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.tp.bean.violation.ProblemDetail;
import com.baidu.mapp.tp.bean.violation.ViolationAppDetails;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class OfflineViolationServiceImplTest {

    @InjectMocks
    OfflineViolationServiceImpl offlineViolationServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateForOffline() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "    \t\"examine_id\":123\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Examine examine = new Examine();
        examine.setExamineId(123L);

        Examine result = offlineViolationServiceImpl.updateForOffline("accessToken", "appName", "appDesc", "photoAddr",
                "appNameMaterial");
        Assert.assertNotNull(result);
        Assert.assertEquals(examine, result);
    }

    @Test
    public void testGetViolationAppInfo() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\",\n"
                + "  \"data\": {\n"
                + "    \"appId\": 1482676776,\n"
                + "    \"problemDetails\": [\n"
                + "      {\n"
                + "        \"taskId\": 8,\n"
                + "        \"status\": 0,\n"
                + "        \"problemDesc\": \"页面流量关闭-代码包-一般违规。\",\n"
                + "        \"problemPath\": \"https://0wshu7.smartapps.cn/pages/102610224?a=1322\",\n"
                + "        \"screenShot\": \"[\\\"https://b.bdstatic.com/batserver/192.168.1.233:5555-1602829093953"
                + ".png\\\"]\",\n"
                + "        \"auditReason\": \"\",\n"
                + "        \"auditShot\": \"[]\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        List<ProblemDetail> problemDetails = new ArrayList<>();
        ProblemDetail problemDetail = new ProblemDetail();
        problemDetail.setTaskId(8L);
        problemDetail.setStatus((byte) 0);
        problemDetail.setProblemDesc("页面流量关闭-代码包-一般违规。");
        problemDetail.setProblemPath("https://0wshu7.smartapps.cn/pages/102610224?a=1322");
        problemDetail.setScreenShot("[\"https://b.bdstatic.com/batserver/192.168.1.233:5555-1602829093953.png\"]");
        problemDetail.setAuditReason("");
        problemDetail.setAuditShot("[]");
        problemDetails.add(problemDetail);

        ViolationAppDetails violationAppDetails = new ViolationAppDetails();
        violationAppDetails.setAppId(1482676776L);
        violationAppDetails.setProblemDetails(problemDetails);

        ViolationAppDetails result = offlineViolationServiceImpl.getViolationAppInfo("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(violationAppDetails, result);
    }
}