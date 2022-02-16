package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description: 主体信息
 * @author: chenhaonan02
 * @create: 2021-10-25 11:27
 **/
@Data
public class Qualification {
    private String name;
    private Integer type;
    /**
     * 0:未操作 1：通过 2：审核中 3：审核失败 4：推送失败
     */
    private Integer status;
    /**
     * 高级认证类型,0:未做高级认证、1:对公验证、2:活体验证
     */
    private Integer adType;
    /**
     * 高级认证状态,1:通过、3:失败
     */
    private Integer adStatus;
}
