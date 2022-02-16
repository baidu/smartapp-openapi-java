package com.baidu.mapp.tp.api;

import java.util.List;

import com.baidu.mapp.tp.bean.payment.ApplyOrderRefundClient;
import com.baidu.mapp.tp.bean.payment.ApplyOrderRefundResponseClient;
import com.baidu.mapp.tp.bean.payment.BillListClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceIncomeDetailListClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceListClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceOtherDetailListClient;
import com.baidu.mapp.tp.bean.payment.FinanceExpenseListClient;
import com.baidu.mapp.tp.bean.payment.FinanceExpensePayDetailListClient;
import com.baidu.mapp.tp.bean.payment.OrderListClient;
import com.baidu.mapp.tp.bean.payment.OrderRefundDetailClient;
import com.baidu.mapp.tp.bean.payment.PaymentAccount;
import com.baidu.mapp.tp.bean.payment.PaymentServiceClient;
import com.baidu.mapp.tp.bean.payment.PaymentServiceDictClient;
import com.baidu.mapp.tp.bean.payment.PaymentServiceVO;
import com.baidu.mapp.tp.bean.payment.TpOrderClient;
import com.baidu.mapp.tp.bean.payment.TradeIndustry;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 支付服务接口
 * https://smartprogram.baidu.com/docs/third/pay/intro/
 * @author: chenhaonan02
 * @create: 2021-11-10 21:02
 **/
