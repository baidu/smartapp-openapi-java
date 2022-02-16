/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.common.enums;
/**
 * 错误码定义
 *
 * @author magenm
 * @date 2018/8/7 12:41
 */
public enum SmartAppErrorCode {
    OK(0, "success"),

    BUSINESS_ERROR(-1024, "业务异常"),

    ERRNO_PARAM_INVALID(2002, "param invalid"),

    ERRNO_INTERNAL_ERROR(1000, "internal error"),

    ERRNO_AUTHORITY(6001, "无权限"),

    ERRNO_MAPPCORE_REQUEST_FAIL(6002, "请求接口异常"),
    /**
     * 降级错误码
     */
    DEMOTION_FAIL(5000, "网络繁忙，请稍后重试"),

    UNKNOW_FAIL(500, "网络繁忙，请稍后重试"),

    THIRD_SERVER_UNKNOWN_FAIL(501, "网络繁忙，请稍后重试"),

    REQUEST_METHOD_NOT_SUPPORTED(501, "请求方式不支持"),

    PAGE_NOT_FOUND(404, "页面不存在"),

    NO_AUTHORIZATION(405, "未授权"),

    DUPLICATE_KEY_EXIST(40000, "记录已存在"),

    PARAMETER_TYPE_ERROR(41000, "参数类型错误"),

    PARAMETER_ERROR(40001, "参数错误"),

    CALLBACK_ADDR_NO_DOMAIN(40002, "回跳地址不在预设域下"),

    PAGE_ERROR(40003, "页面发生错误，请稍后重试"),

    AUTH_FORBIDDEN(40004, "该授权页面因过度访问暂时被封禁"),

    TABLE_SHARD_ERROR(40005, "分表路由失败，需设置分表字段内容"),

    FILE_SIZE_LIMIT_EXCEEDED_ERROR(40006, "文件超过限定尺寸"),

    NO_PERMISSION(40007, "无此TP操作权限"),

    IP_NOT_IN_WHITELIST(40008, "IP不在白名单"),

    PUBLISH_AUDIT_FAIL(40009, "全网发布提审失败"),

    UUID_TIMEOUT(40010, "uuid错误，重新刷新二维码"),

    NO_BIND(40011, "请提示开发者扫码进行绑定"),

    BINDING(40012, "开发者尚未确认"),

    BIND_ERROR(40013, "该小程序已与其他第三方平台绑定"),

    BIND_LIMIT(40014, "绑定失败，第三方平台绑定数量超限"),

    BIND_REPEAT(40015, "重复绑定"),

    TEMPLATE_USER_DESC_ILLEGALITY(40016, "模版描述非法，请参考官网参数规则"),

    CUSTOMER_NAME_IS_BLANK(40017, "主体名称已被拉黑,请检查名称"),

    TEMPLATE_COUNT_LIMIT_EXCEEDED(2003, "模板超过限额，无法添加"),

    LAST_PAGE_DATE_NULL(40018, "已至最后一页"),

    // API
    API_AUTHORIZATION_LOGIN_FAILED(44000, "用户名或密码错误"),

    COMMON_NOT_ACCESS(44001, "无权限访问"),

    API_AUTHORIZATION_LOGGEDOUT(44002, "TOKEN已注销"),

    API_AUTHORIZATION_EXPIRED(44003, "TOKEN已过期"),

    API_AUTHORIZATION_FAILED(44004, "TOKEN认证失败"),

    // APP
    APP_NOT_EXIST(45000, "小程序不存在"),

    APP_NO_PERMISSION(45001, "无此小程序操作权限"),

    APP_TP_AUTH_ERROR(45002, "授权异常"),

    APP_TP_CATEGORY_ERROR(45003, "当前有类目正在审核中"),

    // REDIS
    REDIS_NO_EXIST(46000, "redis中无值"),

    IMAGE_FORMAT_ILLEGALITY(47000, "图片格式无效"),

    IMAGE_UPLOAD_FAIL(47001, "图片上传失败"),

    GET_QR_CODE_FAIL(47002, "获取二维码失败"),

