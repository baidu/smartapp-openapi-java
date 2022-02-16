package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2022-01-17 20:40
 **/
@Data
public class BillDetailClient {
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 导出进度
     */
    private Integer exportStatus;
    /**
     * 账单名称
     */
    private String downloadName;
    /**
     * 下载地址
     */
    private String url;
}