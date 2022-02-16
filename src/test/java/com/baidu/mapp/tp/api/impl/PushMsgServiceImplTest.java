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

import com.baidu.mapp.common.SmartAppPageB;
import com.baidu.mapp.tp.bean.pushmsg.PushMsg;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class PushMsgServiceImplTest {

    @InjectMocks
    PushMsgServiceImpl pushMsgServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMsg() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"page\": 0,\n"
                + "        \"pageSize\": 100,\n"
                + "        \"count\": 1,\n"
                + "        \"list\": [\n"
                + "            {\n"
                + "                \"id\": 99081,\n"
                + "                \"content\": "
                + "\"TGdViNDF+T3uZSUfRg+B3tw3jPZ+So"
                + "/m7rLQH4RsdzPYiX4CyXQh7NgIwcwkVZMP2X7KqDiKTlznBjatDSIeelxSZ9wQMBLKlY1j+9oPVOIw8gzOVQatj30DjBF9T"
                + "/mjRonrM37bf395A9pExxptpbk0Q5KdwXmDJ7H"
                + "/YSDZfARDUAWS1G1OvfjzTc8whABPmiq2CxYCo91SL4Y4Fn42yeRcycBem6U4/JC9tddqAmaZlssig/gb"
                + "/v38NTzdYdVbmzRYrokXnvmJMQOVTauPMzknk53PH0K/OsSRZ5chBy5sA2mAr"
                + "/Dg7bzzsbjDjMq6N4SEwtJWkJ0kCxNzmhRWfY7Ohn9qPHo6sx3aYF6ogck250ZkiURNcyqD4wDSP1ur\",\n"
                + "                \"status\": 1\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PushMsg pushMsg = new PushMsg();
        pushMsg.setId(99081L);
        pushMsg.setContent(
                "TGdViNDF+T3uZSUfRg+B3tw3jPZ+So/m7rLQH4RsdzPYiX4CyXQh7NgIwcwkVZMP2X7KqDiKTlznBjatDSIeelxSZ9wQMBLKlY1j"
                        + "+9oPVOIw8gzOVQatj30DjBF9T/mjRonrM37bf395A9pExxptpbk0Q5KdwXmDJ7H"
                        + "/YSDZfARDUAWS1G1OvfjzTc8whABPmiq2CxYCo91SL4Y4Fn42yeRcycBem6U4/JC9tddqAmaZlssig/gb"
                        + "/v38NTzdYdVbmzRYrokXnvmJMQOVTauPMzknk53PH0K/OsSRZ5chBy5sA2mAr"
                        + "/Dg7bzzsbjDjMq6N4SEwtJWkJ0kCxNzmhRWfY7Ohn9qPHo6sx3aYF6ogck250ZkiURNcyqD4wDSP1ur");
        pushMsg.setStatus((byte) 1);
        List<PushMsg> list = new ArrayList<>();
        list.add(pushMsg);

        SmartAppPageB<PushMsg> pushMsgSmartAppPageB = new SmartAppPageB<>();
        pushMsgSmartAppPageB.setPage(0L);
        pushMsgSmartAppPageB.setPageSize(100);
        pushMsgSmartAppPageB.setCount(1L);
        pushMsgSmartAppPageB.setList(list);

        SmartAppPageB<PushMsg> result = pushMsgServiceImpl.getMsg("accessToken", 1L, 1L, Byte.valueOf("00110"),
                0, 0, "idList");
        Assert.assertNotNull(result);
        Assert.assertEquals(pushMsgSmartAppPageB, result);
    }
}