    IMAGE_SIZE_LIMIT_EXCEEDED(47003, "图片尺寸超过限制"),

    MODIFY_NAME_COUNT_LIMIT_EXCEEDED(47004, "修改名称超过限制次数"),

    MODIFY_ICON_COUNT_LIMIT_EXCEEDED(47005, "修改头像超过限制次数"),

    MODIFY_DESC_COUNT_LIMIT_EXCEEDED(47006, "修改简介超过限制次数"),

    MODIFY_CATEGORY_COUNT_LIMIT_EXCEEDED(47007, "修改服务分类超过限制次数"),

    IMAGE_SOURCE_ILLEGALITY(47008, "图片来源非法"),

    USER_NOT_LOGIN(47009, "用户未登录，请重新登录"),

    TP_NAME_HAS_USED(47010, "平台名称已被占用，请更换"),

    MODIFY_DOMAIN_COUNT_LIMIT_EXCEEDED(470011, "修改服务器域名超过限制次数"),

    MODIFY_WEB_VIEW_DOMAIN_COUNT_LIMIT_EXCEEDED(470012, "修改业务域名超过限制次数"),

    MODIFY_DOMAIN_TYPE_IS_NULL(470013, "至少传递一个要被操作的服务域名类型"),

    DOMAIN_FORMAT_ILLEGALITY(470014, "域名格式非法，请检查格式，协议目前只支持http:// https:// wss://"),

    DOMAIN_IS_NULL(470015, "域名不能为空"),

    DOMAIN_NOT_EQUAL_ANY_DOMAIN_FROM_TP(470016, "请求保存的域名不是第三方平台中已设置的小程序域名或子域名"),

    DOMAIN_NOT_EXIST_FOR_APP(470017, "删除的域名在小程序中没有设置过"),

    QR_CODE_SIZE_ILLEGALITY(470018, "二维码width字段超过指定范围"),

    QR_CODE_PACKAGE_ILLEGALITY(470019, "二维码package_id非法，只支持审核，开发中，线上版本的package"),

    QR_CODE_NO_ONLINE_PACKAGE(470020, "此小程序没有线上版本的包，需要指定package_id"),

    SWAN_VERSION_ILLEGALITY(470021, "版本输入错误"),

    CREATE_APP_DOING(470022, "小程序正在创建中，请稍后重试"),

    GET_TP_TICKET_FAIl(50001, "获取ticket失败"),

    CLIENT_ID_ILLEGALITY(50002, "client_id不存在"),

    TICKET_INVALID(50003, "ticket无效"),

    TP_AUTH_NO_REFERER(50006, "请在授权发起请求的Header增加Referer属性，表示来源"),

    NO_APP_FOR_AUTH(50007, "没有小程序可用供授权"),

    AUTHORIZED_QUIETLY(50008, "已经授权过，请勿重复调用"),

    QUIETLY_AUTHORIZED_TP_ILLEGALITY(50009, "创建小程序的第三方才可以进行静默授权"),

    NOT_SUPPORT_PERSONAL_XZH(50010, "暂不支持个人熊掌号注册"),

    NOT_SUPPORT(50011, "此账号暂不支持此功能"),

    CREATE_APP_TP_ILLEGALITY(50012, "只允许代创建账户的第三方代创建小程序"),

    NO_SUPPORT_GAME(50013, "暂时不支持小游戏，敬请期待！"),

    USER_NO_BIND_MOBILE(50014, "未绑定手机号"),

    TASK_DOING(50015, "任务正在进行中, 请稍后重试"),

    USER_REGISTERED(50016, "账号已注册"),

    ACCOUNT_NAME_EXIST(50017, "账户名已存在"),

    ACCOUNT_OWNER_ID_EXIST(50018, "同一个身份证号只能申请一个账号"),

    ACCOUNT_EXIST(50019, "当前百度账号已经开通熊掌号"),

    ACCOUNT_CHECKING(50020, "账号正在审核中，请耐心等待审核结果"),

    ACCOUNT_INFO_NO_CHANGE(50021, "修改内容一致,无需修改"),

