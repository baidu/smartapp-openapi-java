package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.CustomerMessageService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 客服消息接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-15 10:07
 **/
public class CustomerMessageServiceImpl extends BaseService implements CustomerMessageService {

    private static CustomerMessageService customerMessageService;

    public static CustomerMessageService getInstance() {
        if (customerMessageService == null) {
            customerMessageService =
                    ProxyUtil.proxy(new CustomerMessageServiceImpl(), TimeIntervalAspect.class);
        }
        return customerMessageService;
    }

    @Override
    public void downLink(String accessToken, Byte userType, String openId, String msgType, String content, String picUr)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("user_type", userType);
        params.put("open_id", openId);
        params.put("msg_type", msgType);
        params.put("content", content);
        params.put("pic_ur", picUr);
        String response = SmartAppHttpUtil.sendHttpPost(TP_MESSAGE_CUSTOMER_SEND_BY_TP, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }
}
