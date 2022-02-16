package com.baidu.mapp.tp.api;

import com.baidu.mapp.tp.bean.subscription.AddMessageTemplate;
import com.baidu.mapp.tp.bean.subscription.LibraryGet;
import com.baidu.mapp.tp.bean.subscription.PushTemplateMessage;
import com.baidu.mapp.tp.bean.subscription.TemplateExistsList;
import com.baidu.mapp.tp.bean.subscription.TemplateTitleList;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 模板消息接口
 * @author: chenhaonan02
 * @create: 2021-11-09 21:08
 **/
public interface TemplateMessageService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "TemplateMessage";
    /**
     * 获取消息模板列表
     * https://smartprogram.baidu.com/docs/third/message_template/template_list/
     */
    String TP_TEMPLATE_LIBRARY_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/library/list";
    /**
     * 获取关键词库
     * https://smartprogram.baidu.com/docs/third/message_template/word_lib/
     */
    String TP_TEMPLATE_LIBRARY_GET = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/library/get";
    /**
     * 获取帐号下已存在的模板列表
     * https://smartprogram.baidu.com/docs/third/message_template/get_template_list/
     */
    String TP_TEMPLATE_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/list";
    /**
     * 添加模板消息
     * https://smartprogram.baidu.com/docs/third/message_template/add_template/
     */
    String TP_TEMPLATE_ADD = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/add";
    /**
     * 删除模板消息
     * https://smartprogram.baidu.com/docs/third/message_template/delete_template/
     */
    String TP_TEMPLATE_DEL = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/del";
    /**
     * 推送模板消息
     * https://smartprogram.baidu.com/docs/third/message_template/template_push/
     */
    String TP_TEMPLATE_SEND_MESSAGE = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/sendmessage";

    /**
     * 获取消息模板列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param offset      用于分页，表示从offset开始，默认值为0
     * @param count       用于分页，表示拉取count条记录，默认值为0,最大为20
     *
     * @return 模板库标题列表
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TemplateTitleList libraryList(String accessToken, Integer offset, Integer count)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 取关键词库
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param id          模板标题id，可通过接口获取，也可登录小程序后台查看获取
     *
     * @return 关键词库
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    LibraryGet libraryGet(String accessToken, String id) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取帐号下已存在的模板列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param offset      用于分页，表示从 offset 开始，默认值为 0
     * @param count       用于分页，表示拉取 count 条记录，默认值为 0 ，最大为 20
     *
     * @return 已存在的模板列表
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TemplateExistsList templateList(String accessToken, Integer offset, Integer count)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 添加模板消息
     *
     * @param accessToken   授权小程序的接口调用凭据
     * @param id            模板标题 Id
     * @param keywordIdList 模板关键词 Id 列表，如[1,2,3]
     *
     * @return 添加消息模板
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AddMessageTemplate templateAdd(String accessToken, Integer id, String keywordIdList)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 删除模板消息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param templateId  模板 Id ，发送小程序模板消息时所需
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void templateDel(String accessToken, String templateId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 推送模板消息
     *
     * @param accessToken  授权小程序的接口调用凭据
     * @param templateId   所需下发的模板消息的 Id
     * @param touser       接收者swan_id
     * @param touserOpenId 接收者open_id
     * @param data         {"keyword1": {"value": "2018-09-06"},"keyword2": {"value": "kfc"}}
     * @param page         点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数，（示例index?foo=bar），该字段不填则模板无跳转。
     * @param sceneId      场景 Id，例如表单 Id 和订单 Id
     * @param sceneType    场景type，1：表单；2：百度收银台订单；3:直连订单
     * @param title        title
     * @param ext          {"xzh_id":111,"category_id":15}
     * @param description  描述
     *
     * @return 推送模板消息
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PushTemplateMessage send(String accessToken, String templateId, String touser, String touserOpenId, String data,
                             String page, String sceneId, Integer sceneType, String title, String ext,
                             String description) throws SmartAppErrorException, OpenAPIErrorException;
}
