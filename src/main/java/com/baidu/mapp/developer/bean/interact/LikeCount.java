package com.baidu.mapp.developer.bean.interact;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class LikeCount {
    @Alias("like_count")
    private int  likeCount;
}
