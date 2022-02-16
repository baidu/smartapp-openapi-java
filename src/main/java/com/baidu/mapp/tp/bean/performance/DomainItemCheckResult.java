package com.baidu.mapp.tp.bean.performance;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-03 11:29
 **/
@Data
public class DomainItemCheckResult {

    private Integer status;

    /**
     * key:提交的每一条path
     * value:检测结果
     */
    private Map<String, DomainPathCheckResult> checkResult;

    @Data
    public class DomainPathCheckResult {

        private Integer status;
        /**
         * 多条错误原因
         */
        private List<String> failReason;
    }
}