public interface PaymentService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "PaymentService";
    /**
     * 获取支付服务数据字典
     * https://smartprogram.baidu.com/docs/third/pay/dict/
     */
    String TP_PAY_PAYMENT_SERVICE_DICT = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/dict";
    /**
     * 创建支付账号
     * https://smartprogram.baidu.com/docs/third/pay/createaccount/
     */
    String TP_PAY_ACCOUNT_CREATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/account/create";
    /**
     * 支付账号创建状态查询
     * https://smartprogram.baidu.com/docs/third/pay/account_created_status_query/
     */
    String TP_PAY_ACCOUNT_AUDIT_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/account/auditstatus";
    /**
     * 设置开发者信息
     * https://smartprogram.baidu.com/docs/third/pay/setdeveloper/
     */
    String TP_PAY_DEVELOP_CONFIG_SUBMIT = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/developconfig/submit";
    /**
     * 创建支付服务
     * https://smartprogram.baidu.com/docs/third/pay/createservice/
     */
    String TP_PAY_PAYMENT_SERVICE_CREATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/create";
    /**
     * 支付服务创建状态查询
     * https://smartprogram.baidu.com/docs/third/pay/service_created_status_query/
     */
    String TP_PAY_PAYMENT_SERVICE_AUDIT_STATUS =
            SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/auditstatus";
    /**
     * 更新支付服务部分字段（不需要审核）
     * https://smartprogram.baidu.com/docs/third/pay/payment_service_update_part/
     */
    String TP_PAY_PAYMENT_SERVICE_UPDATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/update";
    /**
     * 更新支付服务全部信息（需要审核）
     * https://smartprogram.baidu.com/docs/third/pay/payment_service_update_all/
     */
    String TP_PAY_PAYMENT_SERVICE_UPDATE_BIND_SERVICE =
            SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/updatebindservice";
    /**
     * 获取绑定的支付服务
     * https://smartprogram.baidu.com/docs/third/pay/get_bound_payment_service/
     */
    String TP_PAY_PAYMENT_SERVICE_GET_BIND_SERVICE =
            SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/getbindservice";
    /**
     * 获取支付行业id列表
     * https://smartprogram.baidu.com/docs/third/pay/industry_list/
     */
    String TP_PAY_TP_GET_TRADE_INDUSTRY_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/tp/getTradeIndustryList";
    /**
     * 支付订单流水列表
     * https://smartprogram.baidu.com/docs/third/pay/data/get_pay_orders_list/
     */
    String TP_PAY_PAYMENT_SERVICE_ORDER_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "pay/paymentservice/orderlist";
    /**
     * 支付收入列表
     * https://smartprogram.baidu.com/docs/third/pay/data/get_pay_income_list/
     */
    String TP_PAY_PAYMENT_SERVICE_FINANCE_BALANCE = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "pay/paymentservice/financebalance";
    /**
     * 支付收入货款列表
     * https://smartprogram.baidu.com/docs/third/pay/data/get_pay_income_loan_list/
     */
    String TP_PAY_PAYMENT_SERVICE_FINANCE_BALANCE_INCOME_DETAIL = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "pay/paymentservice/financebalance/incomedetail";
    /**
     * 支付收入其他款项列表
     * https://smartprogram.baidu.com/docs/third/pay/data/get_pay_income_other_list/
     */
    String TP_PAY_PAYMENT_SERVICE_FINANCE_BALANCE_OTHER_DETAIL = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "pay/paymentservice/financebalance/otherdetail";
    /**
     * 支出列表
     * https://smartprogram.baidu.com/docs/third/pay/data/get_pay_income_other_list/
     */
    String TP_PAY_PAYMENT_SERVICE_FINANCE_EXPENSE = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "pay/paymentservice/financeexpense";
    /**
     * 支出打款详情
     * https://smartprogram.baidu.com/docs/third/pay/data/get_spending_remit_detail/
     */
    String TP_PAY_PAYMENT_SERVICE_FINANCE_EXPENSE_PAY_DETAIL = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "pay/paymentservice/financeexpense/paydetail";
    /**
     * 查询订单(TP纬度)
     */
    String TP_PAY_PAYMENT_SERVICE_FIND_BY_TP_ORDER_ID = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/tp/findByTpOrderId";
    /**
     * 关闭订单(TP纬度)
     */
    String TP_PAY_PAYMENT_SERVICE_CANCEL_ORDER = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/tp/cancelOrder";
    /**
     * 申请退款(TP纬度)
     */
    String TP_PAY_PAYMENT_SERVICE_APPLY_ORDER_REFUND = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/tp/applyOrderRefund";
    /**
     * 查询退款(TP纬度)
     */
    String TP_PAY_PAYMENT_SERVICE_FIND_ORDER_REFUND = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/tp/findOrderRefund";
    /**
     * 下载订单对账单(TP纬度)
     */
    String TP_PAY_PAYMENT_SERVICE_ORDER_BILL = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/tp/orderBill";
    /**
     * 下载资金账单(TP纬度)
     */
    String TP_PAY_PAYMENT_SERVICE_CAPITA_BILL = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/tp/capitaBill";

    /**
     * 获取支付服务数据字典
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return PaymentServiceDictClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PaymentServiceDictClient getPaymentServiceDict(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 创建支付账号
     *
     * @param accessToken           授权小程序的接口调用凭据
     * @param businessScope         经营范围。营业执照上经营范围，长度 2-2000 个字符
     * @param businessProvince      经营范围所在省。
     * @param businessCity          经营范围所在市。
     * @param businessDetailAddress 经营地址详情。
     * @param legalPerson           法人姓名，即身份证姓名（汉字，限制在 1 - 25 位）。
     * @param legalId               身份证号（长度限定为18位）。
     * @param idCardFrontUrl        身份证正面地址(必须是我们服务上传生成的图片URL，参见图片上传)
     * @param idCardBackUrl         身份证反面地址(必须是我们服务上传生成的图片URL，参见图片上传)
     * @param legalCardStartTime    法人身份证开始时间 例：2020-12-31
     * @param legalCardEndTime      法人身份证结束时间 例：2020-12-31，长期有效传 9999-12-31
     * @param licenseStartTime      营业执照证开始时间 例：2020-12-31，长期有效传营业执照核准日期
     * @param licenseEndTime        营业执照结束时间 例：2020-12-31，长期有效传 9999-12-31
     * @param industryId            行业id 见查询行业id列表接口
     * @param managePermitUrl       若行业id需要资质，资质图片地址
     * @param authCapital           注册资本
     * @param managerSame           经营控股人是否与法人一致
     *                              0 - 不一致
     *                              1 - 一致
     *                              如果不一致则相关信息必传否则不传
     * @param manager               最大股东姓名
     * @param managerCard           最大股东身份证
     * @param managerCardType       最大股东身份证类型
     * @param managerCardFrontUrl   最大股东身份证正面地址
     * @param managerCardBackUrl    最大股东身份证反面地址
     * @param managerCardStartTime  最大股东证件开始时间
     * @param managerCardEndTime    最大股东证件结束时间
     * @param benefitSame           受益人是否与法人一致
     *                              0 - 不一致
     *                              1 - 一致
     *                              如果不一致则相关信息必传否则不传
     * @param benefit               受益人姓名
     * @param benefitCard           受益人身份证
     * @param benefitCardType       受益人身份证类型
     * @param benefitCardFrontUrl   受益人身份证正面地址
     * @param benefitCardBackUrl    受益人身份证反面地址
     * @param benefitStartTime      受益人证件开始时间
     * @param benefitEndTime        受益人证件结束时间
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void payAccountRegister(String accessToken, String businessScope, String businessProvince, String businessCity,
                            String businessDetailAddress, String legalPerson, String legalId, String idCardFrontUrl,
                            String idCardBackUrl, String legalCardStartTime, String legalCardEndTime,
                            String licenseStartTime, String licenseEndTime, Integer industryId, String managePermitUrl,
                            Long authCapital, Integer managerSame, String manager, String managerCard,
                            String managerCardType,
                            String managerCardFrontUrl, String managerCardBackUrl, String managerCardStartTime,
                            String managerCardEndTime, Integer benefitSame, String benefit, String benefitCard,
                            String benefitCardType,
                            String benefitCardFrontUrl, String benefitCardBackUrl, String benefitStartTime,
                            String benefitEndTime) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支付账号创建状态查询
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return PaymentAccount
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PaymentAccount getAccountAuditStatus(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 设置开发者信息
     *
     * @param accessToken    授权小程序的接口调用凭据
     * @param tpPublicKey    开发者公钥。参见[RSA公私钥生成](https://smartprogram.baidu.com/docs/develop/function/keygen_v2/)
     * @param payNotifyUrl   支付回调地址。
     * @param refundAuditUrl 退款审核地址。
     * @param refundSuccUrl  退款回调地址。
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void submitDevelopConfig(String accessToken, String tpPublicKey, String payNotifyUrl, String refundAuditUrl,
                             String refundSuccUrl) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 创建支付服务
     *
     * @param accessToken        授权小程序的接口调用凭据
     * @param appName            服务名称。支付服务的名称
     * @param servicePhone       服务电话。
     * @param bankAccount        银行账户。银行卡开户名
     * @param bankCard           银行卡号。
     * @param bankName           所属银行。由数据字典接口取
     * @param bankBranch         支行信息。自由输入，例如：招商银行北京上地支行
     * @param openProvince       开户省份。由数据字典接口取
     * @param openCity           开户城市。由数据字典接口取
     * @param paymentDays        结算周期。由数据字典接口取
     * @param commissionRate     佣金比例。固定传 6，小程序固定为千分之六(6)
     * @param poolCashPledge     打款预留（元）。提现后的保留金额
     * @param dayMaxFrozenAmount 每日退款上限(元)。每天最大退款限额10000元
     * @param bankPhoneNumber    银行卡预留手机号
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void createPaymentService(String accessToken, String appName, String servicePhone, String bankAccount,
                              String bankCard, String bankName, String bankBranch, String openProvince,
                              String openCity, Integer paymentDays, Integer commissionRate, Long poolCashPledge,
                              Long dayMaxFrozenAmount, String bankPhoneNumber)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支付服务创建状态查询
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return PaymentServiceVO
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PaymentServiceVO getPaymentServiceAuditStatus(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新支付服务部分字段（不需要审核）
     *
     * @param accessToken    授权小程序的接口调用凭据
     * @param appName        服务名称。
     * @param servicePhone   服务电话。
     * @param poolCashPledge 打款预留。提现后的保留金额
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void updatePaymentService(String accessToken, String appName, String servicePhone, Long poolCashPledge)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新支付服务全部信息（需要审核）
     *
     * @param accessToken        授权小程序的接口调用凭据
     * @param appName            服务名称。支付服务的名称
     * @param servicePhone       服务电话。
     * @param bankAccount        银行账户。银行卡开户名
     * @param bankCard           银行卡号。
     * @param bankName           所属银行。由数据字典接口取。
     * @param bankBranch         支行信息。自由输入，例如：招商银行北京上地支行
     * @param openProvince       支开户省份。由数据字典接口取
     * @param openCity           开户城市。由数据字典接口取
     * @param paymentDays        结算周期。由数据字典接口取
     * @param commissionRate     佣金比例。固定传 6，小程序固定为千分之六(6)
     * @param poolCashPledge     打款预留（元）。提现后的保留金额
     * @param dayMaxFrozenAmount 每日退款上限(元)。每天最大退款限额10000元
     * @param bankPhoneNumber    银行卡预留手机号
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void updateBindPaymentService(String accessToken, String appName, String servicePhone, String bankAccount,
                                  String bankCard, String bankName, String bankBranch, String openProvince,
                                  String openCity, Integer paymentDays, Integer commissionRate, Long poolCashPledge,
                                  Long dayMaxFrozenAmount, String bankPhoneNumber)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取绑定的支付服务
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return PaymentServiceClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    PaymentServiceClient getBindService(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取支付行业id列表
     *
     * @param accessToken 第三方平台的接口调用凭据
     *
     * @return List<TradeIndustry>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<TradeIndustry> getTradeIndustryList(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支付订单流水列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param status      订单状态。
     *                    all：全部
     *                    1：待付款
     *                    2：已付款
     *                    3：已消费
     *                    4：退款中
     *                    5：已退款
     *                    6：退款失败
     *                    7：已取消
     * @param startTime   起始时间戳，10位时间戳
     * @param endTime     结束时间戳，10位时间戳
     * @param currentPage 当前页数。起始为 1
     * @param pageSize    分页。每页数量
     *
     * @return OrderListClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    OrderListClient getOrderList(String accessToken, String status, Long startTime, Long endTime, Long currentPage,
                                 Long pageSize) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支付收入列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param currentPage 当前页数。起始为 1。
     * @param pageSize    分页每页数量。
     * @param startTime   开始日期。格式如：2019-01-02。
     * @param endTime     结束日期。格式如： 2019-01-02。
     *
     * @return 财务-收入列表
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    FinanceBalanceListClient getFinanceBalance(String accessToken, Long currentPage, Long pageSize,
                                               String startTime, String endTime)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支付收入货款列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param currentPage 当前页数。起始为 1。
     * @param pageSize    分页每页数量。
     * @param startTime   开始日期。格式如：2019-01-02（该接口只查询某一天的数据
     *
     * @return 财务-收入货款详情
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    FinanceBalanceIncomeDetailListClient getFinanceBalanceIncomeDetail(String accessToken, Long currentPage,
                                                                       Long pageSize, String startTime)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支付收入其他款项列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param currentPage 当前页数（起始为 1 ）
     * @param pageSize    分页每页数量
     * @param startTime   开始日期（格式如： 2019-01-02 ）
     * @param endTime     结束日期（格式如： 2019-01-02 ）
     *
     * @return 财务-收入其它款项详情
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    FinanceBalanceOtherDetailListClient getFinanceBalanceOtherDetail(String accessToken, Long currentPage,
                                                                     Long pageSize, String startTime, String endTime)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支出列表
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param currentPage 当前页数（起始为 1 ）
     * @param pageSize    分页每页数量
     * @param startTime   开始日期（格式如： 2019-01-02 ）
     * @param endTime     结束日期（格式如： 2019-01-02 ）
     *
     * @return 财务-收入其它款项详情
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    FinanceExpenseListClient getFinanceExpenseList(String accessToken, Long currentPage,
                                                   Long pageSize, String startTime, String endTime)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 支出打款详情
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param taskId      支付凭证 id。
     *
     * @return 财务-支出打款详情
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    FinanceExpensePayDetailListClient getFinanceExpensePayDetail(String accessToken, Long taskId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查询订单
     *
     * @param accessToken 获取开发者服务权限说明
     * @param pmAppKey    调起百度收银台的支付服务 appKey
     * @param tpOrderId   开发者订单 Id
     *
     * @return TpOrderClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TpOrderClient findByTpOrderId(String accessToken, String pmAppKey, String tpOrderId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 关闭订单
     *
     * @param accessToken 获取开发者服务权限说明
     * @param pmAppKey    调起百度收银台的支付服务 appKey
     * @param orderId     百度订单 Id
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean cancelOrder(String accessToken, String pmAppKey, String orderId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 申请退款
     *
     * @param accessToken            获取开发者服务权限说明
     * @param pmAppKey               调起百度收银台的支付服务 appKey
     * @param applyOrderRefundClient 申请订单退款客户
     *
     * @return ApplyOrderRefundResponseClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    ApplyOrderRefundResponseClient applyOrderRefund(String accessToken, String pmAppKey,
                                                    ApplyOrderRefundClient applyOrderRefundClient)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查询退款
     *
     * @param accessToken 获取开发者服务权限说明
     * @param pmAppKey    调起百度收银台的支付服务 appKey
     * @param tpOrderId   开发者订单 Id
     * @param userId      百度收银台用户 Id
     *
     * @return OrderRefundDetailClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    OrderRefundDetailClient findOrderRefund(String accessToken, String pmAppKey, String tpOrderId, Long userId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 下载订单对账单
     *
     * @param accessToken 获取开发者服务权限说明
     * @param billTime    对账单日期格式 yyyy-MM-dd
     * @param pmAppKey    调起百度收银台的支付服务 appKey
     *
     * @return BillListClient
     *
     * @throws SmartAppErrorException
     * @throws OpenAPIErrorException
     */
    BillListClient orderBill(String accessToken, String billTime, String pmAppKey) throws SmartAppErrorException,
            OpenAPIErrorException;

    /**
     * 下载资金账单
     *
     * @param accessToken 获取开发者服务权限说明
     * @param billTime    对账单日期格式 yyyy-MM-dd
     * @param pmAppKey    调起百度收银台的支付服务 appKey
     *
     * @return BillListClient
     *
     * @throws SmartAppErrorException
     * @throws OpenAPIErrorException
     */
    BillListClient capitaBill(String accessToken, String billTime, String pmAppKey)
            throws SmartAppErrorException, OpenAPIErrorException;
}
