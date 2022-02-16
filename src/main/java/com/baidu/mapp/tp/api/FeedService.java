package com.baidu.mapp.tp.api;

import com.baidu.mapp.common.SmartAppPageB;
import com.baidu.mapp.tp.bean.feed.AccessResource;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @author maduo
 * https://smartprogram.baidu.com/docs/third/feed/intro/
 */
public interface FeedService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "Feed";
    /**
     * 实时接口提交物料资源
     * https://smartprogram.baidu.com/docs/third/feed/submit_materiel/
     */
    String RESOURCE_SUBMIT = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/resource/submit";
    /**
     * 实时接口查询物料资源
     * https://smartprogram.baidu.com/docs/third/feed/query_materiel/
     */
    String RESOURCE_QUERY = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/resource/query";
    /**
     * 实时接口下线物料资源
     * https://smartprogram.baidu.com/docs/third/feed/del_materiel/
     */
    String RESOURCE_DELETE = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/resource/delete";
    /**
     * 通过sitemap提交物料
     * https://smartprogram.baidu.com/docs/third/feed/submit_sitemap/
     */
    String SITEMAP_SUBMIT = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/sitemap/submit";
    /**
     * 通过sitemap删除物料
     * https://smartprogram.baidu.com/docs/third/feed/del_sitemap/
     */
    String SITEMAP_DELETE = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/sitemap/delete";

    /**
     * 实时接口提交物料资源
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param title       标题
     * @param body        消息体，物料的介绍
     * @param path        智能小程序落地页链接
     * @param images      封面图片链接（JSON格式）（最多3张，单图片最大2M） 建议尺寸：宽>=375 & 高>=250；建议比例 宽:高=1.5:1
     * @param mappType    资源类型
     * @param mappSubType 资源子类型
     * @param feedType    feed一级分类
     * @param feedSubType feed二级分类
     * @param tags        资源标签，英文逗号分割，填写越准确详细可能带来更好的分发效果（最多10个，总长度最多100字）
     * @param ext         扩展信息
     *
     * @return total
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    String accessResourceSubmit(String accessToken, String title, String body, String path, String images,
                                Long mappType, Long mappSubType, String feedType, String feedSubType, String tags,
                                String ext) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 实时接口查询物料资源
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param title       标题
     * @param status      状态（0: 全部 1: 审核中 2: 审核失败 3: 投放中 4: 已删除），默认值为0
     * @param begin       开始时间 (默认值前一天0点)
     * @param end         结束时间 (默认值今天0点)
     * @param pageNo      页数(分页参数,第几页,默认值(1)
     * @param pageSize    单页展示数据量(分页参数,默认值(10)
     * @param imageType   image_type
     *
     * @return SmartAppPageB<AccessResource>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    SmartAppPageB<AccessResource> accessResourceQuery(String accessToken, String title, Integer status, Long begin,
                                                      Long end, Integer pageNo, Integer pageSize, Integer imageType)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 实时接口下线物料资源
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param appId       小程序 Id
     * @param path        智能小程序内页链接
     *
     * @return Object
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Object deleteResource(String accessToken, Long appId, String path)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 通过sitemap提交物料
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param appId       小程序 Id
     * @param desc        描述信息
     * @param frequency   更新频率 3-每天 4-每周
     * @param type        类型 1-增量/更新； 0-下线/删除
     * @param url         sitemap链接
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean submitSitemap(String accessToken, Long appId, String desc, Long frequency, Long type, String url)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 通过sitemap删除物料
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param appId       小程序 Id
     * @param url         sitemap链接
     *
     * @return Object
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Object deleteSitemap(String accessToken, Long appId, String url)
            throws SmartAppErrorException, OpenAPIErrorException;
}
