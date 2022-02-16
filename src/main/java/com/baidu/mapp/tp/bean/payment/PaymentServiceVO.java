package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-11 11:27
 **/
@Data
public class PaymentServiceVO {
    /**
     * 开通状态
     * 0:新建
     * 1:审核中
     * 2:审核通过
     * 3:驳回
     */
    private Integer status;
    /**
     * 驳回回执
     */
    private String verifyMessage;
}
