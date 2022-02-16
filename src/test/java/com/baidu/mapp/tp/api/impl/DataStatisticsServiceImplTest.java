package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baidu.mapp.tp.bean.data.DataContentInfo;
import com.baidu.mapp.tp.bean.data.DataInfo;
import com.baidu.mapp.tp.bean.data.MTJDataStatisticsResult;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class DataStatisticsServiceImplTest {

    @InjectMocks
    DataStatisticsServiceImpl dataStatisticsServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAnalysisUserTrend() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisUserTrend("accessToken", 0, "startDate", "endDate", "gran");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisActivityUser() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisActivityUser("accessToken", 0, "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisRetainedUser() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisRetainedUser("accessToken", "reportType", 0,
                        "startDate", "endDate", "gran");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisVisitAttribute() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisVisitAttribute("accessToken", "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisRegion() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisRegion("accessToken", 0, "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisTerminalInfo() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisTerminalInfo("accessToken", "terminalType", 0,
                        "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisVisitPage() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisVisitPage("accessToken", 0, "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisVisitCharacter() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl.getAnalysisVisitCharacter("accessToken",
                "characterType", 0, "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetAnalysisSourceInfo() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"time_span\":\"2019/04/10 - 2019/04/15\",\n"
                + "        \"offset\":0,\n"
                + "        \"total\":6\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        MTJDataStatisticsResult mtjDataStatisticsResult = new MTJDataStatisticsResult();
        mtjDataStatisticsResult.setTimeSpan("2019/04/10 - 2019/04/15");
        mtjDataStatisticsResult.setOffset(0L);
        mtjDataStatisticsResult.setTotal(6L);

        MTJDataStatisticsResult result = dataStatisticsServiceImpl
                .getAnalysisSourceInfo("accessToken", 0, "startDate", "endDate");
        Assert.assertNotNull(result);
        Assert.assertEquals(mtjDataStatisticsResult, result);
    }

    @Test
    public void testGetData() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\":{\n"
                + "        \"offset\": 0,\n"
                + "        \"total\": 4\n"
                + "    }\n"
                + "}\n"
                + "\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        DataInfo<DataContentInfo> dataContentInfoDataInfo = new DataInfo<>();
        dataContentInfoDataInfo.setOffset(0);
        dataContentInfoDataInfo.setTotal(4);

        DataInfo<DataContentInfo> result = dataStatisticsServiceImpl
                .getData("tpAccessToken", "10810008", "metrics", "20190321", "20190325",
                        0, 20);
        Assert.assertNotNull(result);
        Assert.assertEquals(dataContentInfoDataInfo, result);
    }
}
