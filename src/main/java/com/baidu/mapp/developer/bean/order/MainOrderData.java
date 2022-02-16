package com.baidu.mapp.developer.bean.order;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * 订单数据
 */
@Data
public class MainOrderData {
    /**
     * 订单种类， 具体见文档
     */
    @Alias("CateID")
    private  int cateID;
    /**
     * 订单标题，建议使用订单商品名称
     */
    @Alias("Title")
    private String title;

    /**
     * * 开发者接入的唯一订单 ID
     */
    @Alias("ResourceID")
    private  String resourceID;

    /**
     *小程序 AppKey
     */
    @Alias("BizAPPID")
    private  String bizAPPID;

    /**
     * 订单创建时间（单位：秒)
     */
    @Alias("Ctime")
    private  int ctime;

    /**
     * 订单最后被修改时间（单位：秒）
     */
    @Alias("Mtime")
    private  int mtime;

    /**
     * 订单状态，其值根据CateID不同有不同的定义
     */
    @Alias("Status")
    private  int status;

    /**
     * 扩展信息
     */
    @Alias("EXT")
    private MainOrderEXT eXT;

}
