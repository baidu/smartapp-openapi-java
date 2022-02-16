package com.baidu.mapp.tp.bean.violation;

import java.util.List;

import lombok.Data;

/**
 * @description: 小程序违规原因
 * @author: chenhaonan02
 * @create: 2021-11-09 20:37
 **/
@Data
public class ViolationAppDetails {
    /**
     * 小程序id
     */
    private Long appId;
    /**
     * 问题详情列表
     */
    private List<ProblemDetail> problemDetails;
}

