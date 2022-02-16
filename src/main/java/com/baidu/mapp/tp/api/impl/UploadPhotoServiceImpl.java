package com.baidu.mapp.tp.api.impl;

import java.io.File;
import java.util.Map;

import com.baidu.mapp.tp.api.UploadPhotoService;
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
 * @description: 图片上传接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-10 15:20
 **/
public class UploadPhotoServiceImpl extends BaseService implements UploadPhotoService {

    private static UploadPhotoService uploadPhotoService;

    public static UploadPhotoService getInstance() {
        if (uploadPhotoService == null) {
            uploadPhotoService =
                    ProxyUtil.proxy(new UploadPhotoServiceImpl(), TimeIntervalAspect.class);
        }
        return uploadPhotoService;
    }

    @Override
    public String upload(String accessToken, File file, Integer type)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("multipartFile", file);
        params.put("type", type);
        String response = SmartAppHttpUtil.sendHttpPost(TP_UPLOAD_PHOTO, params);

        SmartAppResult<String> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<String>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
