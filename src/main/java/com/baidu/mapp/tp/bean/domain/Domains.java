package com.baidu.mapp.tp.bean.domain;

import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-15 10:30
 **/
@Data
public class Domains {
    private List<String> requestDomain;
    private List<String> uploadDomain;
    private List<String> downloadDomain;
    private List<String> socketDomain;
}
