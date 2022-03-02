package com.baidu.mapp.developer.api.impl;

import java.util.List;
import java.util.Map;

import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.common.enums.SmartAppErrorCode;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.common.validator.BaiduAssert;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.PaymentService;
import com.baidu.mapp.developer.bean.payment.ApplyOrderRefundClient;
import com.baidu.mapp.developer.bean.payment.ApplyOrderRefundResponseClient;
import com.baidu.mapp.developer.bean.payment.BillListClient;
import com.baidu.mapp.developer.bean.payment.OrderRefundDetailClient;
import com.baidu.mapp.developer.bean.payment.TpOrderClient;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * @description: 支付服务接口实现类
 * @author: chenhaonan02
 * @create: 2022-01-20 10:32
 **/
public class PaymentServiceImpl extends BaseService implements PaymentService {

    private static PaymentService paymentService;

    public static PaymentService getInstance() {
        if (paymentService == null) {
            paymentService = ProxyUtil.proxy(new PaymentServiceImpl(), TimeIntervalAspect.class);
        }
        return paymentService;
    }

    @Override
    public TpOrderClient findByTpOrderId(String accessToken, String pmAppKey, String tpOrderId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("pmAppKey", pmAppKey);
        params.put("tpOrderId", tpOrderId);
        String response = SmartAppHttpUtil.sendHttpGet(PAY_PAYMENT_SERVICE_FIND_BY_TP_ORDER_ID, params);

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
        String response = SmartAppHttpUtil.sendHttpGet(PAY_PAYMENT_SERVICE_CANCEL_ORDER, params);

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
        String response = SmartAppHttpUtil.sendHttpPost(PAY_PAYMENT_SERVICE_APPLY_ORDER_REFUND, params);

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
        String response = SmartAppHttpUtil.sendHttpGet(PAY_PAYMENT_SERVICE_FIND_ORDER_REFUND, params);

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
        String response = SmartAppHttpUtil.sendHttpGet(PAY_PAYMENT_SERVICE_ORDER_BILL, params);

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
        String response = SmartAppHttpUtil.sendHttpGet(PAY_PAYMENT_SERVICE_CAPITA_BILL, params);

        SmartAppResult<BillListClient> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BillListClient>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}