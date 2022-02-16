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

import com.baidu.mapp.common.SmartAppPageA;
import com.baidu.mapp.tp.bean.grade.AppGrade;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class AppGradeServiceImplTest {

    @InjectMocks
    private AppGradeServiceImpl appGradeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAppGrade() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"pageNo\":1,\n"
                + "        \"pageSize\":8,\n"
                + "        \"total\":2,\n"
                + "        \"dataList\":[\n"
                + "            {\n"
                + "                \"app_grade\":\"A\",\n"
                + "                \"app_id\":1482644984,\n"
                + "                \"app_key\":\"O4S7pP7HtQZtzA80zyycZYv4tDnSGL3b\"\n"
                + "            },\n"
                + "            {\n"
                + "                \"app_grade\":\"未评级\",\n"
                + "                \"app_id\":1482659467,\n"
                + "                \"app_key\":\"Q8kCURfhS3GkPYNri5Gs6fRCSPRWxAGd\"\n"
                + "            }\n"
                + "        ],\n"
                + "        \"totalPage\":1\n"
                + "    }\n"
                + "}";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        List<AppGrade> appGradeList = new ArrayList<>();
        appGradeList.add(new AppGrade("O4S7pP7HtQZtzA80zyycZYv4tDnSGL3b", 1482644984L, "A"));
        appGradeList.add(new AppGrade("Q8kCURfhS3GkPYNri5Gs6fRCSPRWxAGd", 1482659467L, "未评级"));

        SmartAppPageA<AppGrade> appGradeSmartAppPageA = new SmartAppPageA<>();
        appGradeSmartAppPageA.setPageNo(1);
        appGradeSmartAppPageA.setPageSize(8);
        appGradeSmartAppPageA.setTotal(2);
        appGradeSmartAppPageA.setDataList(appGradeList);

        SmartAppPageA<AppGrade> result = appGradeService.appGrade(anyString(), anyLong());

        Assert.assertNotNull(result);
        Assert.assertEquals(appGradeSmartAppPageA, result);
    }
}
