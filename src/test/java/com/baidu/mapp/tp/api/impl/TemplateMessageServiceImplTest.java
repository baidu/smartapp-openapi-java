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

import com.baidu.mapp.tp.bean.subscription.AddMessageTemplate;
import com.baidu.mapp.tp.bean.subscription.LibraryGet;
import com.baidu.mapp.tp.bean.subscription.LibraryList;
import com.baidu.mapp.tp.bean.subscription.PushTemplateMessage;
import com.baidu.mapp.tp.bean.subscription.TemplateExistsList;
import com.baidu.mapp.tp.bean.subscription.TemplateTitleList;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class TemplateMessageServiceImplTest {

    @InjectMocks
    TemplateMessageServiceImpl templateMessageServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLibraryList() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"total_count\": 2278,\n"
                + "        \"library_list\": [\n"
                + "            {\n"
                + "                \"id\": \"BD0001\",\n"
                + "                \"title\": \"订单支付成功通知\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        List<LibraryList> libraryList = new ArrayList<>();
        LibraryList libraryList1 = new LibraryList();
        libraryList1.setId("BD0001");
        libraryList1.setTitle("订单支付成功通知");
        libraryList.add(libraryList1);

        TemplateTitleList templateTitleList = new TemplateTitleList();
        templateTitleList.setTotalCount(2278);
        templateTitleList.setLibraryList(libraryList);

        TemplateTitleList result = templateMessageServiceImpl.libraryList("accessToken", 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(templateTitleList, result);
    }

    @Test
    public void testLibraryGet() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"id\": \"BD0016\",\n"
                + "        \"title\": \"取票成功通知\",\n"
                + "        \"keyword_count\": 13,\n"
                + "        \"keyword_list\": [\n"
                + "            {\n"
                + "                \"keyword_id\": 1,\n"
                + "                \"name\": \"金额\",\n"
                + "                \"example\": \"300元\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        LibraryGet.KeywordList keywordList1 = new LibraryGet.KeywordList();
        keywordList1.setKeywordId(1);
        keywordList1.setName("金额");
        keywordList1.setExample("300元");
        List<LibraryGet.KeywordList> keywordList = new ArrayList<>();
        keywordList.add(keywordList1);

        LibraryGet libraryGet = new LibraryGet();
        libraryGet.setId("BD0016");
        libraryGet.setTitle("取票成功通知");
        libraryGet.setKeywordCount(13);
        libraryGet.setKeywordList(keywordList);

        LibraryGet result = templateMessageServiceImpl.libraryGet("accessToken", "id");
        Assert.assertNotNull(result);
        Assert.assertEquals(libraryGet, result);
    }

    @Test
    public void testTemplateList() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"total_count\": 2\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        TemplateExistsList templateExistsList = new TemplateExistsList();
        templateExistsList.setTotalCount(2);

        TemplateExistsList result = templateMessageServiceImpl.templateList("accessToken", 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(templateExistsList, result);

    }

    @Test
    public void testTemplateAdd() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"template_id\": \"wDYzYZVxobJivW9oMpSCpuvACOfJXQIoKUm0PY397Tc\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        AddMessageTemplate addMessageTemplate = new AddMessageTemplate();
        addMessageTemplate.setTemplateId("wDYzYZVxobJivW9oMpSCpuvACOfJXQIoKUm0PY397Tc");

        AddMessageTemplate result = templateMessageServiceImpl.templateAdd("accessToken", 0, "keywordIdList");
        Assert.assertNotNull(result);
        Assert.assertEquals(addMessageTemplate, result);
    }

    @Test
    public void testTemplateDel() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        templateMessageServiceImpl.templateDel("accessToken", "templateId");
    }

    @Test
    public void testSend() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"msg_key\": 158\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        PushTemplateMessage pushTemplateMessage = new PushTemplateMessage();
        pushTemplateMessage.setMsgKey(158L);
        PushTemplateMessage result = templateMessageServiceImpl
                .send("accessToken", "templateId", "touser", "touserOpenId", "data", "page",
                        "sceneId", 0, "title", "ext", "description");
        Assert.assertNotNull(result);
        Assert.assertEquals(pushTemplateMessage, result);
    }
}
