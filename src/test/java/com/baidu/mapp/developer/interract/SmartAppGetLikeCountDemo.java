package com.baidu.mapp.developer.interract;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.interact.LikeCount;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppGetLikeCountDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        SmartAppClient smartAppClient = new SmartAppClient();
        try {
            LikeCount res = smartAppClient.getInteractService().getLikeCount(accessToken,
                    "ts_article_c879ed0e42ce66147f3409eb",
                    "");
            System.out.println(res.getLikeCount());
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
