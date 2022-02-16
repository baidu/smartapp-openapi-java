package com.baidu.mapp.tp.api;

import java.util.List;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.tp.bean.pkg.PackageResp;
import com.baidu.mapp.tp.bean.pkg.TpPkgSubmitAuditQuota;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 小程序包管理接口
 * @author: chenhaonan02
 * @create: 2021-10-26 15:03
 **/
public interface PackageManagementService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "PackageManagementService";
    /**
     * 授权小程序上传包
     * https://smartprogram.baidu.com/docs/third/package/upload/
     */
    String TP_PACKAGE_UPLOAD = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/upload";
    /**
     * 授权小程序提交审核
     * https://smartprogram.baidu.com/docs/third/package/submitaudit/
     */
    String TP_PACKAGE_SUBMIT_AUDIT = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/submitaudit";
    /**
     * 获取授权小程序送审额度
     * https://smartprogram.baidu.com/docs/third/package/auditquota/
     */
    String TP_PACKAGE_AUDIT_QUOTA = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/auditquota";
    /**
     * 授权小程序撤销审核
     * https://smartprogram.baidu.com/docs/third/package/withdraw/
     */
    String TP_PACKAGE_WITHDRAW = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/withdraw";
    /**
     * 授权小程序发布
     * https://smartprogram.baidu.com/docs/third/package/release/
     */
    String TP_PACKAGE_RELEASE = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/release";
    /**
     * 授权小程序回滚包
     * https://smartprogram.baidu.com/docs/third/package/rollback/
     */
    String TP_PACKAGE_ROLLBACK = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/rollback";
    /**
     * 获取小程序包列表
     * https://smartprogram.baidu.com/docs/third/package/get/
     */
    String TP_PACKAGE_GET = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/get";
    /**
     * 获取授权小程序包详情
     * https://smartprogram.baidu.com/docs/third/package/getdetail/
     */
    String TP_PACKAGE_GET_DETAIL = SmartAppConstants.OPEN_API_SMART_APP_URL + "package/getdetail";

    /**
     * 授权小程序上传包
     *
     * @param accessToken  授权小程序的接口调用凭据
     * @param templateId   代码库中的代码模板 id ，可以在第三方平台-模板管理-模板库 查看到模板 id
     * @param extJson      第三方自定义的配置
     * @param userVersion  代码版本号，开发者可自定义。
     * @param userDesc     代码描述，开发者可自定义。
     * @param testAccount  设置直接送审( ext_json 中的 directCommit 字段为 true 时)，可以向审核人员提供的测试帐号。
     * @param testPassword 测试帐号对应的密码。
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void upload(String accessToken, Long templateId, String extJson, String userVersion, String userDesc,
                String testAccount, String testPassword) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 授权小程序提交审核
     *
     * @param accessToken  授权小程序的接口调用凭据
     * @param content      送审描述
     * @param packageId    包 Id ，获取方式请参考[获取小程序包列表](https://smartprogram.baidu.com/docs/third/package/get/)
     * @param remark       备注
     * @param testAccount  可以向审核人员提供的测试帐号
     * @param testPassword 测试帐号对应的密码
     *
     * @return PackageResp
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PackageResp submitAudit(String accessToken, String content, Long packageId, String remark, String testAccount,
                            String testPassword) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取授权小程序送审额度
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return TpPkgSubmitAuditQuota
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TpPkgSubmitAuditQuota submitAuditQuota(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 授权小程序撤销审核
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void withdrawAudit(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 授权小程序发布
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param packageId   包 Id
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void release(String accessToken, Long packageId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 授权小程序发布
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param packageId   包 Id
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void rollback(String accessToken, Long packageId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取小程序包列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return List<PackageResp>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<PackageResp> getPackagesByAppId(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取授权小程序包详情
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param packageId   代码包 Id
     * @param type        小程序状态，不指定 package_id 的情况下默认是线上版本
     *                    1 线上版本
     *                    3 开发中
     *                    4 审核中
     *                    5 审核失败
     *                    6 审核通过
     *                    8 回滚中
     *
     * @return PackageResp
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PackageResp getPackageDetail(String accessToken, Long packageId, Integer type) throws SmartAppErrorException,
            OpenAPIErrorException;
}
