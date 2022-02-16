package com.baidu.mapp.developer.bean.order;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class SubsOrderData {
    @Alias("CateID")
    private int cateID;

    @Alias("BizAPPID")
    private String bizAPPID;

    @Alias("ResourceID")
    private  String resourceID;

    @Alias("EXT")
    private SubsOrderEXT eXT;

}
