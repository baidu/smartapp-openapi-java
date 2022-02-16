package com.baidu.mapp.tp.bean.app;

import lombok.Data;

/**
 * @description: Domain
 * @author: chenhaonan02
 * @create: 2021-10-29 10:46
 **/
@Data
public class Domain {
    private String requestDomain;
    private String uploadDomain;
    private String downloadDomain;
    private String socketDomain;
}
