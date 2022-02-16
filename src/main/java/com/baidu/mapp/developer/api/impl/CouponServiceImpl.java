package com.baidu.mapp.developer.api.impl;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baidu.mapp.developer.api.BaseService;
import com.baidu.mapp.developer.api.CouponService;
import com.baidu.mapp.common.SmartAppResult;
import com.baidu.mapp.developer.bean.copuon.BannerInfo;
import com.baidu.mapp.developer.bean.copuon.BaseInfo;
import com.baidu.mapp.developer.bean.copuon.BatchGetCouponResult;
import com.baidu.mapp.developer.bean.copuon.BatchUploadCouponCodeResult;
import com.baidu.mapp.developer.bean.copuon.CouponData;
import com.baidu.mapp.developer.bean.copuon.CouponId;
import com.baidu.mapp.developer.bean.copuon.CouponTakeId;
import com.baidu.mapp.developer.bean.copuon.UploadCouponImageResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;
import com.baidu.mapp.util.SmartAppHttpUtil;
import com.baidu.mapp.util.TimeIntervalAspect;
import com.baidu.mapp.common.validator.BaiduAssert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CouponServiceImpl extends BaseService implements CouponService {
    private static CouponService couponService;

    public static CouponService getInstance() {
        if (couponService == null) {
            couponService = ProxyUtil.proxy(new CouponServiceImpl(), TimeIntervalAspect.class);
        }
        return couponService;
    }

    @Override
    public CouponId createCoupon(String accessToken, String couponType, int leastCost, int reduceCost,
                                 String discount, BaseInfo baseInfo, String description,
                                 String callbackUrl) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("couponType", couponType);
        bodyMap.put("leastCost", leastCost);
        bodyMap.put("reduceCost", reduceCost);
        bodyMap.put("discount", discount);
        bodyMap.put("baseInfo", baseInfo);
        bodyMap.put("description", description);
        bodyMap.put("callbackUrl", callbackUrl);

        String body = JSONUtil.toJsonStr(bodyMap);
        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(CREATE_COUPON, params, body);
        SmartAppResult<CouponId> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CouponId>>() {
                }.getType(), true);


        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public BatchUploadCouponCodeResult batchUploadCouponCode(String accessToken, String couponId, String couponCodes)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("couponId", couponId);
        params.put("couponCodes", couponCodes);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(BATCH_UPLOAD_COUPON_CODE, params);

        SmartAppResult<BatchUploadCouponCodeResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BatchUploadCouponCodeResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public UploadCouponImageResult uploadCouponImage(String accessToken, String file) throws SmartAppErrorException,
            OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken) ;
        params.put("file", new File(file));

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(UPLOAD_COUPON_IMAGE, params);
        SmartAppResult<UploadCouponImageResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<UploadCouponImageResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public CouponId addCouponBanner(String accessToken, String couponId,
                                    String picUrl, String title, String appRedirectPath)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("couponId", couponId);
        bodyMap.put("picUrl", picUrl);
        bodyMap.put("title", title);
        bodyMap.put("appRedirectPath", appRedirectPath);

        String body = JSONUtil.toJsonStr(bodyMap);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(ADD_COUPON_BANNER,  params, body);

        SmartAppResult<CouponId> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CouponId>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean updateCouponBanner(String accessToken, String couponId, String picUrl, String title,
                                      String appRedirectPath, int bannerId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("couponId", couponId);
        bodyMap.put("picUrl", picUrl);
        bodyMap.put("title", title);
        bodyMap.put("appRedirectPath", appRedirectPath);
        bodyMap.put("bannerId", bannerId);

        String body = JSONUtil.toJsonStr(bodyMap);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(UPDATE_COUPON_BANNER, params, body);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean deleteCouponBanner(String accessToken, String couponId, long bannerId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);

        params.put("couponId", couponId);
        params.put("bannerId", bannerId);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DELETE_COUPON_BANNER, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public BannerInfo[] getCouponBanner(String accessToken, String couponId, String bannerIds)
            throws SmartAppErrorException, OpenAPIErrorException {

        Map<String, Object> params = getRequestMapper(accessToken);

        params.put("couponId", couponId);
        params.put("bannerIds", bannerIds);

        String response = null;

        response = SmartAppHttpUtil.sendHttpGet(GET_COUPON_BANNNER, params);
        SmartAppResult<BannerInfo[]> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BannerInfo[]>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public BatchGetCouponResult batchGetCouponBanner(String accessToken) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = null;
        response = SmartAppHttpUtil.sendHttpGet(BATCHGET_COUPON_BANNER, params);
        SmartAppResult<BatchGetCouponResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BatchGetCouponResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public CouponTakeId sendCoupon(String accessToken, String couponId, String openId,
                                   String uniqueSendingIdentity) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("couponId", couponId);
        params.put("openId", openId);
        params.put("uniqueSendingIdentity", uniqueSendingIdentity);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(SEND_COUPON, params);

        SmartAppResult<CouponTakeId> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CouponTakeId>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean consumeCouponCode(String accessToken, String couponId,
                                     String openId, long couponTakeId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("couponId", couponId);
        params.put("openId", openId);
        params.put("couponTakeId", couponTakeId);

        String response = null;

        response = SmartAppHttpUtil.sendHttpPost(CONSUME_COUPON_CODE, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean returnCoupon(String accessToken, String couponId, String openId,
                                long couponTakeId) throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("couponId", couponId);
        params.put("openId", openId);
        params.put("couponTakeId", couponTakeId);

        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(RETURN_COUPON, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public CouponData getCoupon(String accessToken, String couponId) throws SmartAppErrorException,
            OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("couponId", couponId);

        String response = null;

        response = SmartAppHttpUtil.sendHttpGet(GET_COUPON, params);
        SmartAppResult<CouponData> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<CouponData>>() {
                }.getType(), true);

        System.out.println(response);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public BatchGetCouponResult batchGetCoupon(String accessToken)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        String response = null;

        response = SmartAppHttpUtil.sendHttpGet(BATCHGET_COUPON, params);
        SmartAppResult<BatchGetCouponResult> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<BatchGetCouponResult>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }

    @Override
    public boolean deleteCoupon(String accessToken, String couponId)
            throws SmartAppErrorException, OpenAPIErrorException {
        Map<String, Object> params = getRequestMapper(accessToken);
        params.put("couponId", couponId);
        String response = null;
        response = SmartAppHttpUtil.sendHttpPost(DELETE_COPUPON, params);

        SmartAppResult<Boolean> result = JSONUtil.toBean(response,
                new TypeReference<SmartAppResult<Boolean>>() {
                }.getType(), true);

        BaiduAssert.error(result, response);
        return result.getData();
    }
}
