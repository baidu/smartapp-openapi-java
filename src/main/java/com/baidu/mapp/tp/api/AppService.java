package com.baidu.mapp.tp.api;

import java.util.List;

import com.baidu.mapp.tp.bean.app.AppNameChecked;
import com.baidu.mapp.tp.bean.app.AppSupportVersion;
import com.baidu.mapp.tp.bean.app.CategoryItem;
import com.baidu.mapp.tp.bean.app.Domain;
import com.baidu.mapp.tp.bean.app.Examine;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 基本信息接口
 * @author: chenhaonan02
 * @create: 2021-10-28 20:44
 **/
public interface AppService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "AppInformation";
    /**
     * 修改小程序名称
     * https://smartprogram.baidu.com/docs/third/info/modify_app_name_with_qualification/
     */
    String TP_APP_SET_NICK_NAME = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/setnicknamewithqual";
    /**
     * 小程序名称检测
     * https://smartprogram.baidu.com/docs/third/info/app_name_check/
     */
    String TP_APP_CHECK_NICK_NAME = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/checknamewithqual";
    /**
     * 修改小程序头像
     * https://smartprogram.baidu.com/docs/third/info/modify_app_icon/
     */
    String TP_APP_MODIFY_ICON = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/modifyheadimage";
    /**
     * 修改小程序简介
     * https://smartprogram.baidu.com/docs/third/info/modify_app_desc/
     */
    String TP_APP_MODIFY_SIGNATURE = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/modifysignature";
    /**
     * 修改小程序类目
     * https://smartprogram.baidu.com/docs/third/info/modify_app_category/
     */
    String TP_APP_UPDATE_CATEGORY = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/category/update";
    /**
     * 获取小程序全类目列表
     * https://smartprogram.baidu.com/docs/third/info/category_list/
     */
    String TP_APP_CATEGORY_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/category/list";
    /**
     * 服务暂停
     * https://smartprogram.baidu.com/docs/third/info/service_pause/
     */
    String TP_APP_PAUSE = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/pause";
    /**
     * 服务开启
     * https://smartprogram.baidu.com/docs/third/info/service_start/
     */
    String TP_APP_RESUME = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/resume";
    /**
     * 流量下线/开启
     * https://smartprogram.baidu.com/docs/third/info/app_flow_control/
     */
    String TP_APP_FLOW_CONTROL = SmartAppConstants.OPEN_API_SMART_APP_URL + "appflow/control";
    /**
     * 获取二维码TP
     * https://smartprogram.baidu.com/docs/third/info/qrcode/
     */
    String TP_APP_QRCODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/qrcode";
    /**
     * 查询最低基础库版本
     * https://smartprogram.baidu.com/docs/third/info/min_sdk_version/
     */
    String TP_APP_GET_SUPPORT_VERSION = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/getsupportversion";
    /**
     * 设置小程序服务器域名
     * https://smartprogram.baidu.com/docs/third/info/set_server_domain/
     */
    String TP_APP_MODIFY_DOMAIN = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/modifydomain";
    /**
     * 设置小程序业务域名
     * https://smartprogram.baidu.com/docs/third/info/set_biz_domain/
     */
    String TP_APP_MODIFY_WEB_VIEW_DOMAIN = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/modifywebviewdomain";

    /**
     * 修改小程序名称
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param nickName    小程序名字
     * @param material    如果小程序名称包含品牌词，需要上传品牌资质证明。
     *
     * @return 修改小程序信息审核
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Examine setNickName(String accessToken, String nickName, String material)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 小程序名称检测
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param appName     小程序名字
     * @param materials   如果小程序名称包含品牌词，需要上传品牌资质证明。
     *
     * @return AppNameChecked
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AppNameChecked checkNameWithQual(String accessToken, String appName, String materials)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 修改小程序头像
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param imageUrl    小程序icon地址，可以通过图片上传接口获取icon的url。
     *
     * @return 修改小程序信息审核
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Examine modifyIcon(String accessToken, String imageUrl) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 修改小程序简介
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param signature   功能介绍（简介） 简介字数要求 10-56 个字符之间 （一个中文算两个字符）
     *
     * @return 修改小程序信息审核
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Examine modifySignature(String accessToken, String signature) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 修改小程序类目
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param categories  类目类别
     *
     * @return 修改小程序信息审核
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Examine categoryUpdate(String accessToken, String categories) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取小程序全类目列表
     *
     * @param accessToken  授权小程序的接口调用凭据
     * @param categoryType 1.个人类型类目 2.企业类型类目 为2时可以查出全部类目
     *
     * @return CategoryItem
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<CategoryItem> categoryList(String accessToken, Integer categoryType)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 服务暂停
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void pause(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 服务开启
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void resume(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 流量下线/开启
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param type        流量下线开关状态，1：开启流量，2：下线流量
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void control(String accessToken, Byte type) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取二维码TP
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param path        自定义打开路径
     * @param packageId   可指定代码包id(只支持审核、开发、线上版本)，不传默认线上版本
     * @param width       默认 200px ，最大 1280px ，最小 200px
     *
     * @throws SmartAppErrorException 智能小程序异常类
     */
    void qrCode(String accessToken, String path, Long packageId, Integer width)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查询最低基础库版本
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return AppSupportVersion
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AppSupportVersion getSupportVersion(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 设置小程序服务器域名
     *
     * @param accessToken    授权小程序的接口调用凭据
     * @param action         add添加, delete删除, set覆盖,
     *                       get获取。当参数是get时不需要填四个域名字段，如果没有action字段参数，则默认将开放平台第三方登记的小程序业务域名全部添加到授权的小程序中。
     * @param downloadDomain download合法域名，多个时用,分割，当action参数是get时不需要此字段
     * @param requestDomain  request合法域名，多个时用,分割，当action参数是get时不需要此字段。
     * @param socketDomain   socket合法域名，多个时用,分割，当action参数是get时不需要此字段。
     * @param uploadDomain   upload合法域名，多个时用,分割，当action参数是get时不需要此字段。
     *
     * @return Domain
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Domain modifyDomain(String accessToken, String action, String downloadDomain,
                        String requestDomain, String socketDomain, String uploadDomain)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 设置小程序业务域名
     *
     * @param accessToken   授权小程序的接口调用凭据
     * @param action        add 添加, delete 删除, set 覆盖, get 获取。当参数是 get 时不需要填四个域名字段，如果没有 action
     *                      字段参数，则默认将开放平台第三方登记的业务域名全部添加到授权的小程序中。
     * @param webViewDomain 小程序业务域名，多个时用,分割，当 action 参数是 get 时不需要此字段
     *
     * @return String
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    String modifyWebViewDomain(String accessToken, String action, String webViewDomain)
            throws SmartAppErrorException, OpenAPIErrorException;
}
