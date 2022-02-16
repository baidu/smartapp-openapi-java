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

import com.baidu.mapp.tp.bean.template.AddToTemplate;
import com.baidu.mapp.tp.bean.template.Template;
import com.baidu.mapp.tp.bean.template.TemplateDraft;
import com.baidu.mapp.tp.bean.template.TemplateDraftList;
import com.baidu.mapp.tp.bean.template.TemplateList;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class TemplateManagementServiceImplTest {

    @InjectMocks
    TemplateManagementServiceImpl templateManagementServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTemplateDraftList() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\",\n"
                + "  \"data\": {\n"
                + "    \"count\": 53,\n"
                + "    \"list\": [\n"
                + "      {\n"
                + "        \"user_version\": \"2.2.2.2\",\n"
                + "        \"user_desc\": \"\",\n"
                + "        \"draft_id\": 7,\n"
                + "        \"web_status\":true\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        TemplateDraft templateDraft = new TemplateDraft();
        templateDraft.setUserVersion("2.2.2.2");
        templateDraft.setUserDesc("");
        templateDraft.setDraftId(7L);
        templateDraft.setWebStatus(true);
        List<TemplateDraft> list = new ArrayList<>();
        list.add(templateDraft);

        TemplateDraftList templateDraftList = new TemplateDraftList();
        templateDraftList.setCount(53);
        templateDraftList.setList(list);

        TemplateDraftList result = templateManagementServiceImpl.getTemplateDraftList("accessToken", 0,
                0);
        Assert.assertNotNull(result);
        Assert.assertEquals(templateDraftList, result);
    }

    @Test
    public void testGetTemplateList() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\",\n"
                + "  \"data\": {\n"
                + "    \"count\": 53,\n"
                + "    \"list\": [\n"
                + "      {\n"
                + "        \"user_version\": \"2.2.2.2\",\n"
                + "        \"user_desc\": \"\",\n"
                + "        \"template_id\": 7,\n"
                + "        \"web_status\":true\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        Template template = new Template();
        template.setUserVersion("2.2.2.2");
        template.setUserDesc("");
        template.setTemplateId(7L);
        template.setWebStatus(true);
        List<Template> list = new ArrayList<>();
        list.add(template);

        TemplateList templateList = new TemplateList();
        templateList.setCount(53);
        templateList.setList(list);

        TemplateList result = templateManagementServiceImpl.getTemplateList("accessToken", 0, 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(templateList, result);
    }

    @Test
    public void testAddToTemplate() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\",\n"
                + "  \"data\": {\n"
                + "     \"template_id\": 1\n"
                + "  }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        AddToTemplate addToTemplate = new AddToTemplate();
        addToTemplate.setTemplateId(1L);

        AddToTemplate result = templateManagementServiceImpl.addToTemplate("accessToken", 1L, "userDesc");
        Assert.assertNotNull(result);
        Assert.assertEquals(addToTemplate, result);
    }

    @Test
    public void testDelTemplate() throws Exception {
        String response = "{\n"
                + "  \"errno\": 0,\n"
                + "  \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        templateManagementServiceImpl.delTemplate("accessToken", 1L);
    }
}