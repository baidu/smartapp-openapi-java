package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.baidu.mapp.tp.bean.search.AppNameChecked;
import com.baidu.mapp.tp.bean.search.QueryKeywordClient;
import com.baidu.mapp.tp.bean.search.SitemapTrafficData;
import com.baidu.mapp.tp.bean.search.SubChainInfo;
import com.baidu.mapp.tp.bean.search.TopQueryInfo;
import com.baidu.mapp.tp.bean.search.UrlMapping;
import com.baidu.mapp.tp.bean.search.UrlMappingOverview;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class NaturalSearchServiceImplTest {

    @InjectMocks
    NaturalSearchServiceImpl naturalSearchServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testModifyWebStatus() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        AppNameChecked result = naturalSearchServiceImpl.modifyWebStatus("accessToken", 0);
        Assert.assertNull(result);
    }

    @Test
    public void testUploadRobotsForApp() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": \"https://searchbox.bj.bcebos"
                + ".com/v1/searchbox/mappconsole/image/20191017/0e51f553-3631-4c45-9cc6-09c4496282d6.txt\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        String string = "https://searchbox.bj.bcebos.com/v1/searchbox/mappconsole/image/20191017/0e51f553-3631-4c45"
                + "-9cc6-09c4496282d6.txt";

        File file = new File("file.txt");
        String result = naturalSearchServiceImpl.uploadRobotsForApp("accessToken", file);
        Assert.assertNotNull(result);
        Assert.assertEquals(string, result);
    }

    @Test
    public void testUploadRobotsForTemplate() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": \"https://searchbox.bj.bcebos"
                + ".com/v1/searchbox/mappconsole/image/20191017/0e51f553-3631-4c45-9cc6-09c4496282d6.txt\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        String string = "https://searchbox.bj.bcebos.com/v1/searchbox/mappconsole/image/20191017/0e51f553-3631-4c45"
                + "-9cc6-09c4496282d6.txt";

        String result = naturalSearchServiceImpl.uploadRobotsForTemplate("accessToken", anyLong(), any());
        Assert.assertNotNull(result);
        Assert.assertEquals(string, result);
    }

    @Test
    public void testSubmitSitemapByApi() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        naturalSearchServiceImpl.submitSitemapByApi("accessToken", 0, Arrays.<String>asList("String"));
    }

    @Test
    public void testBindSite() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl.bindSite("accessToken", Arrays.<String>asList("String"));
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testGetBindSite() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": \n"
                + "    [\n"
                + "      \"www.baidu.com\"\n"
                + "    ]\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        List<String> bindSites = new ArrayList<>();
        bindSites.add("www.baidu.com");

        List<String> result = naturalSearchServiceImpl
                .getBindSite("accessToken", 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(bindSites, result);
    }

    @Test
    public void testSaveUrlMapping() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl.saveUrlMapping("accessToken", "content", Byte.valueOf("00110"));
        Assert.assertNotNull(result);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testQueryUrlMapping() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\":\n"
                + "    {\n"
                + "      \"totalAdapterNum\":1,\n"
                + "      \"ruleTotalNum\":10,\n"
                + "      \"ruleRemainingNum\":1,\n"
                + "      \"ruleDetailList\":[\n"
                + "        {\n"
                + "          \"ruleId\":1,\n"
                + "          \"h5Rule\":\"http://h5.com/xx\",\n"
                + "          \"appRule\":\"/path/xx\",\n"
                + "          \"submitTime\":\"2021-4-05\",\n"
                + "          \"status\":1,\n"
                + "          \"msg\":\"部分生效\",\n"
                + "          \"createMethod\":1 \n"
                + "        }\n"
                + "      ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        List<UrlMappingOverview.RuleDetail> ruleDetailList = new ArrayList<>();
        UrlMappingOverview.RuleDetail ruleDetail = new UrlMappingOverview().new RuleDetail();
        ruleDetail.setRuleId(1L);
        ruleDetail.setH5Rule("http://h5.com/xx");
        ruleDetail.setAppRule("/path/xx");
        ruleDetail.setSubmitTime("2021-4-05");
        ruleDetail.setStatus(1);
        ruleDetail.setMsg("部分生效");
        ruleDetail.setCreateMethod((byte) 1);
        ruleDetailList.add(ruleDetail);

        UrlMappingOverview urlMappingOverview = new UrlMappingOverview();
        urlMappingOverview.setTotalAdapterNum(1);
        urlMappingOverview.setRuleTotalNum(10);
        urlMappingOverview.setRuleRemainingNum(1);
        urlMappingOverview.setRuleDetailList(ruleDetailList);

        UrlMappingOverview result = naturalSearchServiceImpl
                .queryUrlMapping("accessToken", 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(urlMappingOverview, result);
    }

    @Test
    public void testGetUrlMappingDetail() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\":\n"
                + "    [\n"
                + "      {\n"
                + "        \"ruleId\":1,\n"
                + "        \"h5Pattern\":\"http://h5.com/xx\",\n"
                + "        \"appPattern\":\"/path/xx\",\n"
                + "        \"isFetch\":true,\n"
                + "        \"matchNum\":10,\n"
                + "        \"adapterNum\":1,\n"
                + "        \"coverNum\":1,\n"
                + "        \"urlRate\":20,\n"
                + "        \"adapterStatus\":1\n"
                + "      }\n"
                + "    ]\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setRuleId(1L);
        urlMapping.setH5Pattern("http://h5.com/xx");
        urlMapping.setAppPattern("/path/xx");
        urlMapping.setIsFetch(true);
        urlMapping.setAdapterNum(1);
        urlMapping.setMatchNum(10);
        urlMapping.setCoverNum(1L);
        urlMapping.setUrlRate(20L);
        urlMapping.setAdapterStatus((byte) 1);
        List<UrlMapping> urlMappings = new ArrayList<>();
        urlMappings.add(urlMapping);

        List<UrlMapping> result = naturalSearchServiceImpl.getUrlMappingDetail("accessToken", 1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(urlMappings, result);
    }

    @Test
    public void testDelUrlMapping() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl.delUrlMapping("accessToken", "delRuleId");
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testGetSitemapMeta() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"total_click_count\":100,\n"
                + "        \"total_display_count\":100,\n"
                + "        \"click_display_ratio\":\"100.00%\",\n"
                + "        \"traffic_data\":[\n"
                + "            {\n"
                + "                \"date\":\"2020-01-01\",\n"
                + "                \"click_count\":100,\n"
                + "                \"display_count\":100,\n"
                + "                \"click_view_ratio\":\"100.00%\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        List<SitemapTrafficData.TrafficData> trafficDataList = new ArrayList<>();
        SitemapTrafficData.TrafficData trafficData = new SitemapTrafficData.TrafficData();
        trafficData.setDate("2020-01-01");
        trafficData.setClickCount(100);
        trafficData.setDisplayCount(100);
        trafficData.setClickViewRatio("100.00%");
        trafficDataList.add(trafficData);

        SitemapTrafficData sitemapTrafficData = new SitemapTrafficData();
        sitemapTrafficData.setTotalClickCount(100);
        sitemapTrafficData.setTotalDisplayCount(100);
        sitemapTrafficData.setClickDisplayRatio("100.00%");
        sitemapTrafficData.setTrafficData(trafficDataList);

        SitemapTrafficData result = naturalSearchServiceImpl.getSitemapMeta("appAccessToken", 7);
        Assert.assertNotNull(result);
        //        Assert.assertEquals(sitemapTrafficData, result);
    }

    @Test
    public void testGetTopQueryUrlInfo() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "        \"msg\":\"success\",\n"
                + "        \"data\":{\n"
                + "            \"total_click_count\":15,\n"
                + "            \"total_display_count\":20,\n"
                + "            \"rate\":\"75.00%\",\n"
                + "            \"detail\":[\n"
                + "                {\n"
                + "                    \"path\":\"/path/one\",\n"
                + "                    \"web_url\":\"https://baidu.com/path/one\",\n"
                + "                    \"click_count\":5,\n"
                + "                    \"display_count\":10,\n"
                + "                    \"rate\":\"50.00%\"\n"
                + "                }\n"
                + "            ],\n"
                + "            \"total_num\":1\n"
                + "        }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        TopQueryInfo.TopQueryDetail topQueryDetail = new TopQueryInfo.TopQueryDetail();
        topQueryDetail.setPath("/path/one");
        topQueryDetail.setWebUrl("https://baidu.com/path/one");
        topQueryDetail.setClickCount(5);
        topQueryDetail.setDisplayCount(10);
        topQueryDetail.setRate("50.00%");
        List<TopQueryInfo.TopQueryDetail> topQueryDetails = new ArrayList<>();
        topQueryDetails.add(topQueryDetail);

        TopQueryInfo topQueryInfo = new TopQueryInfo();
        topQueryInfo.setTotalClickCount(15);
        topQueryInfo.setTotalDisplayCount(20);
        topQueryInfo.setRate("75.00%");
        topQueryInfo.setDetail(topQueryDetails);
        topQueryInfo.setTotalNum(1);

        TopQueryInfo result = naturalSearchServiceImpl.getTopQueryUrlInfo("appAccessToken", 7, 1, 10);
        Assert.assertNotNull(result);
        //        Assert.assertEquals(topQueryInfo, result);
    }

    @Test
    public void testGetQueryKeyword() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"detail\":[\n"
                + "            {\n"
                + "                \"query\":\"word one\",\n"
                + "                \"click_count\":5,\n"
                + "                \"display_count\":10,\n"
                + "                \"rate\":\"50.00%\"\n"
                + "            }\n"
                + "        ],\n"
                + "        \"total_num\":1\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        QueryKeywordClient.KeyWordDetail keyWordDetail = new QueryKeywordClient.KeyWordDetail();
        keyWordDetail.setQuery("word one");
        keyWordDetail.setClickCount(5);
        keyWordDetail.setDisplayCount(10);
        keyWordDetail.setRate("50.00%");
        List<QueryKeywordClient.KeyWordDetail> keyWordDetails = new ArrayList<>();
        keyWordDetails.add(keyWordDetail);

        QueryKeywordClient queryKeywordClient = new QueryKeywordClient();
        queryKeywordClient.setTotalNum(1);
        queryKeywordClient.setDetail(keyWordDetails);

        QueryKeywordClient result = naturalSearchServiceImpl
                .getQueryKeyword("appAccessToken", "webUrl", 7, 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(queryKeywordClient, result);
    }

    @Test
    public void testAddSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"errMsg\":\"success\",\n"
                + "    \"data\":5831\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Long expectedResult = 5831L;
        Long result = naturalSearchServiceImpl
                .addSubChain("accessToken", "chainName", "chainDesc", "chainPath", "telephone");
        Assert.assertNotNull(result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testDeleteSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"errMsg\":\"success\",\n"
                + "    \"data\":true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl.deleteSubChain("accessToken", 1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testUpdateSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"errMsg\":\"success\",\n"
                + "    \"data\":true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl
                .updateSubChain("accessToken", 1L, "chainName", "chainDesc",
                        "chainPath", "telephone");
        Assert.assertNotNull(result);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testGetAllSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"app_level\":1,\n"
                + "        \"sub_chain_prior_number\":3,\n"
                + "        \"sub_chain_info_list\":[\n"
                + "            {\n"
                + "                \"id\":249,\n"
                + "                \"app_id\":1482656741,\n"
                + "                \"app_name\":\"小程序B\",\n"
                + "                \"customer_id\":197,\n"
                + "                \"customer_name\":\"先锋德高(北京)信息技术有限公司\",\n"
                + "                \"chain_name\":\"haifei2\",\n"
                + "                \"chain_desc\":\"desc desc2\",\n"
                + "                \"chain_path\":\"/path/2\",\n"
                + "                \"path_md5\":\"1e7e9b06cda51fc95a933c727d6a9772\",\n"
                + "                \"status\":1,\n"
                + "                \"chain_rank\":1,\n"
                + "                \"create_time\":1566219603,\n"
                + "                \"update_time\":1566224567,\n"
                + "                \"audit_time\":0,\n"
                + "                \"audit_desc\":\"\",\n"
                + "                \"subchain_type\":1,\n"
                + "                \"showStatus\":1\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        SubChainInfo.SubChainInfoList subChainInfoList1 = new SubChainInfo.SubChainInfoList();
        subChainInfoList1.setId(249L);
        subChainInfoList1.setAppId(1482656741L);
        subChainInfoList1.setAppName("小程序B");
        subChainInfoList1.setCustomerId(197L);
        subChainInfoList1.setCustomerName("先锋德高(北京)信息技术有限公司");
        subChainInfoList1.setChainName("haifei2");
        subChainInfoList1.setChainDesc("desc desc2");
        subChainInfoList1.setChainPath("/path/2");
        subChainInfoList1.setPathMd5("1e7e9b06cda51fc95a933c727d6a9772");
        subChainInfoList1.setStatus((byte) 1);
        subChainInfoList1.setChainRank((byte) 1);
        subChainInfoList1.setCreateTime(1566219603L);
        subChainInfoList1.setUpdateTime(1566224567L);
        subChainInfoList1.setAuditTime(0L);
        subChainInfoList1.setAuditDesc("");
        subChainInfoList1.setSubchainType((byte) 1);
        subChainInfoList1.setShowStatus(1);
        List<SubChainInfo.SubChainInfoList> subChainInfoList = new ArrayList<>();
        subChainInfoList.add(subChainInfoList1);

        SubChainInfo subChainInfo = new SubChainInfo();
        subChainInfo.setAppLevel(1);
        subChainInfo.setSubChainPriorNumber(3);
        subChainInfo.setSubChainInfoList(subChainInfoList);

        SubChainInfo result = naturalSearchServiceImpl.getAllSubChain("appAccessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(subChainInfo, result);
    }

    @Test
    public void testRankSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"errMsg\":\"success\",\n"
                + "    \"data\":true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl.rankSubChain("accessToken", Arrays.<Long>asList(Long.valueOf(1)));
        Assert.assertNotNull(result);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testStopSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"errMsg\":\"success\",\n"
                + "    \"data\":true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = naturalSearchServiceImpl.stopSubChain("accessToken", 1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testStartSubChain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"errMsg\":\"success\",\n"
                + "    \"data\":true\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);
        Boolean result = naturalSearchServiceImpl.startSubChain("accessToken", 1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(Boolean.TRUE, result);
    }
}
