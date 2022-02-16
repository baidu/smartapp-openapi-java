package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baidu.mapp.tp.bean.app.AppNameChecked;
import com.baidu.mapp.tp.bean.app.AppSupportVersion;
import com.baidu.mapp.tp.bean.app.CategoryItem;

import com.baidu.mapp.tp.bean.app.Domain;
import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class AppServiceImplTest {

    @InjectMocks
    AppServiceImpl appServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetNickName() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"examine_id\": 39079\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Examine examine = new Examine();
        examine.setExamineId(39079L);

        Examine result = appServiceImpl.setNickName("accessToken", "nickName", "material");
        Assert.assertNotNull(result);
        Assert.assertEquals(examine, result);
    }

    @Test
    public void testCheckNameWithQual() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"checkResult\": 0\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        AppNameChecked appNameChecked = new AppNameChecked();
        appNameChecked.setCheckResult((byte) 0);

        AppNameChecked result = appServiceImpl.checkNameWithQual("accessToken", "appName", "materials");
        Assert.assertNotNull(result);
        Assert.assertEquals(appNameChecked, result);
    }

    @Test
    public void testModifyIcon() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"examine_id\": 39079\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Examine examine = new Examine();
        examine.setExamineId(39079L);

        Examine result = appServiceImpl.modifyIcon("accessToken", "imageUrl");
        Assert.assertNotNull(result);
        Assert.assertEquals(examine, result);
    }

    @Test
    public void testModifySignature() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"examine_id\": 39079\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Examine examine = new Examine();
        examine.setExamineId(39079L);

        Examine result = appServiceImpl.modifySignature("accessToken", "signature");
        Assert.assertNotNull(result);
        Assert.assertEquals(examine, result);
    }

    @Test
    public void testCategoryUpdate() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"examine_id\": 39079\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Examine examine = new Examine();
        examine.setExamineId(39079L);

        Examine result = appServiceImpl.categoryUpdate("accessToken", "categories");
        Assert.assertNotNull(result);
        Assert.assertEquals(examine, result);
    }

    @Test
    public void testCategoryList() throws Exception {
        String response = "{\n"
                + "\t\"errno\": 0,\n"
                + "\t\"msg\": \"success\",\n"
                + "\t\"data\": [{\n"
                + "\t\t\"id\": 1,\n"
                + "\t\t\"category_name\": \"快递业与邮政\",\n"
                + "\t\t\"category_type\": 2,\n"
                + "\t\t\"sub_items\": {\n"
                + "\t\t\t\"2\": {\n"
                + "\t\t\t\t\"id\": 2,\n"
                + "\t\t\t\t\"category_name\": \"快递\",\n"
                + "\t\t\t\t\"category_type\": 2,\n"
                + "\t\t\t\t\"need_quali\": 1,\n"
                + "\t\t\t\t\"category_quali\": {\n"
                + "\t\t\t\t\t\"desc\": \"经营快递业务的企业需提交《快递业务经营许可证》 ；快递企业末端网点需提供所在地邮政管理部门备案证明\",\n"
                + "\t\t\t\t\t\"list\": [\n"
                + "\t\t\t\t\t\t[{\n"
                + "\t\t\t\t\t\t\t\"id\": 1,\n"
                + "\t\t\t\t\t\t\t\"must\": 1,\n"
                + "\t\t\t\t\t\t\t\"name\": \"快递业务经营许可证\",\n"
                + "\t\t\t\t\t\t\t\"desc\": \"快递业务经营许可证\"\n"
                + "\t\t\t\t\t\t}],\n"
                + "\t\t\t\t\t\t[{\n"
                + "\t\t\t\t\t\t\t\"id\": 2,\n"
                + "\t\t\t\t\t\t\t\"must\": 1,\n"
                + "\t\t\t\t\t\t\t\"name\": \"所在地邮政管理部门备案证明\",\n"
                + "\t\t\t\t\t\t\t\"desc\": \"所在地邮政管理部门备案证明\"\n"
                + "\t\t\t\t\t\t}]\n"
                + "\t\t\t\t\t]\n"
                + "\t\t\t\t}\n"
                + "\t\t\t},\n"
                + "\t\t\t\"3\": {\n"
                + "\t\t\t\t\"id\": 3,\n"
                + "\t\t\t\t\"category_name\": \"邮政\",\n"
                + "\t\t\t\t\"category_type\": 2,\n"
                + "\t\t\t\t\"need_quali\": 0,\n"
                + "\t\t\t\t\"category_quali\": {\n"
                + "\t\t\t\t\t\"desc\": \"经营快递业务的企业需提交《快递业务经营许可证》 ；快递企业末端网点需提供所在地邮政管理部门备案证明\",\n"
                + "\t\t\t\t\t\"list\": [\n"
                + "\t\t\t\t\t\t[{\n"
                + "\t\t\t\t\t\t\t\"id\": 1,\n"
                + "\t\t\t\t\t\t\t\"must\": 1,\n"
                + "\t\t\t\t\t\t\t\"name\": \"快递业务经营许可证\",\n"
                + "\t\t\t\t\t\t\t\"desc\": \"快递业务经营许可证\"\n"
                + "\t\t\t\t\t\t}],\n"
                + "\t\t\t\t\t\t[{\n"
                + "\t\t\t\t\t\t\t\"id\": 2,\n"
                + "\t\t\t\t\t\t\t\"must\": 1,\n"
                + "\t\t\t\t\t\t\t\"name\": \"所在地邮政管理部门备案证明\",\n"
                + "\t\t\t\t\t\t\t\"desc\": \"所在地邮政管理部门备案证明\"\n"
                + "\t\t\t\t\t\t}]\n"
                + "\t\t\t\t\t]\n"
                + "\t\t\t\t}\n"
                + "\t\t\t}\n"
                + "\t\t}\n"
                + "\t}]\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        CategoryItem.CategoryQualiItemVo categoryQualiItemVo1 = new CategoryItem.CategoryQualiItemVo(1L, 1,
                "快递业务经营许可证", "快递业务经营许可证");
        CategoryItem.CategoryQualiItemVo categoryQualiItemVo2 = new CategoryItem.CategoryQualiItemVo(2L, 1,
                "所在地邮政管理部门备案证明", "所在地邮政管理部门备案证明");

        List<List<CategoryItem.CategoryQualiItemVo>> list1 = new ArrayList<>();
        List<CategoryItem.CategoryQualiItemVo> categoryQualiItemVoList1 = new ArrayList<>();
        categoryQualiItemVoList1.add(categoryQualiItemVo1);
        List<CategoryItem.CategoryQualiItemVo> categoryQualiItemVoList2 = new ArrayList<>();
        categoryQualiItemVoList2.add(categoryQualiItemVo2);
        list1.add(categoryQualiItemVoList1);
        list1.add(categoryQualiItemVoList2);

        CategoryItem.CategoryQualiVo categoryQualiVo1 = new CategoryItem.CategoryQualiVo();
        categoryQualiVo1.setDesc("经营快递业务的企业需提交《快递业务经营许可证》 ；快递企业末端网点需提供所在地邮政管理部门备案证明");
        categoryQualiVo1.setList(list1);

        CategoryItem.CategorySubItemVo categorySubItemVo1 = new CategoryItem.CategorySubItemVo();
        categorySubItemVo1.setId(2L);
        categorySubItemVo1.setCategoryName("快递");
        categorySubItemVo1.setCategoryType(2);
        categorySubItemVo1.setNeedQuali(1);
        categorySubItemVo1.setCategoryQuali(categoryQualiVo1);

        CategoryItem.CategoryQualiItemVo categoryQualiItemVo3 = new CategoryItem.CategoryQualiItemVo(1L, 1,
                "快递业务经营许可证", "快递业务经营许可证");
        CategoryItem.CategoryQualiItemVo categoryQualiItemVo4 = new CategoryItem.CategoryQualiItemVo(2L, 1,
                "所在地邮政管理部门备案证明", "所在地邮政管理部门备案证明");

        List<List<CategoryItem.CategoryQualiItemVo>> list2 = new ArrayList<>();
        List<CategoryItem.CategoryQualiItemVo> categoryQualiItemVoList3 = new ArrayList<>();
        categoryQualiItemVoList3.add(categoryQualiItemVo3);
        List<CategoryItem.CategoryQualiItemVo> categoryQualiItemVoList4 = new ArrayList<>();
        categoryQualiItemVoList4.add(categoryQualiItemVo4);
        list2.add(categoryQualiItemVoList3);
        list2.add(categoryQualiItemVoList4);

        CategoryItem.CategoryQualiVo categoryQualiVo2 = new CategoryItem.CategoryQualiVo();
        categoryQualiVo2.setDesc("经营快递业务的企业需提交《快递业务经营许可证》 ；快递企业末端网点需提供所在地邮政管理部门备案证明");
        categoryQualiVo2.setList(list2);

        CategoryItem.CategorySubItemVo categorySubItemVo2 = new CategoryItem.CategorySubItemVo();
        categorySubItemVo2.setId(3L);
        categorySubItemVo2.setCategoryName("邮政");
        categorySubItemVo2.setCategoryType(2);
        categorySubItemVo2.setNeedQuali(0);
        categorySubItemVo2.setCategoryQuali(categoryQualiVo2);

        Map<Long, CategoryItem.CategorySubItemVo> subItems = new HashMap<>();
        subItems.put(2L, categorySubItemVo1);
        subItems.put(3L, categorySubItemVo2);

        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setId(1L);
        categoryItem.setCategoryName("快递业与邮政");
        categoryItem.setCategoryType(2);
        categoryItem.setSubItems(subItems);

        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(categoryItem);

        List<CategoryItem> result = appServiceImpl.categoryList("accessToken", 0);
        Assert.assertNotNull(result);
        Assert.assertEquals(categoryItems, result);
    }

    @Test
    public void testPause() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        appServiceImpl.pause("accessToken");
    }

    @Test
    public void testRestart() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        appServiceImpl.restart("accessToken");
    }

    @Test
    public void testControl() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        appServiceImpl.control("accessToken", Byte.valueOf("00110"));
    }

    @Test
    public void testQrCode() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        appServiceImpl.qrCode("accessToken", "path", 1L, 0);
    }

    @Test
    public void testGetSupportVersion() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"now_version\": \"2.5.15\",\n"
                + "        \"items\": [\n"
                + "            {\n"
                + "                \"version\": \"1.10.15\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"version\": \"1.10.17\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"version\": \"1.10.18\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"version\": \"1.10.20\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"version\": \"1.10.21\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        List<AppSupportVersion.Item> items = new ArrayList<>();
        items.add(new AppSupportVersion.Item("1.10.15"));
        items.add(new AppSupportVersion.Item("1.10.17"));
        items.add(new AppSupportVersion.Item("1.10.18"));
        items.add(new AppSupportVersion.Item("1.10.20"));
        items.add(new AppSupportVersion.Item("1.10.21"));

        AppSupportVersion appSupportVersion = new AppSupportVersion();
        appSupportVersion.setNowVersion("2.5.15");
        appSupportVersion.setItems(items);

        AppSupportVersion result = appServiceImpl.getSupportVersion("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(appSupportVersion, result);
    }

    @Test
    public void testModifyDomain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":\n"
                + "    {\n"
                + "        \"request_domain\":\"https://www.baidu.com,https://www.baidu.com\",\n"
                + "        \"socket_domain\":\"wss://www.baidu.com,wss://www.baidu.com\",\n"
                + "        \"download_domain\":\"wss://www.baidu.com,wss://www.baidu.com\",\n"
                + "        \"upload_domain\":\"wss://www.baidu.com,wss://www.baidu.com\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Domain domain = new Domain();
        domain.setRequestDomain("https://www.baidu.com,https://www.baidu.com");
        domain.setSocketDomain("wss://www.baidu.com,wss://www.baidu.com");
        domain.setDownloadDomain("wss://www.baidu.com,wss://www.baidu.com");
        domain.setUploadDomain("wss://www.baidu.com,wss://www.baidu.com");

        Domain result = appServiceImpl.
                modifyDomain("accessToken", "action", "downloadDomain", "requestDomain", "socketDomain",
                        "uploadDomain");
        Assert.assertNotNull(result);
        Assert.assertEquals(domain, result);
    }

    @Test
    public void testModifyWebViewDomain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":\"https://www.baidu.com,https://www.baidu.com\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        String expectedResult = "https://www.baidu.com,https://www.baidu.com";

        String result = appServiceImpl.modifyWebViewDomain("accessToken", "action", "webViewDomain");
        Assert.assertNotNull(result);
        Assert.assertEquals(expectedResult, result);
    }
}