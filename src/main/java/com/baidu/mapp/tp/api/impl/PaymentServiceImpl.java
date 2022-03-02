package com.baidu.mapp.tp.api.impl;

import java.util.List;
import java.util.Map;

import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.enums.SmartAppErrorCode;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.tp.api.PaymentService;
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
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: TP支付服务接口实现类
 * @author: chenhaonan02
 * @create: 2021-11-11 15:28
 **/
public class PaymentServiceImpl extends BaseService implements PaymentService {

    private static PaymentService paymentService;

    public static PaymentService getInstance() {
        if (paymentService == null) {
            paymentService =
                    ProxyUtil.proxy(new PaymentServiceImpl(), TimeIntervalAspect.class);
        }
        return paymentService;
    }

    @Override
    public PaymentServiceDictClient getPaymentServiceDict(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_DICT, params);

        SmartAppResult<PaymentServiceDictClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PaymentServiceDictClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void payAccountRegister(String accessToken, String businessScope, String businessProvince,
                                   String businessCity, String businessDetailAddress, String legalPerson,
                                   String legalId, String idCardFrontUrl, String idCardBackUrl,
                                   String legalCardStartTime, String legalCardEndTime, String licenseStartTime,
                                   String licenseEndTime, Integer industryId, String managePermitUrl, Long authCapital,
                                   Integer managerSame, String manager, String managerCard, String managerCardType,
                                   String managerCardFrontUrl, String managerCardBackUrl, String managerCardStartTime,
                                   String managerCardEndTime, Integer benefitSame, String benefit, String benefitCard,
                                   String benefitCardType, String benefitCardFrontUrl, String benefitCardBackUrl,
                                   String benefitStartTime, String benefitEndTime)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("business_scope", businessScope);
        params.put("business_province", businessProvince);
        params.put("business_city", businessCity);
        params.put("business_detail_address", businessDetailAddress);
        params.put("legal_person", legalPerson);
        params.put("legal_id", legalId);
        params.put("id_card_front_url", idCardFrontUrl);
        params.put("id_card_back_url", idCardBackUrl);
        params.put("legal_card_start_time", legalCardStartTime);
        params.put("legal_card_end_time", legalCardEndTime);
        params.put("license_start_time", licenseStartTime);
        params.put("license_end_time", licenseEndTime);
        params.put("industry_id", industryId);
        params.put("manage_permit_url", managePermitUrl);
        params.put("auth_capital", authCapital);
        params.put("manager_same", managerSame);
        params.put("manager", manager);
        params.put("manager_card", managerCard);
        params.put("manager_card_type", managerCardType);
        params.put("manager_card_front_url", managerCardFrontUrl);
        params.put("manager_card_back_url", managerCardBackUrl);
        params.put("manager_card_start_time", managerCardStartTime);
        params.put("manager_card_end_time", managerCardEndTime);
        params.put("benefit_same", benefitSame);
        params.put("benefit", benefit);
        params.put("benefit_card", benefitCard);
        params.put("benefit_card_type", benefitCardType);
        params.put("benefit_card_front_url", benefitCardFrontUrl);
        params.put("benefit_card_back_url", benefitCardBackUrl);
        params.put("benefit_start_time", benefitStartTime);
        params.put("benefit_end_time", benefitEndTime);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PAY_ACCOUNT_CREATE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public PaymentAccount getAccountAuditStatus(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_ACCOUNT_AUDIT_STATUS, params);

