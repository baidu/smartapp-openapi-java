package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.InteractService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.developer.bean.interact.CommentCount;
import com.baidu.mapp.developer.bean.interact.CommentList;
import com.baidu.mapp.developer.bean.interact.LikeCount;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;
import com.baidu.mapp.common.validator.BaiduAssert;

import java.util.Map;

public class InteractServiceImpl extends BaseService implements InteractService {
    private static InteractService interactService;

    public static InteractService getInstance() {
        if (interactService == null) {
            interactService = ProxyUtil.proxy(new InteractServiceImpl(), TimeIntervalAspect.class);
        }
        return interactService;
    }

    @Override
    public CommentCount getCommentCount(String accessToken, String snid, String snidType)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("snid", snid);
        params.put("snid_type", snidType);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(COMMENT_COUNT, params);

        SmartAppResult<CommentCount> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CommentCount>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public LikeCount getLikeCount(String accessToken, String snid, String snidType)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("snid", snid);
        params.put("snid_type", snidType);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(LIKE_COUNT,  params);

        SmartAppResult<LikeCount> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<LikeCount>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public CommentList getCommentList(String accessToken, String snid, String snidType, int strt, int num)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("snid", snid);
        params.put("snid_type", snidType);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(COMMENT_LIST, params);

        System.out.println(response);
        SmartAppResult<CommentList> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CommentList>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
