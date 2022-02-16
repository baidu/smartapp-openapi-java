package com.baidu.mapp.developer.bean.templatemessage;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class MsgKey {
    @Alias("msg_key")
    private long msgKey;
}
