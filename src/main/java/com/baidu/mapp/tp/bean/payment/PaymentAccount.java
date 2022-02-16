package com.baidu.mapp.tp.bean.payment;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-11 11:08
 **/
@Data
public class PaymentAccount {
    /**
     * 审核状态
     * 0:初始状态；
     * 1:编辑中
     * 2:提审
     * 3:未通过
     * 4:审核通过
     * 5:回填过协议id
     */
    private Integer status;
    /**
     * 审核回执
     */
    private String verifyMessage;
}
