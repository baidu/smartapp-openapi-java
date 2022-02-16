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

import com.baidu.mapp.tp.bean.login.AppLogin;
import com.baidu.mapp.tp.bean.login.UnionId;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class AppLoginServiceImplTest {

    @InjectMocks
    AppLoginServiceImpl appLoginServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAppLogin() throws Exception {
        String response = "{\n"
                + "\t\"openid\": \"l214zFqNrEuIEnp6m7Y01sw8yj\",\n"
                + "\t\"session_key\": \"981ce8b151c0599acf7ad1a673c6ff5e\"\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        AppLogin appLogin = new AppLogin();
        appLogin.setOpenid("l214zFqNrEuIEnp6m7Y01sw8yj");
        appLogin.setSessionKey("981ce8b151c0599acf7ad1a673c6ff5e");

        AppLogin result = appLoginServiceImpl.appLogin("accessToken", "code", "grantType");
        Assert.assertEquals(appLogin, result);
    }

    @Test
    public void testGetUnionId() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"union_id\":\"Srn8jbRVFTFMRdV2KTJfmSE\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        UnionId unionId = new UnionId();
        unionId.setUnionId("Srn8jbRVFTFMRdV2KTJfmSE");

        UnionId result = appLoginServiceImpl.getUnionId("accessToken", "openId");
        Assert.assertEquals(unionId, result);
    }
}