package com.baidu.mapp.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caiweimin
 * @create 2020/12/2 11:50 上午
 */
public enum PushEventNameEnum {

    AUTHORIZED("新建授权关系", 1, 1),
    UNAUTHORIZED("解除授权关系", 2, 1),
    UPDATE_AUTHORIZED("更新授权关系", 3, 1),
    PACKAGE_AUDIT_PASS("代码包审核成功", 4, 2),
    PACKAGE_AUDIT_FAIL("代码包审核失败", 5, 2),
    APP_NAME_AUDIT_PASS("小程序名称审核成功", 6, 3),
    APP_NAME_AUDIT_FAIL("小程序名称审核失败", 7, 3),
    APP_ICON_AUDIT_PASS("小程序头像审核成功", 8, 3),
    APP_ICON_AUDIT_FAIL("小程序头像审核失败", 9, 3),
    APP_DESC_AUDIT_PASS("小程序描述审核成功", 10, 3),
    APP_DESC_AUDIT_FAIL("小程序描述审核失败", 11, 3),
    APP_CATEGORY_AUDIT_PASS("小程序行业类目审核成功", 12, 3),
    APP_CATEGORY_AUDIT_FAIL("小程序行业类目审核失败", 13, 3),
    ACCOUNT_AND_APP_CREATE_AUDIT_PASS("代创建+代注册审核成功通知", 14, 4),
    ACCOUNT_AND_APP_CREATE_AUDIT_FAIL("代创建+代注册审核失败通知", 15, 4),
    APP_CREATE_FAIL("代注册账户创建成功,小程序创建失败", 16, 4),
    BATCH_TASK_UPLOAD_PACKAGE_FAIL("批量提包失败", 17, 5),
    BATCH_TASK_UPLOAD_SUBMIT_AUDIT_FAIL("提审失败", 18, 5),
    BATCH_TASK_UPLOAD_RELEASE_FAIL("发布失败", 19, 5),
    BATCH_TASK_UPLOAD_RELEASE_SUCCESS("发布成功", 20, 5),
    ADVANCED_AUDIT_CHANGED("高级认证状态变更", 21, 6),
    APP_PAYMENT_CREATE_ACCOUNT_PASS("创建支付账号通过通知", 22, 7),
    APP_PAYMENT_CREATE_ACCOUNT_FAIL("创建支付账号失败通知", 23, 7),
    APP_PAYMENT_CREATE_PAYMENT_PASS("开通支付服务通过通知", 24, 7),
    APP_PAYMENT_CREATE_PAYMENT_FAIL("开发支付服务失败通知", 25, 7),
    APP_PAYMENT_UPDATE_DEVELOP_CONFIG_PASS("配置开发者设置通过通知", 26, 7),
    APP_PAYMENT_UPDATE_DEVELOP_CONFIG_FAIL("配置开发者设置通过失败", 27, 7),
    CREATE_APP_AUTH_CANCEL("代创建授权取消通知", 28, 1),
    APP_FORCE_OFFLINE("小程序强制下线通知", 29, 8),
    APP_SERVER_PAUSE("小程序暂停服务通知", 30, 8),
    APP_SERVER_RESUME("小程序开启服务通知", 31, 8),
    ANNUAL_REVIEW_PENDING("待年审通知", 32, 9),
    ANNUAL_REVIEW_OVERDUE("年审过期通知", 33, 9),
    ANNUAL_REVIEW_PASS("年审通过通知", 34, 9),
    APP_CREATE_SUCCESS_AND_AUTH_FAIL("小程序创建成功授权失败推送", 35, 1),
    REGISTER_AUTH_SUCCESS("代注册授权成功推送", 36, 4),
    AUDIT_SUB_CHAIN_PASS("单卡子链审核通过", 37, 10),
    AUDIT_SUB_CHAIN_FAILED("单卡子链审核失败", 38, 10),
    BASE_INFO_OFFLINE_AUDIT_SUCCESS("基本信息强制下线审核成功", 39, 11),
    BASE_INFO_OFFLINE_AUDIT_FAIL("基本信息强制下线审核失败", 40, 11),
    BRAND_WORD_AUDIT_FAIL("品牌词审核失败", 41, 12),
    BRAND_WORD_AUDIT_SUCCESS("品牌词审核成功", 42, 12),
    BATCH_UPLOAD_SUBMIT_SUCCESS("批量提包提交成功", 43, 5),
    BATCH_UPLOAD_SUBMIT_FAIL("批量提包提交失败", 44, 5),
    TIME_LIMIT_RECTIFY_NOTIFY("限时整改推送", 45, 8),
    FLOW_CLOSE_NOTIFY("流量下线通知推送", 46, 8),
    FLOW_CLOSE_AUDIT_PASS("流量下线提审审核通过结果推送", 47, 13),
    FLOW_CLOSE_AUDIT_FAIL("流量下线提审审核失败结果推送", 48, 13),
    APPLY_APP_MOBILE_AUTH_PASS("申请获取手机号权限审核通过", 49, 14),
    APPLY_APP_MOBILE_AUTH_REJECT("申请获取手机号权限审核拒绝", 50, 14),
    APP_MOBILE_AUTH_CANCEL("获取手机号权限取消", 51, 15),
    APP_SEARCH_PATH_AUDIT_PASS("核心页面与关键字审核通过", 52, 16),
    APP_SEARCH_PATH_AUDIT_FAIL("核心页面与关键字审核失败", 53, 16),
    APP_NAME_CLEAR("小程序名称释放推送", 54, 47),
    SERVER_RESOURCE_PASS("服务资源单条审核通过", 55, 18),
    SERVER_RESOURCE_REJECT("服务资源单条审核失败", 56, 18),
    SERVER_RESOURCE_WAIT("服务资源审核中", 57, 18),
    SERVER_RESOURCE_CANCEL("服务资源取消审核", 58, 18),
    SERVER_RESOURCE_DELIVER_WAIT("服务资源提交审核", 59, 18),
    SERVER_RESOURCE_DELETE("删除服务资源", 60, 18),
    BATCH_TASK_UPLOAD_PACKAGE_SUCCESS("批量提包任务，单个小程序提包成功", 61, 5),
    APP_PAY_CLOSE("小程序支付封禁关闭", 62, 7),
    ARTICLE_MOUNT_AUDIT_SUCCESS("百家号文章挂载审核成功", 63, 19),
    ARTICLE_MOUNT_AUDIT_FAIL("百家号文章挂载审核拒绝", 64, 19),
    ;
    private String msg;

