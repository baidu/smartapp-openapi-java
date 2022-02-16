package com.baidu.mapp.developer.bean.contentsecurity;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class CommonCheckResult {
    @Alias("retrieveId")
    private  String retrieveId;

    @Alias("res")
    private  Res[] res;
    @Data
    public  static  class  Res {
        @Alias("type")
        private  String type;
        @Alias("errno")
        private  int errno;
        @Alias("errno")
        private  String msg;
    }
}
