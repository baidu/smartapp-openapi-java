package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.developer.bean.contentsecurity.CommonCheckResult;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public interface ContentSecurityService {
    /**
     * 单段文本检测
     * https://smartprogram.baidu.com/docs/develop/serverapi/text_security_detection/
     */
    String CHECK_TEXT = SmartAppConstants.OPEN_API_SMART_APP_URL + "riskDetection/v2/syncCheckText";

    /**
     * 单张图片检测
     * https://smartprogram.baidu.com/docs/develop/serverapi/picture_security_check/
     */
    String CHECK_IMG  = SmartAppConstants.OPEN_API_SMART_APP_FILE_URL + "riskDetection/v2/syncCheckImage";

    /**
     * 单个path检测
     * https://smartprogram.baidu.com/docs/develop/serverapi/content_security_check/
     */
    String CHECK_PATH = SmartAppConstants.OPEN_API_SMART_APP_URL + "riskDetection/v2/asyncCheckPath";

    /**
     * 检测结果误判反馈
     * https://yapi.baidu-int.com/project/22008/interface/api/1199422
     */
    String MISJUDGE_FEEDBACK = SmartAppConstants.OPEN_API_SMART_APP_URL + "riskDetection/misjudgeFeedback";

    /**
     * 单段文本检测
     * @param accessToken
     * @param content
     * @param type
     * @return
     * @throws SmartAppErrorException
     */
    CommonCheckResult checkText(String accessToken, String content, String[] type)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 单张图片检测
     * @param accessToken
     * @param imagePath
     * @param type
     * @return
     * @throws SmartAppErrorException
     */
    CommonCheckResult checkImage(String accessToken, String imagePath, String type)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 单个path检测
     * https://smartprogram.baidu.com/docs/develop/serverapi/content_security_check/
     * @param accessToken
     * @param path
     * @param type
     * @return
     * @throws SmartAppErrorException
     */
    String checkPath(String accessToken, String path, String[] type )
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 检测结果误判反馈
     * https://smartprogram.baidu.com/docs/develop/serverapi/result_misjudgment_feedback/
     * @param accessToken
     * @param retrieveId 前面提交检测接口返回的 retrieveId
     */
    boolean misjudgeFeedback(String accessToken, String retrieveId)
            throws SmartAppErrorException;
}
