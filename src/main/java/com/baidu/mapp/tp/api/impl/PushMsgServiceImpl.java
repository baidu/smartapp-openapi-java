package com.baidu.mapp.tp.api.impl;

import java.util.Map;

import com.baidu.mapp.tp.api.PushMsgService;
import com.baidu.mapp.common.SmartAppPageB;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.tp.bean.pushmsg.PushMsg;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

public class PushMsgServiceImpl extends BaseService implements PushMsgService {

    private static PushMsgService pushMsgService;

    public static PushMsgService getInstance() {
        if (pushMsgService == null) {
            pushMsgService =
                    ProxyUtil.proxy(new PushMsgServiceImpl(), TimeIntervalAspect.class);
        }
        return pushMsgService;
    }

    @Override
    public SmartAppPageB<PushMsg> getMsg(String accessToken, Long start, Long end, Byte pushType, Integer offset,
                                         Integer count, String idList)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("start", start);
        params.put("end", end);
        params.put("push_type", pushType);
        params.put("offset", offset);
        params.put("count", count);
        if (StrUtil.isNotEmpty(idList)) {
            params.put("id_list", idList);
        }
        String response = SmartAppHttpUtil.sendHttpGet(GET_MSG, params);

        SmartAppResult<SmartAppPageB<PushMsg>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<SmartAppPageB<PushMsg>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
