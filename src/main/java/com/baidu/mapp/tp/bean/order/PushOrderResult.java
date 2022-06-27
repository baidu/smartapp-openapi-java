package com.baidu.mapp.tp.bean.order;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-12-03 16:46
 **/
@Data
public class PushOrderResult {
    private String bizAppId;
    private String cateId;
    private String resourceId;
    private String rowsAffected;
}
