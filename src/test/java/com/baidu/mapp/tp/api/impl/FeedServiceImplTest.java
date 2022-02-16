package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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

import com.baidu.mapp.common.SmartAppPageB;
import com.baidu.mapp.tp.bean.feed.AccessResource;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class FeedServiceImplTest {

    @InjectMocks
    FeedServiceImpl feedServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAccessResourceSubmit() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": \"ok\"\n"
                + "}";
        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        String string = new String("ok");

        String result = feedServiceImpl
                .accessResourceSubmit("accessToken", "title", "body", "path", "images", 1L,
                        1L, "feedType", "feedSubType", "tags", "ext");
        Assert.assertNotNull(result);
        Assert.assertEquals(string, result);
    }

    @Test
    public void testAccessResourceQuery() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"page\": 1,\n"
                + "        \"pageSize\": 5,\n"
                + "        \"count\": 9,\n"
                + "        \"list\": [\n"
                + "            {\n"
                + "                \"rid\": \"11902716467688469563\",\n"
                + "                \"app_id\": 17182748,\n"
                + "                \"title\": \"1009-内容-问答-1009\",\n"
                + "                \"create_time\": \"1569244816\",\n"
                + "                \"status\": \"审核中\",\n"
                + "                \"audit_time\": \"1569244816\",\n"
                + "                \"source\": \"Api提交\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"rid\": \"10521637653310175733\",\n"
                + "                \"app_id\": 17182748,\n"
                + "                \"title\": \"1007-内容-本地生活图文-1007\",\n"
                + "                \"create_time\": \"1569244764\",\n"
                + "                \"status\": \"审核中\",\n"
                + "                \"audit_time\": \"1569244764\",\n"
                + "                \"source\": \"Api提交\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        AccessResource accessResource = new AccessResource();
        accessResource.setRid("11902716467688469563");
        accessResource.setAppId(17182748L);
        accessResource.setTitle("1009-内容-问答-1009");
        accessResource.setCreateTime("1569244816");
        accessResource.setStatus("审核中");
        accessResource.setAuditTime("1569244816");
        accessResource.setSource("Api提交");

        AccessResource accessResource1 = new AccessResource();
        accessResource1.setRid("10521637653310175733");
        accessResource1.setAppId(17182748L);
        accessResource1.setTitle("1007-内容-本地生活图文-1007");
        accessResource1.setCreateTime("1569244764");
        accessResource1.setStatus("审核中");
        accessResource1.setAuditTime("1569244764");
        accessResource1.setSource("Api提交");

        List<AccessResource> accessResources = new ArrayList<>();
        accessResources.add(accessResource);
        accessResources.add(accessResource1);

        SmartAppPageB<AccessResource> accessResourceSmartAppPageB = new SmartAppPageB<>();
        accessResourceSmartAppPageB.setPage(1L);
        accessResourceSmartAppPageB.setPageSize(5);
        accessResourceSmartAppPageB.setCount(9L);
        accessResourceSmartAppPageB.setList(accessResources);

        SmartAppPageB<AccessResource> result = feedServiceImpl
                .accessResourceQuery("accessToken", "title", 0, 1L,
                        1L, 0, 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(accessResourceSmartAppPageB, result);
    }

    @Test
    public void testDeleteResource() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Object result = feedServiceImpl.deleteResource("accessToken", 0L, "path");

        Assert.assertNull(result);
    }

    @Test
    public void testSubmitSitemap() throws Exception {
        String response = "{\n"
                + "\t\"errno\": 0,\n"
                + "\t\"msg\": \"success\"\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Boolean result = feedServiceImpl
                .submitSitemap("accessToken", 0L, "desc", 0L, 0L, "url");

        Assert.assertNull(result);
    }

    @Test
    public void testDeleteSitemap() throws Exception {
        String response = "{\n"
                + "\t\"errno\": 0,\n"
                + "\t\"msg\": \"success\"\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Object result = feedServiceImpl.deleteSitemap("accessToken", anyLong(), anyString());

        Assert.assertNull(result);
    }
}
