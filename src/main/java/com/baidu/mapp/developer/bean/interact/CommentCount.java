package com.baidu.mapp.developer.bean.interact;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class CommentCount {
    @Alias("comment_count")
    private String commentCount;
}