    ACCOUNT_NAME_ID_NO_MATCH(50022, "姓名与身份证号不匹配"),

    QUALIFICATION_FOR_ACCOUNT_COUNT_LIMIT_EXCEEDED(50023, "当前资质开号数量已达上限"),

    APP_NAME_ILLEGAL(50024, "小程序名称已经被占用"),

    APP_NAME_EXIST(50025, "小程序名称非法"),

    USER_APP_BIND_EXIST(50027, "当前账号已经绑定为小程序的管理员或成员，请解除绑定"),

    XZH_REGISTER_ERROR(50028, "熊掌号注册失败"),

    INVOKE_COUNT_LIMIT_EXCEEDED(50029, "接口调用次数超过限制"),

    NO_TASK_FOR_UPLOAD_PACKAGE_BATCH(50030, "没有需要替换的小程序"),

    UPLOAD_DUPLICATE(50031, "处理中，请稍后重试"),

    NO_AUTH(50032, "没有授权关系，请检查"),

    CUSTOMER_NOT_PASS(50033, "主体资质没有审核通过，请先通过主体资质审核！"),

    XZH_CHECKING(50034, "熊掌号尚未审核通过"),

    XZH_BOUND(50035, "已经绑定熊掌号，不可重复绑定"),

    CUSTOMER_NOT_BOUND_XZH(50036, "主体未绑定熊掌号，请先在开发者平台进行绑定"),

    PASSPORT_ALREADY_BIND_OTHER_TP(50037, "用户已绑定其它第三方平台"),
    /**
     * 代码是从B端迁移过来的 兼容原来错误码
     */
    B_PARAMETER_ERROR(30001, "参数错误"),

    TICKET_ASEKEY_LEN_INVALID(50037, "AesKey长度不足43位"),

    COMPLETE_ADVANCED_AUTH_FIRST(50038, "请先完成高级认证"),

    USER_REGISTERED_FAIL(50039, "账号注册失败"),

    USER_REGISTERING(50040, "账号正在注册中"),

    AUTH_REPEAT(50041, "此账号已授权其他第三方，请先与原先授权的第三方解绑"),

    DOMAIN_NOT_EXIST_FOR_TP(50042, "删除的域名在第三方平台中没有设置过"),

    DOMAIN_CER_NOT_EXIST(50043, "请在根目录下添加检验文件，以证明域名可控"),

    CONFLICT_OF_AUTHORITY(50044, "权限冲突"),

    WEB_VIEW_DOMAIN_COUNT_LIMIT_EXCEEDED(50045, "业务域名数量超过限制"),

    DOMAIN_COUNT_LIMIT_EXCEEDED(50046, "服务域名数量超过限制"),

    REGISTER_FIRST(50047, "该账号尚未注册或审核未通过，请您先提交账号资质信息完成注册"),

    PUBLISH_CHECKING(50048, "全网发布正在审核中，请勿修改基本信息"),

    TP_AUDIT_FAIL(50049, "Tp基本信息审核送审失败"),

    UPDATE_DUPLICATE(50050, "处理中，请稍后重试"),

    SAME_MODIFICATIONS(50051, "修改内容与当前内容相同，请重新修改"),

    TP_INFO_AUDIT_DOING(50052, "该信息当前正在审核中，请勿重复修改"),

    CURRENT_TP_NOT_CONTAIN(50053, "当前TP不包含以下权限:"),

    ACCOUNT_NOT_SUPPORT_PERSONAL_XZH(50054, "此账号已开通个人类型熊掌ID，而小程序目前不支持个人类型主体，请更换账号"),

    ACCOUNT_QUALIFICATIONS_DIFF(50055, "此账号已开通熊掌ID，该熊掌ID已绑定的主体与当前提交资质不符，请重新提交主体资质或更换账号"),

    ACCOUNT_STATUS_ABNORMALLY(50056, "此账号已经绑定的熊掌ID状态异常，请更换账号"),

    APP_NO_AUTHORIZATION_MEMBER_MANAGE(50057, "当前小程序未授权当前TP账号管理权限"),

