package com.baidu.mapp.tp.bean.order;

import java.util.List;

import lombok.Data;

/**
 * @description:商品信息
 * @author: chenhaonan02
 * @create: 2021-12-03 17:20
 **/
@Data
public class ProductInfo {
    /**
     * 商品id
     */
    private String id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品描述
     */
    private String desc;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 商品原价
     */
    private Long price;
    /**
     * 实付价格
     */
    private Long payPrice;
    /**
     * 商品图片地址
     */
    private List<String> imgList;
    /**
     * 商品地址
     */
    private PageInfo pageInfo;
    /**
     * 商品规格
     */
    private List<SkuAttr> skuAttr;
}
