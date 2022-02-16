package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.developer.bean.templatemessage.GetTemplateLibraryByIdResult;
import com.baidu.mapp.developer.bean.templatemessage.GetTemplateLibraryListResult;
import com.baidu.mapp.developer.bean.templatemessage.GetTemplateListResult;
import com.baidu.mapp.developer.bean.templatemessage.MsgKey;
import com.baidu.mapp.developer.bean.templatemessage.TemplateID;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public interface TemplateMessageService {
    /**
     * 获取小程序模板库标题列表
     * https://smartprogram.baidu.com/docs/develop/serverapi/getTemplateLibraryList/
     */
    String GET_TEMPLATE_LIBRARY_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/librarylist";

    /**
     * 获取模板库某个模板标题下的关键词库
     */
    String GET_TEMPLATE_LIBARAY_ID = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/libraryget";

    /**
     * https://smartprogram.baidu.com/docs/develop/serverapi/addTemplate/
     * 组合模板并添加至帐号下的个人模板库。
     */
    String ADD_TEMPLATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/templateadd";

    /**
     * 获取帐号下已存在的模板列表。
     * https://smartprogram.baidu.com/docs/develop/serverapi/getTemplateList/
     */
    String GET_TEMPLAET_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/templatelist";

    /**
     * 删除帐号下的某个模板。
     * https://smartprogram.baidu.com/docs/develop/serverapi/deleteTemplate/
     */
    String DELETE_TEMPALTE = SmartAppConstants.OPEN_API_SMART_APP_URL + "template/templatedel";

    /**
     * 推送模板消息
     * https://smartprogram.baidu.com/docs/develop/serverapi/sendTemplateMessage/
     */
    String SEND_TEMPLATE_MESSAGE =  SmartAppConstants.OPEN_API_SMART_APP_URL + "template/send";

    /**
     * 订阅消息发送
     * https://smartprogram.baidu.com/docs/develop/serverapi/subscribe_msg_send/
     *
     * */
    String SUBSCRIBE_TEMPLATE_MESSAGE =  SmartAppConstants.OPEN_API_SMART_APP_URL  +
            "template/message/subscribe/send";

    /**
     * 发送客服消息
     * https://smartprogram.baidu.com/docs/develop/serverapi/contact_api_send/
     */
    String SEND_CUSTOM_MESSAGE = SmartAppConstants.OPEN_API_SMART_APP_URL  + "message/custom/send";

    /**
     *
     * @param accessToken
     * @param offset 用于分页，表示从 offset 开始，默认值为 0
     * @param count 用于分页，表示拉取 count 条记录，默认值为 0 ，最大为 20
     * @return
     */
    GetTemplateLibraryListResult getTemplateLibraryList(String accessToken, int offset, int count)
            throws SmartAppErrorException, OpenAPIErrorException;


    /**
     * 获取模板库某个模板标题下的关键词库。
     * @param accessToken
     * @param id 模板标题 id ，可通过接口获取，也可登录小程序后台查看获取
     * @return
     * @throws SmartAppErrorException
     */
    GetTemplateLibraryByIdResult getTemplateLibraryById(String accessToken, String id)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 组合模板并添加至帐号下的个人模板库。
     * @param accessToken
     * @param id 模板标题 id
     * @param keywordIdList 模板关键词 id 列表，如[1,2,3]
     * @return 添加至帐号下的模板 id ，发送小程序模板消息时所需
     * @throws SmartAppErrorException
     */
    TemplateID addTemplate(String accessToken, String id, String keywordIdList )
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取帐号下已存在的模板列表
     * @param accessToken
     * @param offset 用于分页，表示从 offset 开始，默认值为 0
     * @param count 用于分页，表示拉取 count 条记录，默认值为 0 ，最大为 20
     * @return
     * @throws SmartAppErrorException
     */
    GetTemplateListResult getTemplateList(String accessToken, int offset, int count)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 删除帐号下的某个模板。
     * @param accessToken
     * @param templateId  模板 id ，发送小程序模板消息时所需
     * @return
     */
    boolean deleteTemplate (String accessToken, String templateId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     *推送模板消息
     * @param accessToken
     * @param templateId 小程序模板 ID
     * @param touserOpenId 接收者 open_id 参数不能为空。open_id 为百度用户登录唯一标识，可以通过 SessionKey 获得
     * @param data 发送消息内容
     * @param page 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数，（示例 index?foo=bar），该字段不填默认跳转至首页
     * @param sceneId 场景 id ，例如 formId、orderId、payId。formId 为页面内 form 组件的report-submit属性为 true 时返回 formId
     *                ，详见 form 表单
     * @param sceneType 场景 type 。1：表单；2：百度收银台订单；3：直连订单
     * @throws SmartAppErrorException
     */
    MsgKey sendTemplateMessage(String accessToken, String templateId,
                               String touserOpenId, String data, String page, String sceneId, int sceneType)
            throws SmartAppErrorException, OpenAPIErrorException;


    /**
     *订阅消息发送
     * @param accessToken
     * @param templateId 所需下发的模板消息的id
     * @param touserOpenId 接收者open_id
     * @param subscribeId 订阅 Id ，发送订阅类模板消息时所使用的唯一标识符，开发者自定义的subscribe-id 字段。
     *                    注意：同一用户在同一个订阅id 下的多次授权不累积下发权限，只能下发一条。若要订阅多条，需要不同订阅 id
     * @param data 消息内容
     * @param page 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数，示例index?foo=bar，该字段不填默认跳转至首页
     * @return
     * @throws SmartAppErrorException
     */
    MsgKey subscribeSend(String accessToken, String templateId, String touserOpenId,
                         String subscribeId, String data, String page)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 发送客服消息
     * @param accessToken
     * @param userType 1:游客登录 2:百度账号登录
     * @param openId 用户的 OpenID
     * @param msgType 消息类型 text:文本格式 image:图片链接
     * @param content  文本消息内容，msg_type ="text" 时必填
     * @param picUrl 图片消息，msg_type ="image" 时必填
     * @return
     * @throws SmartAppErrorException
     */
    boolean customSend(String accessToken, int userType, String openId,
                       String msgType, String content, String picUrl )
            throws SmartAppErrorException, OpenAPIErrorException;
}
