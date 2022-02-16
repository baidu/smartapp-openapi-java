package com.baidu.mapp.tp.bean.search;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-17 10:04
 **/
@Data
public class SubChainInfo {
    private int appLevel;
    private int subChainPriorNumber;
    private List<SubChainInfoList> subChainInfoList;

    @Data
    public static class SubChainInfoList {
        /**
         * 子链ID
         */
        private Long id;
        /**
         * 小程序ID
         */
        private Long appId;
        /**
         * 小程序名称
         */
        private String appName;
        /**
         * 开发者ID
         */
        private Long customerId;
        /**
         * 开发者名称
         */
        private String customerName;
        /**
         * 子链名称
         */
        private String chainName;
        /**
         * 子链描述
         */
        private String chainDesc;
        /**
         * 子链路径
         */
        private String chainPath;
        /**
         * 请求路径校验值
         */
        private String pathMd5;
        /**
         * 子链状态
         */
        private Byte status;
        /**
         * 子链顺序（位置）
         */
        private Byte chainRank;
        /**
         * 子链创建时间
         */
        private Long createTime;
        /**
         * 子链更新时间
         */
        private Long updateTime;
        /**
         * 子链审核时间
         */
        private Long auditTime;
        /**
         * 子链审核结果
         */
        private String auditDesc;
        /**
         * 客服电话
         */
        private String telephone;
        /**
         * 子链类型 默认是path类型
         */
        private Byte subchainType;
        /**
         * 标记优选、备选状态
         */
        private Integer showStatus;
    }
}

