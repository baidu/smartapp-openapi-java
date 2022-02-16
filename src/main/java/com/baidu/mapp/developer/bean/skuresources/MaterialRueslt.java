package com.baidu.mapp.developer.bean.skuresources;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class MaterialRueslt {
    @Alias("path")
    private String path;
    @Alias("id")
    private  int id;
}
