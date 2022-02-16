package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
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

public interface CouponService {

    /**
     *选择卡券类型并创建卡券
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_type/
     */
    String CREATE_COUPON = SmartAppConstants.OPEN_API_SMART_APP_URL + "smartapp/v1.0/coupon/create";

    /**
     * 上传 Code 码
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_code/
     */
    String BATCH_UPLOAD_COUPON_CODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/code/batchUpload";

    /**
     * 上传卡券 Banner 图
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_banner/
     */
    String UPLOAD_COUPON_IMAGE = SmartAppConstants.OPEN_API_SMART_APP_FILE_URL + "v1.0/coupon/upload/image";

    /**
     * Banner 创建接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_banner
     +/#banner-%E5%88%9B%E5%BB%BA%E6%8E%A5%E5%8F%A3
     */
    String ADD_COUPON_BANNER = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/banner/add";

    /**
     * Banner 修改接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_banner
     +/#banner-%E4%BF%AE%E6%94%B9%E6%8E%A5%E5%8F%A3
     */
    String UPDATE_COUPON_BANNER = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/banner/update";

    /**
     * Banner 删除接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_banner
     +/#banner-%E5%88%A0%E9%99%A4%E6%8E%A5%E5%8F%A3
     */
    String DELETE_COUPON_BANNER =  SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/banner/delete";

    /**
     * Banner 详情查询接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_banner
     +/#banner-%E8%AF%A6%E6%83%85%E6%9F%A5%E8%AF%A2%E6%8E%A5%E5%8F%A3
     */
    String GET_COUPON_BANNNER = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/banner/get";

    /**
     * Banner 列表批量查询接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_create_banner
     +/#banner-%E5%88%97%E8%A1%A8%E6%89%B9%E9%87%8F%E6%9F%A5%E8%AF%A2%E6%8E%A5%E5%8F%A3
     */
    String BATCHGET_COUPON_BANNER =  SmartAppConstants.OPEN_API_SMART_APP_URL +  "v1.0/coupon/batchGet";

    /**
     *同步至卡券包接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_bag/
     */
    String SEND_COUPON = SmartAppConstants.OPEN_API_SMART_APP_URL +  "v1.0/coupon/send";

    /**
     * 同步核销状态接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_delete/
     */
    String  CONSUME_COUPON_CODE = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/code/consume";

    /**
     * 取消核销接口（卡券退回）
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_delete/
     */
    String RETURN_COUPON = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/return";

    /**
     * 查看卡券详情接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_manage
     */
    String GET_COUPON = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/get";

    /**
     * 批量查询卡券列表接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_manage
     */
    String BATCHGET_COUPON = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/batchGet";

    /**
     * 删除卡券接口
     * https://smartprogram.baidu.com/docs/develop/api/open/coupons_manage
     */
    String DELETE_COPUPON = SmartAppConstants.OPEN_API_SMART_APP_URL + "v1.0/coupon/delete";

    /**
     *
     * @param accessToken
     * @param couponType 卡券类型，当以上卡券类型无法满足时，可使用通用优惠券类型
     * @param leastCost 表示可使用的门槛金额（单位：分），不传默认为 0，即无起用门槛
     * @param reduceCost 代金券专用，表示减免金额（单位：分）
     * @param discount 折扣券专用，表示打折力度（格式为百分比），填 80 就是八折。
     * @param baseInfo 基本的卡券数据，所有卡券通用。
     * @param description 使用须知：卡券使用方法的介绍
     * @param callbackUrl 卡券领取事件推送地址
     * @return couponId
     * @throws SmartAppErrorException
     */
    CouponId createCoupon(String accessToken, String couponType, int leastCost, int reduceCost, String discount,
                          BaseInfo baseInfo, String description, String callbackUrl)
            throws SmartAppErrorException, OpenAPIErrorException;


    /**
     * 上传 Code 码
     * @param accessToken
     * @param couponId 卡券 ID
     * @param couponCodes 卡券 Code 码列表
     * @return
     * @throws SmartAppErrorException
     */
    BatchUploadCouponCodeResult batchUploadCouponCode(String accessToken, String couponId, String couponCodes)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 上传卡券 Banner 图
     * @param  accessToken
     * @param file 上传的卡券图
     * @return
     */
    UploadCouponImageResult uploadCouponImage(String accessToken, String file)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * Banner 创建接口
     * @param accessToken
     * @param couponId 卡券 ID
     * @param picUrl 卡券 banner 图片
     * @param title 卡券 banner 图标题
     * @param appRedirectPath banner 图跳转的小程序页面路径
     * @throws SmartAppErrorException
     */
    CouponId addCouponBanner(String accessToken, String  couponId, String picUrl, String title, String appRedirectPath)
            throws SmartAppErrorException, OpenAPIErrorException;


    /**
     * Banner 修改接口
     * @param accessToken
     * @param couponId 卡券 ID
     * @param picUrl 卡券 banner 图片
     * @param title 卡券 banner 图标题
     * @param appRedirectPath banner 图跳转的小程序页面路径
     * @param bannerId 卡券 banner 记录 id
     * @return
     * @throws SmartAppErrorException
     */
    boolean updateCouponBanner(String accessToken, String couponId, String picUrl, String title,
                               String appRedirectPath, int bannerId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * Banner 删除接口
     * @param accessToken
     * @param couponId
     * @param bannerId
     * @return
     * @throws SmartAppErrorException
     */
    boolean deleteCouponBanner(String accessToken, String couponId, long bannerId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * Banner 详情查询接口
     * @param accessToken
     * @param couponId 卡券 ID
     * @param bannerIds 卡券 banner 记录 id
     * @return
     * @throws SmartAppErrorException
     */
    BannerInfo[] getCouponBanner(String accessToken, String couponId, String bannerIds)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * Banner 列表批量查询接口
     * @param accessToken
     * @return
     * @throws SmartAppErrorException
     */
    BatchGetCouponResult batchGetCouponBanner(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;


    /**
     * 同步至卡券包接口
     * @param accessToken
     * @param couponId 卡券 ID
     * @param openId 用户 ID
     * @param uniqueSendingIdentity 请求唯一标识 uuid
     * @return
     * @throws SmartAppErrorException
     */
    CouponTakeId sendCoupon(String accessToken, String couponId, String openId, String uniqueSendingIdentity)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 同步核销状态接口
     * @param accessToken
     * @param couponId 卡券 ID
     * @param openId 用户 ID
     * @param couponTakeId 百度分配的用户领取 id
     * @return
     * @throws SmartAppErrorException
     */
    boolean consumeCouponCode(String accessToken, String couponId, String openId, long couponTakeId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     *取消核销接口（卡券退回）
     * @param accessToken
     * @param couponId
     * @param openId
     * @param couponTakeId
     * @return
     * @throws SmartAppErrorException
     */
    boolean returnCoupon(String accessToken, String couponId, String openId, long couponTakeId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查看卡券详情接口
     * @param accessToken
     * @param couponId
     * @return
     */
    CouponData getCoupon(String accessToken, String couponId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 批量查询卡券列表接口
     * @return
     */
    BatchGetCouponResult batchGetCoupon(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 删除卡券接口
     * @param accessToken
     * @param couponId
     * @return
     * @throws SmartAppErrorException
     */
    boolean deleteCoupon(String accessToken, String couponId) throws SmartAppErrorException, OpenAPIErrorException;
}
