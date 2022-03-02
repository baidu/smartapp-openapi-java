package com.baidu.mapp.tp.api;

import java.util.List;

import com.baidu.mapp.tp.bean.domain.Domains;
import com.baidu.mapp.common.enums.ActionEnum;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 设置第三方域名接口
 * @author: chenhaonan02
 * @create: 2021-11-15 10:27
 **/
public interface ThirdPartyDomainService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "ThirdPartyDomainService";
    /**
     * 设置第三方平台服务器域名
     * https://smartprogram.baidu.com/docs/third/domain/set_server/
     */
    String TP_MODIFY_DOMAIN = SmartAppConstants.OPEN_API_SMART_APP_URL + "tp/modifydomain";
    /**
     * 设置第三方平台业务域名
     * https://smartprogram.baidu.com/docs/third/domain/set_biz/
     */
    String TP_MODIFY_WEB_VIEW_DOMAIN = SmartAppConstants.OPEN_API_SMART_APP_URL + "tp/modifywebviewdomain";
    /**
     * 下载域名检验文件
     * https://smartprogram.baidu.com/docs/third/domain/download/
     */
    String TP_DOWNLOAD_DOMAINCER = SmartAppConstants.OPEN_API_SMART_APP_URL + "tp/download/domaincer";

    /**
     * 设置第三方平台服务器域名
     *
     * @param tpAccessToken  第三方平台的接口调用凭据
     * @param action         @See Also：ActionEnum
     *                       add添加, delete删除, set覆盖,
     *                       get获取。当参数是get时不需要填四个域名字段，如果没有action字段参数，则默认将开放平台第三方登记的小程序业务域名全部添加到授权的小程序中。
     * @param requestDomain  request合法域名，多个时用,分割，当action参数是get时不需要此字段。
     * @param uploadDomain   upload合法域名，多个时用,分割，当action参数是get时不需要此字段。
     * @param downloadDomain download合法域名，多个时用,分割，当action参数是get时不需要此字段
     * @param socketDomain   socket合法域名，多个时用,分割，当action参数是get时不需要此字段。
     *
     * @return Domains
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Domains modifyDomain(String tpAccessToken, ActionEnum action, String requestDomain, String uploadDomain,
                         String downloadDomain, String socketDomain)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 设置第三方平台业务域名
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param action        @See Also：ActionEnum
     *                      add添加, delete删除, set覆盖,
     *                      get获取。当参数是get时不需要填四个域名字段，如果没有action字段参数，则默认将开放平台第三方登记的小程序业务域名全部添加到授权的小程序中。
     * @param webViewDomain 小程序业务域名，多个时用,分割，当action参数是get时不需要此字段
     *
     * @return List<String>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<String> modifyWebViewDomain(String tpAccessToken, ActionEnum action, String webViewDomain)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 下载域名检验文件
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void publish(String tpAccessToken) throws SmartAppErrorException, OpenAPIErrorException;
}
