package com.baidu.mapp.tp.api;

import java.io.File;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 图片上传接口
 * @author: chenhaonan02
 * @create: 2021-11-10 15:00
 **/
public interface UploadPhotoService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "UploadPhotoService";
    /**
     * 图片上传
     * https://smartprogram.baidu.com/docs/third/image/upload/
     */
    String TP_UPLOAD_PHOTO = SmartAppConstants.OPEN_API_SMART_APP_FILE_URL + "upload/image";

    /**
     * 图片上传
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param file          文件
     * @param type          图片用途
     *
     * @return 图片上传
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    String upload(String tpAccessToken, File file, Integer type) throws SmartAppErrorException,
            OpenAPIErrorException;
}
