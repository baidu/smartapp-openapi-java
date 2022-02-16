package com.baidu.mapp.developer.bean.order;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class OperationReulst {

    /**
     * POST 请求参数中 BizAPPID
     */
    @Alias("biz_app_id")
    String bizAppId;

    /**
     * POST 请求参数中 CateID
     */
    @Alias("cate_id")
    String cateId;

    /**
     * POST 请求参数中 ResourceID
     */
    @Alias("resource_id")
    String resourceId;

    /**
     * 请求受影响行数（即请求是否成功， 0 为失败，非 0 为成功）
     */
    @Alias("rows_affected")
    String rowsAffected;

}
