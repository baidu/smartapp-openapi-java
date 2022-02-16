package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.developer.bean.skuresources.BJHMaterial;
import com.baidu.mapp.developer.bean.skuresources.MaterialRueslt;
import com.baidu.mapp.developer.bean.skuresources.Resources;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public interface ResourcesService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "ResourcesService";

    /**
     * 提交 / 修改素材接口，API 实时接口提交方式。
     * https://smartprogram.baidu.com/docs/develop/serverapi/submitsku/
     */
    String SUBMIT_SKU_RESOURCES = SmartAppConstants.OPEN_API_SMART_APP_URL + "server/submit/sku";

    /**
     * 删除 删除素材接口，API 实时接口提交方式。
     * https://smartprogram.baidu.com/docs/develop/serverapi/deletesku/
     */
    String DELETE_SKU_RESOURCES = SmartAppConstants.OPEN_API_SMART_APP_URL + "server/delete/sku";

    /**
     * 优惠券资源提交
     * https://smartprogram.baidu.com/docs/develop/serverapi/submitskucoupon/
     */
    String SUBMIT_SKU_COUPON_RESOURCES = SmartAppConstants.OPEN_API_SMART_APP_URL + "server/submit/skuCoupon";

    /**
     * 删除优惠券资源接口，API 实时接口提交方式。
     * https://smartprogram.baidu.com/docs/develop/serverapi/deleteskucoupon/
     */
    String DELETE_SKU_COUPON_RESOURCES = SmartAppConstants.OPEN_API_SMART_APP_URL + "server/delete/skuCoupon";

    /**
     * 信息流 提交 / 修改素材接口，API 实时接口提交方式。
     * https://smartprogram.baidu.com/docs/develop/serverapi/submitresource/
     */
    String SUBMIT_RESOURCE = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/submitresource";

    /**
     * 信息流 删除素材接口，API 实时接口提交方式
     * https://smartprogram.baidu.com/docs/develop/serverapi/deleteresource/
     */
    String DELETE_RESOURCE = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/deleteresource";

    /**
     * 信息流 提交链接文件（即 Sitemap）接口，链接文件提交方式（即 sitemap 提交）
     * https://smartprogram.baidu.com/docs/develop/serverapi/submitsitemap/
     */
    String SUBMIT_SITMAP = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/submitsitemap";

    /**
     * 信息流 删除链接文件（即 sitemap）接口，链接文件提交方式（即 sitemap 提交）。
     * https://smartprogram.baidu.com/docs/develop/serverapi/deletesitemap/
     *
     */
    String DELETE_SITMAP =  SmartAppConstants.OPEN_API_SMART_APP_URL + "access/deletesitemap";

    /**
     * 百家号挂载 物料提交接口
     * https://smartprogram.baidu.com/docs/develop/serverapi/bjh_submitintro/
     */
    String ADD_BJH_MATERIAL =  SmartAppConstants.OPEN_API_SMART_APP_URL + "articlemount/material/add";

    /**
     * 百家号挂载 物料修改接口
     * https://smartprogram.baidu.com/docs/develop/serverapi/bjh_submitintro/
     * 9%E4%BF%AE%E6%94%B9%E6%8E%A5%E5%8F%A3
     */
    String MODIFY_BJH_MATERIAL =  SmartAppConstants.OPEN_API_SMART_APP_URL + "articlemount/material/modify";

    /**
     * 百家号挂载 物料删除接口
     * https://smartprogram.baidu.com/docs/develop/serverapi/bjh_submitintro/
     */

    String DELETE_BJH_MATERIAL = SmartAppConstants.OPEN_API_SMART_APP_URL + "articlemount/material/delete";



    /**
     * 提交资源
     * @param accessToken
     * @param res , 资源信息，说明可在文档处使查阅说明
     * @return 响应参数
     * @throws SmartAppErrorException
     */
    String submitSku(String accessToken, Resources[] res) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     *
     * @param accessToken
     * @param appId
     * @param pathList
     * @return 响应参数
     * @throws SmartAppErrorException
     */
     String deleteSku(String accessToken, int appId, String pathList)
             throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 优惠券资源提交
     * @param accessToken
     * @param res 资源
     * @return 响应字符串
     * @throws SmartAppErrorException
     */
     String submitSkuCoupon(String accessToken, Resources[] res) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 优惠券资源删除
     * @param accessToken
     * @param appId
     * @param pathList
     * @return
     * @throws SmartAppErrorException
     */
     String deleteSkuCoupon(String accessToken, int appId, String pathList)
             throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * submitresource 信息流 提交 / 修改素材接口，API 实时接口提交方式。
     * @param accessToken access_token
     * @param appId appid
     * @param body 内容的介绍，最多 2000 字符
     * @param ext 扩展信息
     * @param feedSubType feed 二级分类
     * @param feedType feed 一级分类
     * @param images 封面图片链接，要求必须是 JSON 格式，最多 3 张，单图片最大不能超 2M，只支持 JPG 或 PNG 格式（jpeg 不支持），
     *               尺寸要求：宽不能低于 372px，且高不能低于 248px。重要提示：图片尺寸越大、清晰度越高、
     *               宽高比越接近3:2，越有助于降低不可用风险，促进分发
     * @param mappSubType 资源子类型
     * @param mapType 资源类型
     * @param path 智能小程序落地页链接
     * @param tags 资源标签，英文逗号分割，填写越准确详细可能带来更好的分发效果（最多 10 个，总长度最多 100 字）
     * @param title 标题
     * @return 响应参数
     */
     String submitResource(String accessToken, int appId, String body, String ext, String feedSubType,
                           String feedType, String images, String mappSubType, String mapType,
                           String path, String tags, String title )
             throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 信息流 删除素材接口，API 实时接口提交方式。
     * @param accessToken
     * @param appId appid
     * @param path 智能小程序内页链接
     *  /pages/detail/detail?id=100001
     * @return data 中的数据
     */
     String deleteResource(String accessToken, int appId, String path)
             throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 信息流 提交  提交链接文件（即 Sitemap）接口，链接文件提交方式（即 sitemap 提交）。
     * @param accessToken
     * @param appId
     * @param desc 描述信息
     * @param frequency 描述信息
     * @param type 类型 1-增量/更新； 0-下线/删除
     * @param url sitemap 链接
     * @return
     */
     String submitSitmap(String accessToken, int appId, String desc, String frequency, String type,
                         String url) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 信息流 删除链接文件（即 sitemap）接口，链接文件提交方式（即 sitemap 提交）。
     * @param accessToken
     * @param appId
     * @param url
     * @return
     */
     String deleteSitmap(String accessToken, int appId, String url)
             throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 百家号挂载， 物料提交接口
     * @param accessToken
     * @param material
     * @return
     * @throws SmartAppErrorException
     */
     MaterialRueslt addBJHMaterial(String accessToken, BJHMaterial material)
             throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 百家号挂载 物料修改接口
     * @param accessToken
     * @param material
     * @return 修改是否成功
     * @throws SmartAppErrorException
     */
    boolean modifyBJHMaterial(String accessToken, BJHMaterial material)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 百家号挂载 物料删除接口
     * @param accessToken
     * @param appId
     * @param id
     * @param path
     * @return
     * @throws SmartAppErrorException
     */
    boolean deleteBJHMaterial(String accessToken, int appId, int id, String path)
            throws SmartAppErrorException, OpenAPIErrorException;

}
