package com.baidu.mapp.tp.api;

import java.io.File;
import java.util.List;

import com.baidu.mapp.tp.bean.search.AppNameChecked;
import com.baidu.mapp.tp.bean.search.QueryKeywordClient;
import com.baidu.mapp.tp.bean.search.SitemapTrafficData;
import com.baidu.mapp.tp.bean.search.SubChainInfo;
import com.baidu.mapp.tp.bean.search.TopQueryInfo;
import com.baidu.mapp.tp.bean.search.UrlMapping;
import com.baidu.mapp.tp.bean.search.UrlMappingOverview;
import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

/**
 * @description: 自然搜索接口
 * https://smartprogram.baidu.com/docs/third/search/intro/
 * @author: chenhaonan02
 * @create: 2021-11-15 11:03
 **/
public interface NaturalSearchService {
    /**
     * 服务名称
     */
    String SERVICE_NAME = "NaturalSearchService";
    /**
     * 设置web化开关
     * https://smartprogram.baidu.com/docs/third/search/web/
     */
    String TP_APP_MODIFY_WEB_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "app/modifywebstatus";
    /**
     * 为小程序提交页面基础信息文件
     * https://smartprogram.baidu.com/docs/third/search/page_for_miniapp/
     */
    String TP_ROBOTS_APP_UPLOAD = SmartAppConstants.OPEN_API_SMART_APP_FILE_URL + "robots/app/upload";
    /**
     * 为模板提交页面基础信息文件
     * https://smartprogram.baidu.com/docs/third/search/page_for_template/
     */
    String TP_ROBOTS_TEMPLATE_UPLOAD = SmartAppConstants.OPEN_API_SMART_APP_FILE_URL + "robots/template/upload";
    /**
     * 提交sitemap
     * https://smartprogram.baidu.com/docs/third/search/sitemap/
     */
    String TP_ACCESS_SUBMIT_SITEMAP = SmartAppConstants.OPEN_API_SMART_APP_URL + "access/submit/sitemap";
    /**
     * 绑定 H5 站点
     * https://smartprogram.baidu.com/docs/third/flow/site_h5_bind/
     */
    String TP_FLOW_BIND_SITE = SmartAppConstants.OPEN_API_SMART_APP_URL + "flow/bindsite";
    /**
     * 查询 H5 站点
     * https://smartprogram.baidu.com/docs/third/flow/site_h5_query/
     */
    String TP_FLOW_GET_BIND_SITE = SmartAppConstants.OPEN_API_SMART_APP_URL + "flow/getbindsite";
    /**
     * 提交适配替换规则
     * https://smartprogram.baidu.com/docs/third/flow/tp_rank_url_submit/
     */
    String TP_FLOW_SAVE_URL_MAPPING = SmartAppConstants.OPEN_API_SMART_APP_URL + "flow/saveurlmapping";
    /**
     * 查询适配替换规则
     * https://smartprogram.baidu.com/docs/third/flow/tp_rank_url_query/
     */
    String TP_FLOW_QUERY_URL_MAPPING = SmartAppConstants.OPEN_API_SMART_APP_URL + "flow/queryurlmapping";
    /**
     * 适配替换规则详情
     * https://smartprogram.baidu.com/docs/third/flow/tp_rank_url_detail/
     */
    String TP_FLOW_GET_URL_MAPPING_DETAIL = SmartAppConstants.OPEN_API_SMART_APP_URL + "flow/geturlmappingdetail";
    /**
     * 删除适配替换规则
     * https://smartprogram.baidu.com/docs/third/flow/tp_rank_url_delete/
     */
    String TP_FLOW_DEL_URL_MAPPING = SmartAppConstants.OPEN_API_SMART_APP_URL + "flow/delurlmapping";
    /**
     * 点展统计信息
     * https://smartprogram.baidu.com/docs/third/search/data/thumb_up_statistics/
     */
    String TP_PROMOTION_SITEMAP_GET_ANALYSIS_CTR = SmartAppConstants.OPEN_API_SMART_APP_URL
            + "promotion/sitemap/getanalysisctr";
    /**
     * 页面流量信息
     * https://smartprogram.baidu.com/docs/third/search/data/page_flow_info/
     */
    String TP_PROMOTION_TOP_QUERY_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "promotion/topquery/info";
    /**
     * 页面流量关键词信息
     * https://smartprogram.baidu.com/docs/third/search/data/page_flow_key_words/
     */
    String TP_PROMOTION_TOP_QUERY_KEYWORD = SmartAppConstants.OPEN_API_SMART_APP_URL + "promotion/topquery/keyword";
    /**
     * 添加子链
     * https://smartprogram.baidu.com/docs/third/search/subchain/add_subchain/
     */
    String TP_SUB_CHAIN_ADD = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/add";
    /**
     * 删除子链
     * https://smartprogram.baidu.com/docs/third/search/subchain/del_subchain/
     */
    String TP_SUB_CHAIN_DELETE = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/delete";
    /**
     * 更新子链
     * https://smartprogram.baidu.com/docs/third/search/subchain/update_subchain/
     */
    String TP_SUB_CHAIN_UPDATE = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/update";
    /**
     * 获取所有的子链信息
     * https://smartprogram.baidu.com/docs/third/search/subchain/obtain_all_subchain/
     */
    String TP_SUB_CHAIN_GET_ALL = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/getall";
    /**
     * 重排序子链
     * https://smartprogram.baidu.com/docs/third/search/subchain/reorder_subchain/
     */
    String TP_SUB_CHAIN_RANK = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/rank";
    /**
     * 停用子链
     * https://smartprogram.baidu.com/docs/third/search/subchain/block_up_subchain/
     */
    String TP_SUB_CHAIN_STOP = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/stop";
    /**
     * 启用子链
     * https://smartprogram.baidu.com/docs/third/search/subchain/start_subchain/
     */
    String TP_SUB_CHAIN_RESTART = SmartAppConstants.OPEN_API_SMART_APP_URL + "subchain/restart";