        SmartAppResult<PaymentAccount> result =
                JSONUtil.toBean(response, new TypeReference<SmartAppResult<PaymentAccount>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void submitDevelopConfig(String accessToken, String tpPublicKey, String payNotifyUrl, String refundAuditUrl,
                                    String refundSuccUrl) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("tp_public_key", tpPublicKey);
        params.put("pay_notify_url", payNotifyUrl);
        params.put("refund_audit_url", refundAuditUrl);
        params.put("refund_succ_url", refundSuccUrl);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PAY_DEVELOP_CONFIG_SUBMIT, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void createPaymentService(String accessToken, String appName, String servicePhone, String bankAccount,
                                     String bankCard, String bankName, String bankBranch, String openProvince,
                                     String openCity, Integer paymentDays, Integer commissionRate, Long poolCashPledge,
                                     Long dayMaxFrozenAmount, String bankPhoneNumber)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_name", appName);
        params.put("service_phone", servicePhone);
        params.put("bank_account", bankAccount);
        params.put("bank_card", bankCard);
        params.put("bank_name", bankName);
        params.put("bank_branch", bankBranch);
        params.put("open_province", openProvince);
        params.put("open_city", openCity);
        params.put("payment_days", paymentDays);
        params.put("commission_rate", commissionRate);
        params.put("pool_cash_pledge", poolCashPledge);
        params.put("day_max_frozen_amount", dayMaxFrozenAmount);
        params.put("bank_phone_number", bankPhoneNumber);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PAY_PAYMENT_SERVICE_CREATE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public PaymentServiceVO getPaymentServiceAuditStatus(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_AUDIT_STATUS, params);

        SmartAppResult<PaymentServiceVO> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PaymentServiceVO>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public void updatePaymentService(String accessToken, String appName, String servicePhone, Long poolCashPledge)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_name", appName);
        params.put("service_phone", servicePhone);
        params.put("pool_cash_pledge", poolCashPledge);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PAY_PAYMENT_SERVICE_UPDATE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public void updateBindPaymentService(String accessToken, String appName, String servicePhone, String bankAccount,
                                         String bankCard, String bankName, String bankBranch, String openProvince,
                                         String openCity, Integer paymentDays, Integer commissionRate,
                                         Long poolCashPledge, Long dayMaxFrozenAmount, String bankPhoneNumber)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("app_name", appName);
        params.put("service_phone", servicePhone);
        params.put("bank_account", bankAccount);
        params.put("bank_card", bankCard);
        params.put("bank_name", bankName);
        params.put("bank_branch", bankBranch);
        params.put("open_province", openProvince);
        params.put("open_city", openCity);
        params.put("payment_days", paymentDays);
        params.put("commission_rate", commissionRate);
        params.put("pool_cash_pledge", poolCashPledge);
        params.put("day_max_frozen_amount", dayMaxFrozenAmount);
        params.put("bank_phone_number", bankPhoneNumber);
        String response = SmartAppHttpUtil.sendHttpPost(TP_PAY_PAYMENT_SERVICE_UPDATE_BIND_SERVICE, params);

        SmartAppResult<Void> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Void>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
    }

    @Override
    public PaymentServiceClient getBindService(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_GET_BIND_SERVICE, params);

        SmartAppResult<PaymentServiceClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<PaymentServiceClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<TradeIndustry> getTradeIndustryList(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_TP_GET_TRADE_INDUSTRY_LIST, params);

