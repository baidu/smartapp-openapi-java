package com.baidu.mapp.tp.bean.pkg;

import lombok.Data;

/**
 * @description: PackageResp
 * @author: chenhaonan02
 * @create: 2021-10-26 15:49
 **/
@Data
public class PackageResp {
    /**
     * 提交时间
     */
    private String commitTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 版本描述
     */
    private String versionDesc;
    /**
     * 备注
     */
    private String remark;
    /**
     * 代码包 Id
     */
    private Long packageId;
    /**
     * 审核信息
     */
    private String msg;
    /**
     * 提交人
     */
    private String committer;
    /**
     * 状态
     * 1：线上版本
     * 3：开发版本
     * 4：审核中
     * 5：审核失败
     * 6：审核通过
     * 8：回滚中
     */
    private Integer status;
    /**
     * 上一个线上版本的版本号
     */
    private String rollbackVersion;
    /**
     *
     */
    private String bundleId;
    /**
     * 上传状态
     * 1：上传中
     * 3：上传失败
     */
    private Integer uploadStatus;
    /**
     * 上传状态描述
     */
    private String uploadStatusDesc;
    /**
     * 上传状态为失败时，失败的错误码
     * -1：unknow err
     * 69010：模板文件解析出错
     * 69009：提包服务暂时不可用，请稍后重试
     * 40001：参数错误
     */
    private Integer uploadErrCode;
    /**
     * 上传状态为失败时，失败的原因描述
     */
    private String uploadErrMsg;
    /**
     * 模板 Id
     */
    private Long templateId;
    /**
     * 创建时间
     */
    private Long createTime;
}
