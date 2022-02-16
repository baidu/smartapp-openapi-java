package com.baidu.mapp.tp.bean.subscription;

import java.util.List;

import lombok.Data;

/**
 * @description: 模板库标题列表
 * @author: chenhaonan02
 * @create: 2021-11-09 21:21
 **/
@Data
public class TemplateTitleList {
    /**
     * 模板库标题总数
     */
    private int totalCount;
    /**
     * 模板库列表
     */
    private List<LibraryList> libraryList;
}
