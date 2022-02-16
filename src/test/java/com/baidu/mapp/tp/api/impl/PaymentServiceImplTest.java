package com.baidu.mapp.tp.api.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baidu.mapp.tp.bean.payment.FinanceBalanceClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceIncomeDetailClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceIncomeDetailListClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceListClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceOtherDetailClient;
import com.baidu.mapp.tp.bean.payment.FinanceBalanceOtherDetailListClient;
import com.baidu.mapp.tp.bean.payment.FinanceExpenseClient;
import com.baidu.mapp.tp.bean.payment.FinanceExpenseListClient;
import com.baidu.mapp.tp.bean.payment.FinanceExpensePayDetailClient;
import com.baidu.mapp.tp.bean.payment.FinanceExpensePayDetailListClient;
import com.baidu.mapp.tp.bean.payment.OrderClient;
import com.baidu.mapp.tp.bean.payment.OrderListClient;
import com.baidu.mapp.tp.bean.payment.PaymentAccount;
import com.baidu.mapp.tp.bean.payment.PaymentServiceClient;
import com.baidu.mapp.tp.bean.payment.PaymentServiceDictClient;
import com.baidu.mapp.tp.bean.payment.PaymentServiceVO;
import com.baidu.mapp.tp.bean.payment.TradeIndustry;
import com.baidu.mapp.util.SmartAppHttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SmartAppHttpUtil.class)
public class PaymentServiceImplTest {

