package com.baidu.mapp.tp.bean.auth;

import java.util.List;

import lombok.Data;

/**
 * @description: 小程序基础信息
 * @author: chenhaonan02
 * @create: 2021-10-25 11:25
 **/
@Data
public class AppInfo {
    private Long appId;
    private String appName;
    private String appKey;
    private String appDesc;
    private String photoAddr;
    private String minSwanVersion;
    /**
     * -1代表封禁，1代表正常，2代表审核中，4代表暂停服务
     */
    private Integer status;
    /**
     * web化开关
     */
    private Integer webStatus;
    /**
     * 小程序类目信息
     */
    private List<Category> category;
    /**
     * 小程序高级认证信息
     */
    private Qualification qualification;
    /**
     * 基本信息修改次数
     */
    private AppInfoModifyCount modifyCount;
    /**
     * 基本信息审核状态
     */
    private AuditInfo auditInfo;
    /**
     * 小程序与当前tp的授权关系
     */
    private List<AuthInfo> authInfo;
    /**
     * 年审信息
     */
    private AnnualReviewInfo annualReviewInfo;
    /**
     * 小程序强制下线信息
     */
    private List<AppOfflineInfo> appOfflineInfo;

    @Data
    public static class AuditInfo {
        private Integer auditAppNameStatus;
        private String auditAppName;
        private String auditAppNameReason;
        private Integer auditAppDescStatus;
        private String auditAppDesc;
        private String auditAppDescReason;
        private Integer auditPhotoAddrStatus;
        private String auditPhotoAddr;
        private String auditPhotoAddrReason;
    }

    @Data
    public static class AuthInfo {
        /**
         * 权限名称
         */
        private String scopeName;
        /**
         * 权限类型
         */
        private Integer type;
    }

    @Data
    public static class AnnualReviewInfo {
        public static final Integer ANNUAL_REVIEW_NORMAL = 1;
        public static final Integer ANNUAL_REVIEW_PENDING = 2;
        public static final Integer ANNUAL_REVIEW_OVERDUE = 3;
        /**
         * 年审状态
         */
        private Integer annualReviewStatus;
        /**
         * 年审过期时间
         */
        private Long annualReviewOverdueTime;
    }

    @Data
    public static class AppOfflineInfo {
        /**
         * 强制下线原因
         */
        private Byte offlineReason;
        /**
         * 基本信息违规字段
         */
        private String illegalFields;
    }

}