    /**
     * 设置web化开关
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param webStatus   1:开启 2:关闭
     *
     * @return AppNameChecked
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    AppNameChecked modifyWebStatus(String accessToken, Integer webStatus)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 为小程序提交页面基础信息文件API
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param robots      robots.txt 文件，要求文件为 txt 格式，目前支持48k的文件内容检测，请保证robots.txt文件不要过大，目录最长不超过250个字符。
     *
     * @return String
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    String uploadRobotsForApp(String accessToken, File robots) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 为模板提交页面基础信息文件API
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param templateId  模版 Id
     * @param robots      robots.txt 文件，要求文件为 txt 格式，目前支持 48k 的文件内容检测，请保证 robots.txt 文件不要过大，目录最长不超过 250 个字符
     *
     * @return String
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    String uploadRobotsForTemplate(String accessToken, Long templateId, File robots)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 提交sitemap
     *
     * @param tpAccessToken 第三方平台的接口调用凭据
     * @param type          上传级别 0：周级别，一周左右生效；1：天级别，2~3天生效
     * @param urlList       url集合；上传级别上限，0：每天3000条，1：每天5000
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    void submitSitemapByApi(String tpAccessToken, Integer type, List<String> urlList)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 绑定 H5 站点
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param sites       站点列表
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean bindSite(String accessToken, List<String> sites) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查询 H5 站点
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param pageNum     分页页码。从1开始
     * @param pageSize    分页大小。最大值为 100
     *
     * @return List<String>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<String> getBindSite(String accessToken, Integer pageNum, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 提交适配替换规则
     *
     * @param accessToken  授权小程序的接口调用凭据
     * @param content      json字符串
     * @param createMethod 每页数量，最大100
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean saveUrlMapping(String accessToken, String content, Byte createMethod)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 查询适配替换规则
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param pageNum     分页页码。从1开始
     * @param pageSize    分页大小。最大值为 100
     *
     * @return UrlMappingOverview
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    UrlMappingOverview queryUrlMapping(String accessToken, Integer pageNum, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 适配替换规则详情
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param ruleId      规则 Id
     *
     * @return List<UrlMapping>
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    List<UrlMapping> getUrlMappingDetail(String accessToken, Long ruleId)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 删除适配替换规则
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param delRuleId   规则 Id
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean delUrlMapping(String accessToken, String delRuleId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 点展统计信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return sitemap提交信息概要
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    SitemapTrafficData getSitemapMeta(String accessToken, Integer timeSpan)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 页面流量信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param timeSpan    时间区间。可取值1、7、30，分别代表 1 天、7 天、30 天
     * @param pageNum     分页页数。
     * @param pageSize    分页大小。最大值为100
     *
     * @return TopQueryInfo
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    TopQueryInfo getTopQueryUrlInfo(String accessToken, Integer timeSpan, Integer pageNum, Integer pageSize)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 页面流量关键词信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param webUrl      页面地址。来自于 /promotion/topquery/info 接口返回的数据
     * @param timeSpan    时间区间。可取值1、7、30，分别代表 1 天、7 天、30 天
     * @param pageNum     分页页数。
     * @param pageSize    分页大小。最大值为100
     *
     * @return QueryKeywordClient
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    QueryKeywordClient getQueryKeyword(String accessToken, String webUrl, Integer timeSpan, Integer pageNum,
                                       Integer pageSize) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 添加子链
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param chainName   4-10个字符，说明子链的功能
     * @param chainDesc   8-16个字符，辅助描述子链的功能
     * @param chainPath   以“/”开头的子链对应的path路径
     * @param telephone   SA类型的客服电话子链
     *
     * @return Long
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Long addSubChain(String accessToken, String chainName, String chainDesc, String chainPath, String telephone)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 删除子链
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param subChainId  子链 Id
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean deleteSubChain(String accessToken, Long subChainId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新子链
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param subChainId  子链 Id
     * @param chainName   4-10个字符，说明子链的功能
     * @param chainDesc   8-16个字符，辅助描述子链的功能
     * @param chainPath   以“/”开头的子链对应的path路径
     * @param telephone   SA类型的客服电话子链
     *
     * @return SA类型的客服电话子链
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean updateSubChain(String accessToken, Long subChainId, String chainName, String chainDesc, String chainPath,
                           String telephone) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取所有的子链信息
     *
     * @param accessToken 授权小程序的接口调用凭据
     *
     * @return SubChainInfo
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    SubChainInfo getAllSubChain(String accessToken) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 重排序子链
     *
     * @param accessToken    授权小程序的接口调用凭据
     * @param subChainIdList 子链 Id 字符串，顺序代表了排序位置,使用逗号分割
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean rankSubChain(String accessToken, List<Long> subChainIdList)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 停用子链
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param subChainId  子链 Id
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean stopSubChain(String accessToken, Long subChainId) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 启用子链
     *
     * @param accessToken 授权小程序的接口调用凭据
     * @param subChainId  子链 Id
     *
     * @return Boolean
     *
     * @throws SmartAppErrorException 智能小程序异常类
     * @throws OpenAPIErrorException  OpenAPI异常类
     */
    Boolean startSubChain(String accessToken, Long subChainId) throws SmartAppErrorException, OpenAPIErrorException;
}
