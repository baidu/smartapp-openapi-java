package com.baidu.mapp.developer;

import com.baidu.mapp.developer.api.ContentSecurityService;
import com.baidu.mapp.developer.api.CouponService;
import com.baidu.mapp.developer.api.InteractService;
import com.baidu.mapp.developer.api.LoginService;
import com.baidu.mapp.developer.api.OrderService;
import com.baidu.mapp.developer.api.PaymentService;
import com.baidu.mapp.developer.api.QrCodeService;
import com.baidu.mapp.developer.api.ResourcesService;
import com.baidu.mapp.developer.api.RiskControlService;
import com.baidu.mapp.developer.api.TemplateMessageService;
import com.baidu.mapp.developer.api.impl.ContentSecurityServiceImpl;
import com.baidu.mapp.developer.api.impl.CouponServiceImpl;
import com.baidu.mapp.developer.api.impl.InteractServiceImpl;
import com.baidu.mapp.developer.api.impl.LoginServiceImpl;
import com.baidu.mapp.developer.api.impl.OrderServiceImpl;
import com.baidu.mapp.developer.api.impl.PaymentServiceImpl;
import com.baidu.mapp.developer.api.impl.QrCodeServiceImpl;
import com.baidu.mapp.developer.api.impl.ResourcesServiceImpl;
import com.baidu.mapp.developer.api.impl.RiskControlServiceImpl;
import com.baidu.mapp.developer.api.impl.TemplateMessageServiceImpl;

import lombok.Data;

/**
 * @description: // TODO
 * @author: chenhaonan02
 * @create: 2021-09-27 17:19
 **/
@Data
public class SmartAppClient {
    private LoginService loginService = LoginServiceImpl.getInstance();
    private ResourcesService resourcesService = ResourcesServiceImpl.getInstance();
    private RiskControlService riskControlService = RiskControlServiceImpl.getInstance();
    private OrderService orderService = OrderServiceImpl.getInstance();
    private QrCodeService qrCodeService = QrCodeServiceImpl.getInstance();
    private InteractService interactService = InteractServiceImpl.getInstance();
    private ContentSecurityService contentSecurityService = ContentSecurityServiceImpl.getInstance();
    private CouponService couponService = CouponServiceImpl.getInstance();
    private TemplateMessageService templateMessageService = TemplateMessageServiceImpl.getInstance();
    private PaymentService paymentService = PaymentServiceImpl.getInstance();
}
