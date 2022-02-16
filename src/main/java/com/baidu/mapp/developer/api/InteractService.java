package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.developer.bean.interact.CommentCount;
import com.baidu.mapp.developer.bean.interact.CommentList;
import com.baidu.mapp.developer.bean.interact.LikeCount;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public interface InteractService {
    /**
     * 互动评论数
     * https://smartprogram.baidu.com/docs/develop/serverapi/interactive_comment_count/
     */

    String COMMENT_COUNT = SmartAppConstants.OPEN_API_SMART_APP_URL + "ma/component/comment/tcount";
    /**
     * 互动点赞数
     * https://smartprogram.baidu.com/docs/develop/serverapi/interactive_like_count/
     */
    String LIKE_COUNT = SmartAppConstants.OPEN_API_SMART_APP_URL + "oss/publisher/ugc/like_count";

    /**
     * 互动评论列表
     * https://smartprogram.baidu.com/docs/develop/serverapi/interactive_comment_list/
     */
    String COMMENT_LIST = SmartAppConstants.OPEN_API_SMART_APP_URL + "ma/component/comment/open_list";

    /**
     * 获取评论数
     * @param accessToken
     * @param snid 文章的 ID
     * @param snidType 无 snid_type 的开发者请默认传空串
     * @return 评论数
     * @throws SmartAppErrorException
     */
    CommentCount getCommentCount(String accessToken, String snid, String snidType)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 获取点赞数
     * @param accessToken
     * @param snid 文章的 ID
     * @param snidType 无 snid_type 的开发者请默认传空串
     * @return
     * @throws SmartAppErrorException
     */
    LikeCount getLikeCount(String accessToken, String snid, String snidType)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 互动评论列表
     * @param accessToken
     * @param snid 文章的 ID
     * @param snidType 无 snid_type 的开发者请默认传空串
     * @param strt 评论的开始偏移量，默认0
     * @param num 获取的评论条数，默认10
     * @return
     */
    CommentList getCommentList(String accessToken, String snid, String snidType, int strt, int num)
            throws SmartAppErrorException, OpenAPIErrorException;

}