    ACCOUNT_QUALIFICATION_INCOMPLETE(50058, "账号资质不全，请手动上传资质数据"),

    REGISTER_PROCESS_DUPLICATE(50059, "存在进行中的代注册流程"),

    E_CREATE_UC_USER_FAIL(50060, "UC账号创建失败"),

    /**
     * 成员管理
     */
    E_CONSOLE_NOT_APP_ADMIN(51101, "管理员不存在"),

    E_CONSOLE_MEMBER_EXIST(51102, "用户已存在，无法添加"),

    E_CONSOLE_APP_ADMIN_EXIST(51103, "管理员已存在，无法添加"),

    E_CONSOLE_NOT_MEMBER_EXIST(51104, "成员不存在"),

    E_CONSOLE_MEMBER_COUNT_MAX(51105, "成员数量超过限制"),

    /**
     * 支付业务
     */
    PAYMENT_PARAM_ERROR(60000, "参数错误"),

    PAYMENT_HAD_BIND_UC(60001, "该账号已经绑定过了"),

    PAYMENT_HAVE_NOT_BIND_UC(60002, "该账号未绑定支付账号"),

    PAYMENT_NO_BUSINESS_LICENCE(60003, "该账号营业执照信息不完整"),

    PAYMENT_LEGAL_PERSON_NAME_INVALID(60004, "法人姓名限定在 2 - 50 字符"),

    PAYMENT_LEGAL_ID_INVALID(60005, "身份证号必须为18位"),

    PAYMENT_CREAT_ACCOUNT_AUDIT_STATUS_NOT_EXIST(60006, "支付账号审核信息不存在"),

    PAYMENT_CREATE_PAYMENT_SERVICE_FAILED(60007, "创建支付服务失败"),

    PAYMENT_SERVICE_NOT_EXIST(60008, "支付服务不存在"),

    PAYMENT_SERVICE_ALREADY_EXIST(60009, "支付服务已经存在，请勿重复创建"),

    PAYMENT_SERVICE_UPDATE_FAILED(60010, "更新支付服务信息失败"),

    PAYMENT_USE_OUR_UPLOAD_IMAGE(60011, "图片Url不是来自于我们的图片上传服务"),

    PAYMENT_ACCOUNT_ALREADY_EXIST(60012, "支付账号已经存在，请勿重复创建"),

    PAYMENT_ACCOUNT_NOT_EXIST(60013, "支付账号不存在，请先创建支付账号"),

    PAYMENT_DEVELOPER_CONFIG_NOT_EXIST(60014, "开发者设置未提交，请先提交开发者设置"),

    PAYMENT_CREATE_ACCOUNT_FAIL(60015, "账号异常"),

    PAYMENT_ACCOUNT_AUDIT_FAIL(60016, "创建账号审核未通过,请查看创建账号的审核状态"),

    PAYMENT_ACCOUNT_CREATE_PENGDING_ERROR(60017, "支付账号审核中，无法再次创建"),

    PAYMENT_DEVELOP_CONFIG_UPDATE_PENGDING_ERROR(60018, "开发者设置审核中，无法再次修改"),

    PAYMENT_SERVICE_UPDATE_PENGDING_ERROR(60019, "支付服务审核中，无法再次修改"),

    PAYMENT_PARAM_REQUEST_BODY_NULL(60020, "Request Body 不能为空"),

    PAYMENT_DATA_NOT_FOUND(60021, "未获取到有效数据"),

    /**
     * 全网发布检测
     */
    PUBLICATION_DETECTION_FAILED(61000, "全网发布权限检测未通过"),

    PUBLICATION_DETECTION_SCOPE_FAILED(61001, "当前权限检测未通过"),

    PUBLICATION_DETECTION_SCOPE_HAD_EXIST(61002, "当前权限已存在"),

    /**
     * 入驻线上化
     */
    CX_INTERNAL_ERROR(62000, "内部错误"),

    CX_COMPANY_REGISTRATION_INFO_NOT_EXIST(62001, "未查询到企业注册信息"),