    @InjectMocks
    PaymentServiceImpl paymentServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPaymentServiceDict() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PaymentServiceDictClient result = paymentServiceImpl.getPaymentServiceDict("appAccessToken");
        Assert.assertNull(result);
    }

    @Test
    public void testPayAccountRegister() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        paymentServiceImpl.payAccountRegister("accessToken", "businessScope", "businessProvince", "businessCity",
                "businessDetailAddress", "legalPerson", "legalId", "idCardFrontUrl", "idCardBackUrl",
                "legalCardStartTime", "legalCardEndTime", "licenseStartTime", "licenseEndTime", 0,
                "managePermitUrl", 1L, 0, "manager", "managerCard", "managerCardType",
                "managerCardFrontUrl", "managerCardBackUrl", "managerCardStartTime", "managerCardEndTime",
                0, "benefit", "benefitCard", "benefitCardType", "benefitCardFrontUrl",
                "benefitCardBackUrl", "benefitStartTime", "benefitEndTime");
    }

    @Test
    public void testGetAccountAuditStatus() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"status\":4,\n"
                + "        \"verify_message\":\"审核通过\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setStatus(4);
        paymentAccount.setVerifyMessage("审核通过");

        PaymentAccount result = paymentServiceImpl.getAccountAuditStatus("appAccessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(paymentAccount, result);
    }

    @Test
    public void testSubmitDevelopConfig() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        paymentServiceImpl.submitDevelopConfig("accessToken", "tpPublicKey", "payNotifyUrl", "refundAuditUrl",
                "refundSuccUrl");
    }

    @Test
    public void testCreatePaymentService() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        paymentServiceImpl.createPaymentService("accessToken", "appName", "servicePhone", "bankAccount", "bankCard",
                "bankName", "bankBranch", "openProvince", "openCity", 0, 0,
                1L, 1L, "bankPhoneNumber");
    }

    @Test
    public void testGetPaymentServiceAuditStatus() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"status\":2,\n"
                + "        \"verify_message\":\"审核通过\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PaymentServiceVO paymentServiceVO = new PaymentServiceVO();
        paymentServiceVO.setStatus(2);
        paymentServiceVO.setVerifyMessage("审核通过");

        PaymentServiceVO result = paymentServiceImpl.getPaymentServiceAuditStatus("appAccessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(paymentServiceVO, result);
    }

    @Test
    public void testUpdatePaymentService() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        paymentServiceImpl.updatePaymentService("accessToken", "appName", "servicePhone", 1L);
    }

    @Test
    public void testUpdateBindPaymentService() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpPost(anyString(), any())).thenReturn(response);

        paymentServiceImpl.updateBindPaymentService("accessToken", "appName", "servicePhone", "bankAccount", "bankCard",
                "bankName", "bankBranch", "openProvince", "openCity", 0, 0,
                1L, 1L, "bankPhoneNumber");
    }

    @Test
    public void testGetBindService() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"pm_app_id\":10896,\n"
                + "        \"app_name\":\"测试\",\n"
                + "        \"pm_app_key\":\"XXX\",\n"
                + "        \"platform_public_key\":\"XXX\",\n"
                + "        \"deal_id\":\"1292243105\",\n"
                + "        \"service_phone\":\"1351431XXXX\",\n"
                + "        \"bank_account\":\"北京百度网讯科技有限公司\",\n"
                + "        \"bank_card\":\"110902160610510\",\n"
                + "        \"bank_name\":\"招商银行\",\n"
                + "        \"bank_branch\":\"招商银行股份有限公司北京双榆树支行\",\n"
                + "        \"open_province\":\"北京市\",\n"
                + "        \"open_city\":\"海淀区\",\n"
                + "        \"payment_days\":1,\n"
                + "        \"commission_rate\":6,\n"
                + "        \"pool_cash_pledge\":1,\n"
                + "        \"day_max_frozen_amount\":10000,\n"
                + "        \"open_status\":2,\n"
                + "        \"fail_reason\":\"\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        PaymentServiceClient paymentServiceClient = new PaymentServiceClient();
        paymentServiceClient.setPmAppId(10896L);
        paymentServiceClient.setAppName("测试");
        paymentServiceClient.setPmAppKey("XXX");
        paymentServiceClient.setPlatformPublicKey("XXX");
        paymentServiceClient.setDealId("1292243105");
        paymentServiceClient.setServicePhone("1351431XXXX");
        paymentServiceClient.setBankAccount("北京百度网讯科技有限公司");
        paymentServiceClient.setBankCard("110902160610510");
        paymentServiceClient.setBankName("招商银行");
        paymentServiceClient.setBankBranch("招商银行股份有限公司北京双榆树支行");
        paymentServiceClient.setOpenProvince("北京市");
        paymentServiceClient.setOpenCity("海淀区");
        paymentServiceClient.setPaymentDays(1);
        paymentServiceClient.setCommissionRate(6);
        paymentServiceClient.setPoolCashPledge(1L);
        paymentServiceClient.setDayMaxFrozenAmount(10000L);
        paymentServiceClient.setOpenStatus(2);
        paymentServiceClient.setFailReason("");

        PaymentServiceClient result = paymentServiceImpl.getBindService("appAccessToken");
        Assert.assertNotNull(result);
        Assert.assertEquals(paymentServiceClient, result);
    }

    @Test
    public void testGetTradeIndustryList() throws Exception {
        String response = "{\"errno\":0,\"msg\":\"success\"}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        List<TradeIndustry> result = paymentServiceImpl.getTradeIndustryList("appAccessToken");
        Assert.assertNull(result);
    }

    @Test
    public void testGetOrderList() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"total_money\":\"-\",\n"
                + "        \"current_page\":1,\n"
                + "        \"page_size\":10,\n"
                + "        \"total_count\":101,\n"
                + "        \"total_page\":1,\n"
                + "        \"data\":[\n"
                + "            {\n"
                + "                \"id\":\"80048556607063\",\n"
                + "                \"deal_id\":\"2055275011\",\n"
                + "                \"deal_title\":\"sandbox-test-one\",\n"
                + "                \"order_id\":\"80048556607063\",\n"
                + "                \"tp_order_id\":\"TEST345671234\",\n"
                + "                \"phone\":\"未登录用户\",\n"
                + "                \"create_time\":\"2019-05-30 21:37:53\",\n"
                + "                \"update_time\":\"2019-05-30 21:37:53\",\n"
                + "                \"sub_status\":\"1\",\n"
                + "                \"total_money\":\"20\",\n"
                + "                \"pay_money\":\"20\",\n"
                + "                \"segment_refunded_money\":\"null\",\n"
                + "                \"channel\":\"null\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        OrderClient orderClient = new OrderClient();
        orderClient.setId("80048556607063");
        orderClient.setDealId("2055275011");
        orderClient.setDealTitle("sandbox-test-one");
        orderClient.setOrderId("80048556607063");
        orderClient.setTpOrderId("TEST345671234");
        orderClient.setPhone("未登录用户");
        orderClient.setCreateTime("2019-05-30 21:37:53");
        orderClient.setUpdateTime("2019-05-30 21:37:53");
        orderClient.setSubStatus("1");
        orderClient.setTotalMoney("20");
        orderClient.setPayMoney("20");
        orderClient.setSegmentRefundedMoney("null");
        orderClient.setChannel("null");
        List<OrderClient> data = new ArrayList<>();
        data.add(orderClient);

        OrderListClient orderListClient = new OrderListClient();
        orderListClient.setTotalMoney("-");
        orderListClient.setCurrentPage(1L);
        orderListClient.setPageSize(10L);
        orderListClient.setTotalCount(101L);
        orderListClient.setTotalPage(1L);
        orderListClient.setData(data);

        OrderListClient result = paymentServiceImpl.getOrderList("appAccessToken", "all", 1538864820L, 1638864820L,
                1L, 10L);
        Assert.assertNotNull(result);
        Assert.assertEquals(orderListClient, result);
    }

    @Test
    public void testGetFinanceBalance() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"income\":\"0.32\",\n"
                + "        \"period\":1,\n"
                + "        \"data\":[\n"
                + "            {\n"
                + "                \"income\":\"0.02\",\n"
                + "                \"operate_time\":\"2019-06-11\",\n"
                + "                \"adjust_amount\":\"0.00\",\n"
                + "                \"others\":\"0.00\"\n"
                + "            }\n"
                + "        ],\n"
                + "        \"adjustment\":\"0.00\",\n"
                + "        \"free_balance\":\"1.00\",\n"
                + "        \"payment_due\":\"2019-06-13 00:00:00\",\n"
                + "        \"others\":\"-0.02\",\n"
                + "        \"page_size\":10,\n"
                + "        \"total_count\":6,\n"
                + "        \"current_page\":1\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        FinanceBalanceClient financeBalanceClient = new FinanceBalanceClient();
        financeBalanceClient.setIncome("0.02");
        financeBalanceClient.setOperateTime("2019-06-11");
        financeBalanceClient.setAdjustAmount("0.00");
        financeBalanceClient.setOthers("0.00");
        List<FinanceBalanceClient> data = new ArrayList<>();
        data.add(financeBalanceClient);

        FinanceBalanceListClient financeBalanceListClient = new FinanceBalanceListClient();
        financeBalanceListClient.setIncome("0.32");
        financeBalanceListClient.setPeriod(1L);
        financeBalanceListClient.setData(data);
        financeBalanceListClient.setAdjustment("0.00");
        financeBalanceListClient.setFreeBalance("1.00");
        financeBalanceListClient.setPaymentDue("2019-06-13 00:00:00");
        financeBalanceListClient.setOthers("-0.02");
        financeBalanceListClient.setPageSize(10L);
        financeBalanceListClient.setTotalCount(6L);
        financeBalanceListClient.setCurrentPage(1L);

        FinanceBalanceListClient result = paymentServiceImpl
                .getFinanceBalance("appAccessToken", 1L, 10L, "2019-01-02", "2020-02-02");
        Assert.assertNotNull(result);
        Assert.assertEquals(financeBalanceListClient, result);
    }

    @Test
    public void testGetFinanceBalanceIncomeDetail() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"income\":\"0.05\",\n"
                + "        \"quantity\":5,\n"
                + "        \"data\":[\n"
                + "            {\n"
                + "                \"opt_type\":\"使用\",\n"
                + "                \"money\":\"0.01\",\n"
                + "                \"order_id\":26986351846447,\n"
                + "                \"operate_time\":\"2019-03-21 19:07:41\",\n"
                + "                \"third_order_id\":\"ZD1553166089343111661\"\n"
                + "            }\n"
                + "        ],\n"
                + "        \"operate_time\":\"2019-03-21 00:00:00\",\n"
                + "        \"income_amount\":\"0.05\",\n"
                + "        \"page_size\":10,\n"
                + "        \"total_count\":5,\n"
                + "        \"current_page\":1,\n"
                + "        \"refund_amount\":\"0.00\"\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        FinanceBalanceIncomeDetailClient financeBalanceIncomeDetailClient = new FinanceBalanceIncomeDetailClient();
        financeBalanceIncomeDetailClient.setOptType("使用");
        financeBalanceIncomeDetailClient.setMoney("0.01");
        financeBalanceIncomeDetailClient.setOrderId(26986351846447L);
        financeBalanceIncomeDetailClient.setOperateTime("2019-03-21 19:07:41");
        financeBalanceIncomeDetailClient.setThirdOrderId("ZD1553166089343111661");
        List<FinanceBalanceIncomeDetailClient> data = new ArrayList<>();
        data.add(financeBalanceIncomeDetailClient);

        FinanceBalanceIncomeDetailListClient financeBalanceIncomeDetailListClient =
                new FinanceBalanceIncomeDetailListClient();
        financeBalanceIncomeDetailListClient.setIncome("0.05");
        financeBalanceIncomeDetailListClient.setQuantity(5L);
        financeBalanceIncomeDetailListClient.setData(data);
        financeBalanceIncomeDetailListClient.setOperateTime("2019-03-21 00:00:00");
        financeBalanceIncomeDetailListClient.setIncomeAmount("0.05");
        financeBalanceIncomeDetailListClient.setPageSize(10L);
        financeBalanceIncomeDetailListClient.setTotalCount(5L);
        financeBalanceIncomeDetailListClient.setCurrentPage(1L);
        financeBalanceIncomeDetailListClient.setRefundAmount("0.00");

        FinanceBalanceIncomeDetailListClient result = paymentServiceImpl
                .getFinanceBalanceIncomeDetail("appAccessToken", 1L, 10L, "2019-01-02");
        Assert.assertNotNull(result);
        Assert.assertEquals(financeBalanceIncomeDetailListClient, result);
    }

    @Test
    public void testGetFinanceBalanceOtherDetail() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"total_amount\":\"-0.04\",\n"
                + "        \"order_amount\":\"0.69\",\n"
                + "        \"data\":[\n"
                + "            {\n"
                + "                \"opt_type\":\"使用\",\n"
                + "                \"order_id\":80040240090932,\n"
                + "                \"operate_time\":\"2019-05-21 23:59:59\",\n"
                + "                \"ref_money\":\"0.00\",\n"
                + "                \"third_order_id\":\"ZD1558365540190944723\"\n"
                + "            }\n"
                + "            ],\n"
                + "     \"rule_type\":\"{\\\"commisionLadder\\\":\\\"0.00-9,223,372,036,854,775.00,0.60%;\\\","
                + "\\\"marketing\\\":\\\"营销模式\\\",\\\"marketingLadder\\\":\\\"\\\",\\\"fixedCostLadder\\\":\\\"\\\","
                + "\\\"fixedCost\\\":\\\"固定费用\\\",\\\"commision\\\":\\\"分佣模式\\\"}\",\n"
                + "     \"settlement_start_time\":\"2019-05-03 00:00:00\",\n"
                + "     \"settlement_end_time\":\"2019-06-28 00:00:00\"\n"
                + "     }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        FinanceBalanceOtherDetailClient financeBalanceOtherDetailClient = new FinanceBalanceOtherDetailClient();
        financeBalanceOtherDetailClient.setOptType("使用");
        financeBalanceOtherDetailClient.setOrderId(80040240090932L);
        financeBalanceOtherDetailClient.setOperateTime("2019-05-21 23:59:59");
        financeBalanceOtherDetailClient.setRefMoney("0.00");
        financeBalanceOtherDetailClient.setThirdOrderId("ZD1558365540190944723");
        List<FinanceBalanceOtherDetailClient> data = new ArrayList<>();
        data.add(financeBalanceOtherDetailClient);

        FinanceBalanceOtherDetailListClient financeBalanceOtherDetailListClient =
                new FinanceBalanceOtherDetailListClient();
        financeBalanceOtherDetailListClient.setTotalAmount("-0.04");
        financeBalanceOtherDetailListClient.setOrderAmount("0.69");
        financeBalanceOtherDetailListClient.setData(data);
        financeBalanceOtherDetailListClient.setRuleType("{\"commisionLadder\":\"0.00-9,223,372,036,854,775.00,0"
                + ".60%;\",\"marketing\":\"营销模式\",\"marketingLadder\":\"\","
                + "\"fixedCostLadder\":\"\",\"fixedCost\":\"固定费用\",\"commision\":\"分佣模式\"}");
        financeBalanceOtherDetailListClient.setSettlementStartTime("2019-05-03 00:00:00");
        financeBalanceOtherDetailListClient.setSettlementEndTime("2019-06-28 00:00:00");

        FinanceBalanceOtherDetailListClient result = paymentServiceImpl
                .getFinanceBalanceOtherDetail("appAccessToken", 1L, 10L, "2019-01-02", "2020-02-02");
        Assert.assertNotNull(result);
        Assert.assertEquals(financeBalanceOtherDetailListClient, result);
    }

    @Test
    public void testGetFinanceExpenseList() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"expense_count\":5,\n"
                + "        \"data\":[\n"
                + "            {\n"
                + "                \"money\":\"-0.02\",\n"
                + "                \"operate_time\":\"2019-06-12 00:00:00\",\n"
                + "                \"start_time\":\"2019-06-12 00:00:00\",\n"
                + "                \"type_id\":\"自动打款\",\n"
                + "                \"end_time\":\"2019-06-13 00:00:00\",\n"
                + "                \"pay_status\":\"成功\",\n"
                + "                \"task_id\":12688777319\n"
                + "            }\n"
                + "        ],\n"
                + "        \"expense_money\":\"-0.10\",\n"
                + "        \"total_count\":5\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        FinanceExpenseClient financeExpenseClient = new FinanceExpenseClient();
        financeExpenseClient.setMoney("-0.02");
        financeExpenseClient.setOperateTime("2019-06-12 00:00:00");
        financeExpenseClient.setStartTime("2019-06-12 00:00:00");
        financeExpenseClient.setTypeId("自动打款");
        financeExpenseClient.setEndTime("2019-06-13 00:00:00");
        financeExpenseClient.setPayStatus("成功");
        financeExpenseClient.setTaskId(12688777319L);
        List<FinanceExpenseClient> data = new ArrayList<>();
        data.add(financeExpenseClient);

        FinanceExpenseListClient financeExpenseListClient = new FinanceExpenseListClient();
        financeExpenseListClient.setExpenseCount(5L);
        financeExpenseListClient.setData(data);
        financeExpenseListClient.setExpenseMoney("-0.10");
        financeExpenseListClient.setTotalCount(5L);

        FinanceExpenseListClient result = paymentServiceImpl
                .getFinanceExpenseList("accessToken", 1L, 10L, "2019-01-02", "2020-02-02");
        Assert.assertNotNull(result);
        Assert.assertEquals(financeExpenseListClient, result);
    }

    @Test
    public void testGetFinanceExpensePayDetail() throws Exception {
        String response = "{\n"
                + "    \"errno\":0,\n"
                + "    \"msg\":\"success\",\n"
                + "    \"data\":{\n"
                + "        \"data\":[\n"
                + "            {\n"
                + "                \"paid_money\":\"0.05\",\n"
                + "                \"paid_account\":\"621****4964\",\n"
                + "                \"remark\":\"交易成功#SUCCESS\",\n"
                + "                \"receive_user\":\"*若阳\",\n"
                + "                \"payment_status\":\"成功\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}\n";

        // mock 包含静态方法的类
        PowerMockito.mockStatic(SmartAppHttpUtil.class);
        PowerMockito.when(SmartAppHttpUtil.sendHttpGet(anyString(), any())).thenReturn(response);

        FinanceExpensePayDetailClient financeExpensePayDetailClient = new FinanceExpensePayDetailClient();
        financeExpensePayDetailClient.setPaidMoney("0.05");
        financeExpensePayDetailClient.setPaidAccount("621****4964");
        financeExpensePayDetailClient.setRemark("交易成功#SUCCESS");
        financeExpensePayDetailClient.setReceiveUser("*若阳");
        financeExpensePayDetailClient.setPaymentStatus("成功");
        List<FinanceExpensePayDetailClient> data = new ArrayList<>();
        data.add(financeExpensePayDetailClient);

        FinanceExpensePayDetailListClient financeExpensePayDetailListClient = new FinanceExpensePayDetailListClient();
        financeExpensePayDetailListClient.setData(data);

        FinanceExpensePayDetailListClient result = paymentServiceImpl
                .getFinanceExpensePayDetail("accessToken", 1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(financeExpensePayDetailListClient, result);
    }
}