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

import com.baidu.mapp.tp.bean.mobile.MobileAuthStatus;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class MobileServiceImplTest {

    @InjectMocks
    MobileServiceImpl mobileServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testApplyMobileAuth() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        mobileServiceImpl.applyMobileAuth("accessToken", 0, 0, "sceneDesc",
                "sceneDemo");
    }

    @Test
    public void testCancelMobileAuth() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\"\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        mobileServiceImpl.cancelMobileAuth("accessToken");
    }

    @Test
    public void testGetMobileAuthStatus() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"status\":1,\n"
                + "          \"reason\":\"原因\"\n"
                + "    }\n"
                + "}\n"
                + "\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        MobileAuthStatus mobileAuthStatus = new MobileAuthStatus();
        mobileAuthStatus.setStatus(1);
        mobileAuthStatus.setReason("原因");

        MobileAuthStatus result = mobileServiceImpl.getMobileAuthStatus("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(mobileAuthStatus, result);
    }
}
