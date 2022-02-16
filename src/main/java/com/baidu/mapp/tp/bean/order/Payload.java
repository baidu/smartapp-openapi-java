package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description: 订单中心接口参数
 * @author: chenhaonan02
 * @create: 2021-12-03 16:51
 **/
@Data
public class Payload {
    /**
     * 2-订单
     */
    public static final int TYPEID_ORDER = 2;
    /**
     * 1-小程序(内部)
     */
    public static final int BIZID_INNER_APP = 1;
    /**
     * 2-小程序(外部)
     */
    public static final int BIZID_OUTER_APP = 2;
    /**
     * 30-小游戏(内部)
     */
    public static final int BIZID_INNER_SWAN_GAME = 30;
    /**
     * 31-小游戏(外部)
     */
    public static final int BIZID_OUTER_SWAN_GAME = 31;
    /**
     * 用户ID
     */
    private Long uid;
    /**
     * 资产类型
     */
    private Integer typeId;
    /**
     * 业务方ID
     */
    private Integer bizId;
    /**
     * 未登录用户唯一id
     */
    private String thirdUid;
    /**
     * 资产数据
     */
    private List<ResourceData> data;
}