    /**
     * web化配置 robots 协议
     */
    ROBOT_OPERATE_NEED_PERMISSION(63000, "操作需要开发管理权限"),

    ROBOTS_UPLOAD_FAILED(63001, "上传Robots文件失败"),

    ROBOTS_CONTENT_FORMAT_ERROR(63002, "robots 文件格式有误"),

    ROBOTS_TEMPLATE_NOT_EXIST(63002, "template id 对应的模版不存在"),

    /**
     * 真实性认证豁免
     */
    ADVANCED_AUTH_ALREADY_PASS(64001, "已完成真实性认证, 请勿重复调用"),

    /**
     * 流量主权限
     */
    SCOPE_DATA_ADVERT_CAN_NOT_CHANGE(65001, "收益转交的流量主权限不能进行变更"),

    SCOPE_DATA_ADVERT_NEED_IN_WHITE_LIST(65002, "收益转交的流量主权限需要在白名单内"),

    /**
     * 核心页面与关键字
     */
    SEARCH_PATH_PAGE_LIMIT(66001, "每个小程序最多可添加10个核心页面，当前已超过数量上限。"),

    SEARCH_PATH_KEYWORDS_LIMIT(66002, "每个核心页面最多可添加10个关键词，当前已超过数量上限。"),

    SEARCH_PATH_CONTENT_REPEAT(66003, "同一小程序，核心页面path、标题、描述、关键词均不可重复。"),

    SEARCH_PATH_PARAM_PARAM_LACK(66004, "您未提交该核心页面的标题或描述。"),

    SEARCH_PATH_APP_UNAVAILABLE(66005, "该小程序目前不支持提交核心页面关键词。"),

    SEARCH_PATH_PARAM_IS_ILLEGAL_PATH_TITLE_DESC(66006, "path、title、desc中不得使用违规、敏感词汇"),

    SEARCH_PATH_PARAM_IS_ILLEGAL_KEYWORD(66007, "keyword关键字中不得使用违规、敏感词汇"),

    SEARCH_PATH_MAIN_INDEX_REJECT_TITLE_AND_DESC(66008, "主页path不需要传递标题与描述"),

    SEARCH_PATH_APP_NOT_OPERATION_PERMISSION(66009, "该小程序目前不支持操作核心页面关键词。"),

    SEARCH_PATH_TP_NO_OPERATION_PERMISSION(66010, "第三方平台目前没有权限操作核心页面关键词"),

    /**
     * 模版消息
     */
    USER_HAS_NOT_SUBSCRIBE_TEMPLATE(67001, "用户尚未订阅该模版"),

    /**
     * 快审额度机制
     */
    GET_AUDIT_WAITE_LIST_ERROR(68001, "获取待审信息失败"),

    GET_AUDIT_QUOTA_ERROR(68002, "当前TP无快审额度"),

    FAST_AUDIT_QUOTA_HAD_EXHAUST(68003, "快审额度已用尽"),

    FAST_AUDIT_APPLY_ERROR(68004, "提交快审失败"),

    /**
     * 提包&送审错误码
     * */
    SUBMIT_NAME_AUDIT_NO_PASS_ERROR(69001, "小程序名称审核通过后，可以提交小程序代码审核"),

    SUBMIT_CATEGORY_AUDIT_NO_PASS_ERROR(69002, "服务类目审核通过后，可以提交小程序代码包审核"),

    SUBMIT_NAME_AND_CATEGORY_AUDIT_NO_PASS_ERROR(69003, "小程序名称和服务类目审核通过后，可以提交小程序代码包审核"),

    UPLOAD_PACKAGE_ILLEGAL_CHARACTER_ERROR(69004 , "EXT_JSON字段包含无法解析字符"),

    QUERY_PACKAGE_NOT_FOUND(69005, "包不存在"),

    SUBMIT_SOURCE_TEMPLATEID_ERROR(69006, "源模板数量超出限制"),

    SUBMIT_TARGET_TEMPLATEID_ERROR(69007, "目标模板已下线,请检查输入"),

    SOURCE_TEMPLATEID_NOT_EXIST(69008, "源模板不存在,请检查输入"),