    private Integer eventCode;

    private Integer index;

    PushEventNameEnum(String msg, Integer eventCode, Integer index) {
        this.msg = msg;
        this.eventCode = eventCode;
        this.index = index;
    }

    public static List<EventBean> getByIndex(Integer index) {
        return Arrays.stream(PushEventNameEnum.values())
                .filter(x -> x.index.equals(index))
                .map(x -> {
                    EventBean eventBean = new EventBean();
                    eventBean.setCode(x.getEventCode());
                    eventBean.setCopyWriting(x.getMsg());
                    eventBean.setEventName(x);
                    return eventBean;
                }).collect(Collectors.toList());
    }

    public static PushEventNameEnum getByEventCode(Integer eventCode) {
        for (PushEventNameEnum pushEventNameEnum : PushEventNameEnum.values()) {
            if (pushEventNameEnum.eventCode.equals(eventCode)) {
                return pushEventNameEnum;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getEventCode() {
        return eventCode;
    }

    public Integer getIndex() {
        return index;
    }

    public static class EventBean {
        private Integer code;
        private PushEventNameEnum eventName;
        private String copyWriting;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getCopyWriting() {
            return copyWriting;
        }

        public void setCopyWriting(String copyWriting) {
            this.copyWriting = copyWriting;
        }

        public PushEventNameEnum getEventName() {
            return eventName;
        }

        public void setEventName(PushEventNameEnum eventName) {
            this.eventName = eventName;
        }

        @Override
        public String toString() {
            return "eventBean{" +
                    "code=" + code +
                    ", eventName=" + eventName +
                    ", copyWriting='" + copyWriting + '\'' +
                    '}';
        }
    }
}