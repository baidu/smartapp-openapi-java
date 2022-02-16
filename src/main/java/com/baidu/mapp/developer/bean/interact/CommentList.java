package com.baidu.mapp.developer.bean.interact;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class CommentList {
    @Alias("List")
    private List[] list;
    @Data
    public  static class List {
        @Alias("thread_id")
        private String threadId;
        @Alias("srid")
        private  String srid;
        @Alias("like_count")
        private  String likeCount;
        @Alias("is_uped")
        private String isUped;
        @Alias("create_time")
        private  String createTime;
        @Alias("content")
        private  String content;
        @Alias("reply_list")
        private  ReplyList replyList;

        @Data
        public static class ReplyList {
            @Alias("like_count")
            private String likeCount;
            @Alias("is_uped")
            private  String isUped;
            @Alias("create_time")
            private  String createCime;
            @Alias("content")
            private  String content;
        }
    }
}
