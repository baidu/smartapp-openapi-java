package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description: 服务信息
 * @author: chenhaonan02
 * @create: 2021-10-25 11:26
 **/
@Data
public class Category {
    private Long categoryId;
    private String categoryName;
    private String categoryDesc;
    private Integer auditStatus;
    private String reason;
    private Category parent;
}
