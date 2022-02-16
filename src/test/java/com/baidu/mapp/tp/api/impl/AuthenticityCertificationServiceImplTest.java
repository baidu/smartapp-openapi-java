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

import com.baidu.mapp.tp.bean.auth.FaceAuthResponse;
import com.baidu.mapp.tp.bean.auth.PaymentCertification;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class AuthenticityCertificationServiceImplTest {

    @InjectMocks
    AuthenticityCertificationServiceImpl authenticityCertificationServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFaceAuthentication() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "        \"qrcode\": \"data:image/png;base64,"
                + "iVBORw0KGgoAAAANSUhEUgAAAf4AAAH+AQMAAABHof5mAAAABlBMVEUAAAD///+l2Z/dAAAAAnRSTlP"
                + "//8i138cAAAAJcEhZcwAACxIAAAsSAdLdfvwAAAQOSURBVHic7ZrNreMwDIQJuACX5NZVUgoIwI01HJLJ7mGBMLfRwS+2qS"
                + "+XefwZxfzLZQIIMANYFsv9sf8ejk/X/Xrf3iG+Tu5Z55N7TgEEGAPgxfNG3cG8fQHuZ6/gF+9wuwC99"
                +
                "+5nQAkgwBwgnyEugnF7SxlvF7fFbchbAAHGAQuXV8hWMdajcuwTKTc0LoAAvwJEcNTztqDsW8XXDhFAgJ8APJ8xqVbajELv0HM9g84FEGAQQMEyqf7XJZYAAowB2soec9d4JNq3uScufQkgwBAAUk51YuTh8P32bEPdW/K9BBBgDrCf7UFnG5Jnifpo8q4XMQGFqAUQYAiwr1fzwqndcsWdg07zIh0NqQACTAFWHr7gkIYhMejcC50la3wpWwAB5gF9lIk4OpB9G51yHtcIIMAYwDjjNN/RS7Zv5R3fllPR5QIIMAWoHWg5rdvgqdjPM0OEtP5AAAG+BVDANcqUlAtKKTPvrlC2AAKMAY5mPlr7zcT+ZMbjwmov22GOAALMAaqz/LuyW6OkK86WcydWAQSYASyLhfss5QjJeg497+D7iziQCyDAGOCMpnJnUZ7AmAF1EdpeXC35CiDAFCAEXNrtmTWk/OjWOBaHJAEEGAKs3JYNZD/Mpj8UqdTquBDPBBBgCOC1w47Mot0p514LG+gNL4AAY4A0ddrcHctzIGcbsPc6/SEBBBgFcFtPqiFblHd6lv07ug0kgABfAxarOHvMe5U/fks55u50hWiXR6MpgABzgMqi6CJzArfyhyKuUm6XsgACfA3wJtEcqnMM6un1be5BVyqAAIOA6DbN8mjwYHr1eEsb0jLHdikLIMDXAC+Ph2KlIdkT6AYZhh9QKGUBBBgBLLx9tiretIsJqNR+Rt+JDGynAAJMAbyFlNvDAm4fRZ2Sz2ABBBgEIG/ecUyWYfQgzjkBBd6f+R8ggABTgFRxUWoHzceOd1hDuAggwBTA6fbEtOPOVPqgA7mhCyc1LO+YgE4BBJgDlAOUSbWgOXJnB0rdHy6AAMOAmqdbAUcw5x4qe6PcP/oDAQT4GvB+DBgUyrfmbggdcWZsAwQQYAwQQ41ZCZh782cV+aJ9Ci9IAAHGAKlTdpHoJ42HhEigix1AyBs7BBBgCrDfflTxRjHKNprPqvE5vQsgwASg1kbB96bR497yaZb33WgiTgABpgArpMm9qdjUc+sAWqI9aQMJIMAMAMU6ZRuWt4fv41XoHRR8WnXyLYAAM4AMSVFvy/HyZ95aS6oRF1ABBPgJwFczJHlwHeQjR54dfPxTygIIMAAIa/Ld6Amncq+LHSiMS3cBBJgDsLxDyhYTOF4noFrOyLZR4wUQYApgsSKfPvhLCcvTm6uVd+O4HkIXQIAhwJdLAAFGAH8ACZnb8hxxvS4AAAAASUVORK5CYII=\",\n"
                + "        \"timeout\": \"1558150057\",\n"
                + "        \"legal_face_status\": 1\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        FaceAuthResponse faceAuthResponse = new FaceAuthResponse();
        faceAuthResponse.setQrcode(
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAf4AAAH+AQMAAABHof5mAAAABlBMVEUAAAD///+l2Z"
                        + "/dAAAAAnRSTlP"
                        +
                        "//8i138cAAAAJcEhZcwAACxIAAAsSAdLdfvwAAAQOSURBVHic7ZrNreMwDIQJuACX5NZVUgoIwI01HJLJ7mGBMLfRwS"
                        + "+2qS+XefwZxfzLZQIIMANYFsv9sf8ejk/X/Xrf3iG+Tu5Z55N7TgEEGAPgxfNG3cG8fQHuZ6/gF+9wuwC99"
                        +
                        "+5nQAkgwBwgnyEugnF7SxlvF7fFbchbAAHGAQuXV8hWMdajcuwTKTc0LoAAvwJEcNTztqDsW8XXDhFAgJ8APJ8xqVbajELv0HM9g84FEGAQQMEyqf7XJZYAAowB2soec9d4JNq3uScufQkgwBAAUk51YuTh8P32bEPdW/K9BBBgDrCf7UFnG5Jnifpo8q4XMQGFqAUQYAiwr1fzwqndcsWdg07zIh0NqQACTAFWHr7gkIYhMejcC50la3wpWwAB5gF9lIk4OpB9G51yHtcIIMAYwDjjNN/RS7Zv5R3fllPR5QIIMAWoHWg5rdvgqdjPM0OEtP5AAAG+BVDANcqUlAtKKTPvrlC2AAKMAY5mPlr7zcT+ZMbjwmov22GOAALMAaqz/LuyW6OkK86WcydWAQSYASyLhfss5QjJeg497+D7iziQCyDAGOCMpnJnUZ7AmAF1EdpeXC35CiDAFCAEXNrtmTWk/OjWOBaHJAEEGAKs3JYNZD/Mpj8UqdTquBDPBBBgCOC1w47Mot0p514LG+gNL4AAY4A0ddrcHctzIGcbsPc6/SEBBBgFcFtPqiFblHd6lv07ug0kgABfAxarOHvMe5U/fks55u50hWiXR6MpgABzgMqi6CJzArfyhyKuUm6XsgACfA3wJtEcqnMM6un1be5BVyqAAIOA6DbN8mjwYHr1eEsb0jLHdikLIMDXAC+Ph2KlIdkT6AYZhh9QKGUBBBgBLLx9tiretIsJqNR+Rt+JDGynAAJMAbyFlNvDAm4fRZ2Sz2ABBBgEIG/ecUyWYfQgzjkBBd6f+R8ggABTgFRxUWoHzceOd1hDuAggwBTA6fbEtOPOVPqgA7mhCyc1LO+YgE4BBJgDlAOUSbWgOXJnB0rdHy6AAMOAmqdbAUcw5x4qe6PcP/oDAQT4GvB+DBgUyrfmbggdcWZsAwQQYAwQQ41ZCZh782cV+aJ9Ci9IAAHGAKlTdpHoJ42HhEigix1AyBs7BBBgCrDfflTxRjHKNprPqvE5vQsgwASg1kbB96bR497yaZb33WgiTgABpgArpMm9qdjUc+sAWqI9aQMJIMAMAMU6ZRuWt4fv41XoHRR8WnXyLYAAM4AMSVFvy/HyZ95aS6oRF1ABBPgJwFczJHlwHeQjR54dfPxTygIIMAAIa/Ld6Amncq+LHSiMS3cBBJgDsLxDyhYTOF4noFrOyLZR4wUQYApgsSKfPvhLCcvTm6uVd+O4HkIXQIAhwJdLAAFGAH8ACZnb8hxxvS4AAAAASUVORK5CYII=");
        faceAuthResponse.setTimeout("1558150057");
        faceAuthResponse.setLegalFaceStatus("1");

        FaceAuthResponse result = authenticityCertificationServiceImpl.faceAuthentication("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(faceAuthResponse, result);
    }

    @Test
    public void testPaymentCertification() throws Exception {
        String response = "{\n"
                + "    \"errno\": 0,\n"
                + "    \"msg\": \"success\",\n"
                + "    \"data\": {\n"
                + "          \"url\": \"https://auth.baidu"
                + ".com/thrones/auth/acctcheck?officialid=OFFICIALID&appkey=APPKEY&token=TOKEN\",\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PaymentCertification paymentCertification = new PaymentCertification();
        paymentCertification.setUrl(
                "https://auth.baidu.com/thrones/auth/acctcheck?officialid=OFFICIALID&appkey=APPKEY&token=TOKEN");

        PaymentCertification result = authenticityCertificationServiceImpl.paymentCertification("accessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(paymentCertification, result);
    }
}
