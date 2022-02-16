package com.baidu.mapp.tp.bean.violation;

import lombok.Data;

/**
 * @description: 问题详情
 * @author: chenhaonan02
 * @create: 2021-11-09 20:38
 **/
@Data
public class ProblemDetail {
    /**
     * 任务id
     */
    private Long taskId;
    /**
     * 问题状态
     */
    private Byte status;
    /**
     * 问题描述
     */
    private String problemDesc;
    /**
     * 问题path
     */
    private String problemPath;
    /**
     * 问题截图
     */
    private String screenShot;
    /**
     * 审核原因
     */
    private String auditReason;
    /**
     * 审核截图
     */
    private String auditShot;
}