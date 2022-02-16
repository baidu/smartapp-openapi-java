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

import com.baidu.mapp.tp.bean.domain.Domains;
import com.baidu.mapp.common.enums.ActionEnum;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class ThirdPartyDomainServiceImplTest {

    @InjectMocks
    ThirdPartyDomainServiceImpl thirdPartyDomainServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testModifyDomain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        Domains result = thirdPartyDomainServiceImpl
                .modifyDomain("accessToken", ActionEnum.add, "requestDomain", "uploadDomain",
                        "downloadDomain", "socketDomain");
        Assert.assertNull(result);
    }

    @Test
    public void testModifyWebViewDomain() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":[\n"
                + "\t    \"https://www.baidu.com\",\n"
                + "\t    \"https://www.baidu.com\"\n"
                + "    ]\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("https://www.baidu.com");
        expectedResult.add("https://www.baidu.com");
        List<String> result = thirdPartyDomainServiceImpl
                .modifyWebViewDomain("accessToken", ActionEnum.add, "webViewDomain");
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testPublish() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        thirdPartyDomainServiceImpl.publish("accessToken");
    }
}