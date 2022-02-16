package com.baidu.mapp.tp.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.tp.bean.template.AddToTemplate;
import com.baidu.mapp.tp.bean.template.TemplateDraftList;
import com.baidu.mapp.tp.bean.template.TemplateList;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 模板管理接口
 * @author: chenhaonan02
 * @create: 2021-09-23 14:02
 **/
public interface TemplateManagementService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "TemplateManagementService";
    /**
     * 获取模板草稿列表
     * https://smartprogram.baidu.com/docs/third/template/gettemplatedraftlist/
     */
    String TP_GET_TEMPLATE_DRAFT_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/gettemplatedraftlist";
    /**
     * 获取模板列表
     * https://smartprogram.baidu.com/docs/third/template/gettemplatelist/
     */
    String TP_GET_TEMPLATE_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/gettemplatelist";
    /**
     * 添加草稿至模板
     * https://smartprogram.baidu.com/docs/third/template/addtotemplate/
     */
    String TP_ADD_TO_TEMPLATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/addtotemplate";
    /**
     * 删除模板
     * https://smartprogram.baidu.com/docs/third/template/deltemplate/
     */
    String TP_DELETE_TEMPLATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/deltemplate";

    /**
     * 获取模板草稿列表
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param page          页数
     * @param pageSize      每页数量
     *
     * @return 模板草稿列表
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TemplateDraftList getTemplateDraftList(String tpAccessToken, Integer page, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取模板列表
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param page          页数
     * @param pageSize      每页数量
     *
     * @return 模板列表
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TemplateList getTemplateList(String tpAccessToken, Integer page, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 添加草稿至模板
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param draftId       草稿 Id
     * @param userDesc      自定义模板名称，30字以内
     *
     * @return 模板Id
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AddToTemplate addToTemplate(String tpAccessToken, Long draftId, String userDesc)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 删除模板
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param templateId    模板 Id
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void delTemplate(String tpAccessToken, Long templateId) throws SmartAppErrorException, OpenAPIErrorException;

}
