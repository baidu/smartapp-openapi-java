package com.baidu.mapp.developer.api;

import java.util.List;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.developer.bean.payment.ApplyOrderRefundClient;
import com.baidu.mapp.developer.bean.payment.ApplyOrderRefundResponseClient;
import com.baidu.mapp.developer.bean.payment.BillListClient;
import com.baidu.mapp.developer.bean.payment.OrderRefundDetailClient;
import com.baidu.mapp.developer.bean.payment.TpOrderClient;

/**
 * @description: 支付服务接口
 * @author: chenhaonan02
 * @create: 2021-11-10 21:02
 **/
public interface PaymentService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "PaymentService";

    /**
     * 查询订单
     */
    String PAY_PAYMENT_SERVICE_FIND_BY_TP_ORDER_ID = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/findByTpOrderId";
    /**
     * 关闭订单
     */
    String PAY_PAYMENT_SERVICE_CANCEL_ORDER = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/cancelOrder";
    /**
     * 申请退款
     */
    String PAY_PAYMENT_SERVICE_APPLY_ORDER_REFUND = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/applyOrderRefund";
    /**
     * 查询退款
     */
    String PAY_PAYMENT_SERVICE_FIND_ORDER_REFUND = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice"
            + "/findOrderRefund";
    /**
     * 下载订单对账单
     */
    String PAY_PAYMENT_SERVICE_ORDER_BILL = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/orderBill";
    /**
     * 下载资金账单
     */
    String PAY_PAYMENT_SERVICE_CAPITA_BILL = SmartAppConstants.OPEN_API_SMART_APP_URL + "pay/paymentservice/capitaBill";

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
    List<OrderRefundDetailClient> findOrderRefund(String accessToken, String pmAppKey, String tpOrderId, Long userId)
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
