package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class UploadPhotoServiceImplTest {

    @InjectMocks
    UploadPhotoServiceImpl uploadPhotoServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpload() throws Exception {
        String response = "{\n"
                + "\t\"errno\": 0,\n"
                + "\t\"msg\": \"success\",\n"
                + "\t\"data\": \"https://b.bdstatic.com/searchbox/mappconsole/image/20181011/153925724712319.png\"\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        String url = "https://b.bdstatic.com/searchbox/mappconsole/image/20181011/153925724712319.png";
        File file = new File("file");
        Integer type = 1;
        String result = uploadPhotoServiceImpl.upload("accessToken", file, type);
        Assert.assertNotNull(result);
        Assert.assertEquals(url, result);
    }
}