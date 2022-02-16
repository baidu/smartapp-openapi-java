package com.baidu.mapp.tp;

import com.baidu.mapp.tp.api.AppGradeService;
import com.baidu.mapp.tp.api.AppLoginService;
import com.baidu.mapp.tp.api.AppService;
import com.baidu.mapp.tp.api.AuthenticityCertificationService;
import com.baidu.mapp.tp.api.AuthorizationProcessService;
import com.baidu.mapp.tp.api.CustomerMessageService;
import com.baidu.mapp.tp.api.DataStatisticsService;
import com.baidu.mapp.tp.api.FeedService;
import com.baidu.mapp.tp.api.MobileService;
import com.baidu.mapp.tp.api.NaturalSearchService;
import com.baidu.mapp.tp.api.OfflineViolationService;
import com.baidu.mapp.tp.api.PackageManagementService;
import com.baidu.mapp.tp.api.PaymentService;
import com.baidu.mapp.tp.api.PerformanceOptimizationService;
import com.baidu.mapp.tp.api.PushMsgService;
import com.baidu.mapp.tp.api.TemplateManagementService;
import com.baidu.mapp.tp.api.ThirdPartyDomainService;
import com.baidu.mapp.tp.api.UploadPhotoService;
import com.baidu.mapp.tp.api.impl.AppGradeServiceImpl;
import com.baidu.mapp.tp.api.impl.AppLoginServiceImpl;
import com.baidu.mapp.tp.api.impl.AppServiceImpl;
import com.baidu.mapp.tp.api.impl.AuthenticityCertificationServiceImpl;
import com.baidu.mapp.tp.api.impl.AuthorizationProcessServiceImpl;
import com.baidu.mapp.tp.api.impl.CustomerMessageServiceImpl;
import com.baidu.mapp.tp.api.impl.DataStatisticsServiceImpl;
import com.baidu.mapp.tp.api.impl.FeedServiceImpl;
import com.baidu.mapp.tp.api.impl.MobileServiceImpl;
import com.baidu.mapp.tp.api.impl.NaturalSearchServiceImpl;
import com.baidu.mapp.tp.api.impl.OfflineViolationServiceImpl;
import com.baidu.mapp.tp.api.impl.PackageManagementServiceImpl;
import com.baidu.mapp.tp.api.impl.PaymentServiceImpl;
import com.baidu.mapp.tp.api.impl.PerformanceOptimizationServiceImpl;
import com.baidu.mapp.tp.api.impl.PushMsgServiceImpl;
import com.baidu.mapp.tp.api.impl.TemplateManagementServiceImpl;
import com.baidu.mapp.tp.api.impl.ThirdPartyDomainServiceImpl;
import com.baidu.mapp.tp.api.impl.UploadPhotoServiceImpl;

import lombok.Data;

/**
 * @description: // TODO
 * @author: chenhaonan02
 * @create: 2021-09-27 17:19
 **/
@Data
public class SmartAppThirdPartyClient {
    private AppGradeService appGradeService = AppGradeServiceImpl.getInstance();
    private AppLoginService appLoginService = AppLoginServiceImpl.getInstance();
    private AppService appService = AppServiceImpl.getInstance();
    private AuthenticityCertificationService authenticityCertificationService = AuthenticityCertificationServiceImpl
            .getInstance();
    private AuthorizationProcessService authorizationProcessService = AuthorizationProcessServiceImpl.getInstance();
    private CustomerMessageService customerMessageService = CustomerMessageServiceImpl.getInstance();
    private DataStatisticsService dataStatisticsService = DataStatisticsServiceImpl.getInstance();
    private FeedService feedService = FeedServiceImpl.getInstance();
    private MobileService mobileService = MobileServiceImpl.getInstance();
    private NaturalSearchService naturalSearchService = NaturalSearchServiceImpl.getInstance();
    private OfflineViolationService offlineViolationService = OfflineViolationServiceImpl.getInstance();
    private com.baidu.mapp.tp.api.OrderService orderService = com.baidu.mapp.tp.api.impl.OrderServiceImpl.getInstance();
    private PackageManagementService packageManagementService = PackageManagementServiceImpl.getInstance();
    private PaymentService paymentService = PaymentServiceImpl.getInstance();
    private PerformanceOptimizationService performanceOptimizationService = PerformanceOptimizationServiceImpl
            .getInstance();
    private PushMsgService pushMsgService = PushMsgServiceImpl.getInstance();
    private TemplateManagementService templateManagementService = TemplateManagementServiceImpl.getInstance();
    private com.baidu.mapp.tp.api.TemplateMessageService
            templateMessageService = com.baidu.mapp.tp.api.impl.TemplateMessageServiceImpl.getInstance();
    private ThirdPartyDomainService thirdPartyDomainService = ThirdPartyDomainServiceImpl.getInstance();
    private UploadPhotoService uploadPhotoService = UploadPhotoServiceImpl.getInstance();
}