    UPLOAD_PACKAGE_SYSTEM_ERROR(69009 , "提包服务暂时不可用，请稍后重试" ),

    UPLOAD_PACKAGE_TEMPLATE_PARSE_ERROR(69010 , "模板文件解析出错" ),

    SUBMIT_AUDIT_SYSTEM_ERROR(69011 , "审核服务暂时不可用，请稍后重试" ),

    RELEASE_PACKAGE_SYSTEM_ERROR(69012 , "发布服务暂时不可用，请稍后重试" ),

    SUBMIT_PACKAGE_OVER_LIMIT_ERROR(69013 , "送审额度已超出当前周期限制" ),

    /**
     * 卡券
     */
    COUPON_TEMPLATE_BANNER_ADD_EXIST(70000, "当前优惠券已添加推广图,请勿重复添加"),

    COUPON_TEMPLATE_NOT_EXIST(70001, "优惠券不存在"),

    IMPORT_COUPON_CODE_SIZE_LIMIT(70002, "导入优惠券码大小超限"),

    IMPORT_COUPON_CODE_LENGTH_LIMIT(70003, "导入优惠券码长度超限"),

    APP_NO_BIND_XZH(10001, "sitemap相关操作需要先绑定熊掌号"),

    /**
     * 品牌词
     */

    BRAND_WORD_RELATION_TYPE_ERROR(100001, "品牌词关系类型无效"),

    BRAND_WORD_CANNOT_CONTAIN_SPECIAL_CHARACTERS(100002, "不能包含字符，"),

    BRAND_WORD_LENGTH_LIMIT_EXCEEDED(100003, "品牌词长度超限"),

    E_BRAND_WORD_EXIST(100004, "已经过申请该品牌词"),

    E_BRAND_WORD_CERTIFICATION_INCOMPLETE(100005, "缺少关系证明图："),

    E_BRAND_WORD_DISQUALIFICATION(100006, "该小程序不满足提交商标词的条件"),

    E_BRAND_WORD_COUNT_LIMIT_EXCEEDED(100007, "提交数量超限"),

    E_BRAND_WORD_SUBMIT_FAIL(100008, "提交失败 原因："),

    E_BRAND_WORD_AUDITING(100009, "正在审核中，请勿重复提交"),

    E_OFFICIAL_MARK_SUBMIT_ILLEGALITY(100010, "需要品牌词／别名简称审核通过后才可以提交官方标"),
   

    /**
     * 流量下线
     */
    E_APP_FLOW_CONTROL_EXCEPTION(110001, "操作异常，请稍后重试"),
    E_APP_FLOW_CONTROL_ONLINE_NO_PRIVILEGE(110002, "开启流量失败，无操作权限"),
    E_APP_FLOW_CONTROL_OFFLINE_NO_PRIVILEGE(110003, "下线流量失败，无操作权限"),
    E_APP_FLOW_CONTROL_ONLINE_REPEAT(110004, "操作失败，小程序流量正常无需开启流量"),
    E_APP_FLOW_CONTROL_OFFLINE_REPEAT(110005, "操作失败，当前小程序已经被下线流量"),
    /**
     *服务库
     */
    SKU_EMPTY_PATH(120001, "path为空，请检查输入"),
    SKU_QUERYNULL(120002 , "无有此服务资源，请重试或检查输入"),
    SERVER_SKU_NO_PERMISSION(120003 , "没有提交资源权限"),
    SERVER_SKU_AUTHORIZE_ERR(120004 , "授权错误"),
    SERVER_SKU_ERR_PARAMETER(120005 , "参数错误"),
    SERVER_SKU_OVER_LIMITED(120006 , "一次最多提交50条"),
    E_COMMON_NOT_ACCESS(120007,"该用户无权访问！")

    ;


    private Integer code;
    private String msg;

    SmartAppErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgByCode(Integer code) {
        SmartAppErrorCode[] values = SmartAppErrorCode.values();
        for (SmartAppErrorCode ec : values) {
            if (ec.code.equals(code)) {
                return ec.msg;
            }
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public SmartAppErrorCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