        SmartAppResult<List<TradeIndustry>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<TradeIndustry>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public OrderListClient getOrderList(String accessToken, String status, Long startTime, Long endTime,
                                        Long currentPage, Long pageSize)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("status", status);
        params.put("start_time", startTime);
        params.put("end_time", endTime);
        params.put("current_page", currentPage);
        params.put("page_size", pageSize);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_ORDER_LIST, params);

        SmartAppResult<OrderListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<OrderListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public FinanceBalanceListClient getFinanceBalance(String accessToken, Long currentPage, Long pageSize,
                                                      String startTime, String endTime)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("current_page", currentPage);
        params.put("page_size", pageSize);
        params.put("start_time", startTime);
        params.put("end_time", endTime);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FINANCE_BALANCE, params);

        SmartAppResult<FinanceBalanceListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<FinanceBalanceListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public FinanceBalanceIncomeDetailListClient getFinanceBalanceIncomeDetail(String accessToken, Long currentPage,
                                                                              Long pageSize, String startTime)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("current_page", currentPage);
        params.put("page_size", pageSize);
        params.put("start_time", startTime);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FINANCE_BALANCE_INCOME_DETAIL, params);

        SmartAppResult<FinanceBalanceIncomeDetailListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<FinanceBalanceIncomeDetailListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public FinanceBalanceOtherDetailListClient getFinanceBalanceOtherDetail(String accessToken, Long currentPage,
                                                                            Long pageSize, String startTime,
                                                                            String endTime)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("current_page", currentPage);
        params.put("page_size", pageSize);
        params.put("start_time", startTime);
        params.put("end_time", endTime);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FINANCE_BALANCE_OTHER_DETAIL, params);

        SmartAppResult<FinanceBalanceOtherDetailListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<FinanceBalanceOtherDetailListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public FinanceExpenseListClient getFinanceExpenseList(String accessToken, Long currentPage, Long pageSize,
                                                          String startTime, String endTime)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("current_page", currentPage);
        params.put("page_size", pageSize);
        params.put("start_time", startTime);
        params.put("end_time", endTime);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FINANCE_EXPENSE, params);

        SmartAppResult<FinanceExpenseListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<FinanceExpenseListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public FinanceExpensePayDetailListClient getFinanceExpensePayDetail(String accessToken, Long taskId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("task_id", taskId);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FINANCE_EXPENSE_PAY_DETAIL, params);

        SmartAppResult<FinanceExpensePayDetailListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<FinanceExpensePayDetailListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public TpOrderClient findByTpOrderId(String accessToken, String pmAppKey, String tpOrderId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("pmAppKey", pmAppKey);
        params.put("tpOrderId", tpOrderId);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FIND_BY_TP_ORDER_ID, params);

        SmartAppResult<TpOrderClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<TpOrderClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public Boolean cancelOrder(String accessToken, String pmAppKey, String orderId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("pmAppKey", pmAppKey);
        params.put("orderId", orderId);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_CANCEL_ORDER, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response, new TypeReference<SmartAppResult<Boolean>>() {
        }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public ApplyOrderRefundResponseClient applyOrderRefund(String accessToken, String pmAppKey,
                                                           ApplyOrderRefundClient applyOrderRefundClient)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("pmAppKey", pmAppKey);
        if (applyOrderRefundClient == null) {
            throw new SmartAppErrorException(SmartAppErrorCode.ERRNO_PARAM_INVALID.getCode(),
                    SmartAppErrorCode.ERRNO_PARAM_INVALID.getMsg());
        }
        params.put("applyRefundMoney", applyOrderRefundClient.getApplyRefundMoney());
        params.put("bizRefundBatchId", applyOrderRefundClient.getBizRefundBatchId());
        params.put("isSkipAudit", applyOrderRefundClient.getIsSkipAudit());
        params.put("orderId", applyOrderRefundClient.getOrderId());
        params.put("refundReason", applyOrderRefundClient.getRefundReason());
        params.put("refundType", applyOrderRefundClient.getRefundType());
        params.put("tpOrderId", applyOrderRefundClient.getTpOrderId());
        params.put("userId", applyOrderRefundClient.getUserId());
        params.put("refundNotifyUrl", applyOrderRefundClient.getRefundNotifyUrl());
        if (applyOrderRefundClient.getDealVos() != null) {
            params.put("dealVos", applyOrderRefundClient.getDealVos());
        }
        String response = SmartAppHttpUtil.sendHttpPost(TP_PAY_PAYMENT_SERVICE_APPLY_ORDER_REFUND, params);

        SmartAppResult<ApplyOrderRefundResponseClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<ApplyOrderRefundResponseClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public List<OrderRefundDetailClient> findOrderRefund(String accessToken, String pmAppKey, String tpOrderId,
                                                         Long userId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("pmAppKey", pmAppKey);
        params.put("tpOrderId", tpOrderId);
        params.put("userId", userId);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_FIND_ORDER_REFUND, params);

        SmartAppResult<List<OrderRefundDetailClient>> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<List<OrderRefundDetailClient>>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public BillListClient orderBill(String accessToken, String billTime, String pmAppKey)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("billTime", billTime);
        params.put("pmAppKey", pmAppKey);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_ORDER_BILL, params);

        SmartAppResult<BillListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BillListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public BillListClient capitaBill(String accessToken, String billTime, String pmAppKey)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("billTime", billTime);
        params.put("pmAppKey", pmAppKey);
        String response = SmartAppHttpUtil.sendHttpGet(TP_PAY_PAYMENT_SERVICE_CAPITA_BILL, params);

        SmartAppResult<BillListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BillListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
