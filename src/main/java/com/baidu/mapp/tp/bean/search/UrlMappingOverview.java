package com.baidu.mapp.tp.bean.search;

import java.util.List;

import lombok.Data;

/**
 * @description: 规则状态信息
 * @author: chenhaonan02
 * @create: 2021-11-17 15:00
 **/
@Data
public class UrlMappingOverview {
    /**
     * 适配资源生效量
     */
    private Integer totalAdapterNum;
    /**
     * 规则总数
     */
    private Integer ruleTotalNum;
    /**
     * 规则剩余可用数量
     */
    private Integer ruleRemainingNum;
    /**
     * 规则列表
     */
    private List<RuleDetail> ruleDetailList;

    @Data
    public class RuleDetail {
        /**
         * 规则ID
         */
        private Long ruleId;
        /**
         * h5规则
         */
        private String h5Rule;
        /**
         * 小程序rule
         */
        private String appRule;
        /**
         * 规则提交时间
         */
        private String submitTime;
        /**
         * 规则状态
         */
        private Integer status;
        /**
         * 规则状态说明
         */
        private String msg;
        /**
         * 创建方式
         */
        private Byte createMethod;
    }
}
