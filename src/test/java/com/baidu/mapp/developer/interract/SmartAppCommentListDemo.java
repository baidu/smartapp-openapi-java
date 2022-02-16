package com.baidu.mapp.developer.interract;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.interact.CommentList;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppCommentListDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            CommentList res = smartAppClient.getInteractService().getCommentList(accessToken,
                    "ts_article_c879ed0e42ce66147f3409eb",
                    "", 0, 3);
            System.out.println(res.getList()[0]);
        } catch (
                SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
