package com.baidu.mapp.tp.bean.subscription;

import lombok.Data;

/**
 * @description: 添加消息模板
 * @author: chenhaonan02
 * @create: 2021-11-10 10:12
 **/
@Data
public class AddMessageTemplate {
    /**
     * 添加至帐号下的模板id，发送小程序模板消息时所需
     */
    private String templateId;
}
