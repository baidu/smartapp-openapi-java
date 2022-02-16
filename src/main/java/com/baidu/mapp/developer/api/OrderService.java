package com.baidu.mapp.developer.api;

import com.baidu.mapp.common.SmartAppConstants;
import com.baidu.mapp.developer.bean.order.MainOrderData;
import com.baidu.mapp.developer.bean.order.OperationReulst;
import com.baidu.mapp.developer.bean.order.OrderQuery;
import com.baidu.mapp.developer.bean.order.SubsOrderData;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;


public interface OrderService {

    /**
     * 导入订单信息
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_importinfo/
     */
    String ADD_ORDER_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/add/main/info";

    /**
     * 更新订单信息
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_updateinfo/
     */
    String UPDATE_ORDER_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/update/main/info";

    /**
     * 更新订单状态
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_updatestat/
     */
    String UPDATE_ORDER_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/update/main/status";

    /**
     * 导入售后订单信息
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_importsubinfo/
     */
    String ADD_ORDER_SUB_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/append/sub/info";

    /**
     * 更新售后订单信息
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_updatesubinfo/
     */
    String UPDATE_ORDER_SUB_INFO = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/update/sub/info";

    /**
     * 更新售后订单状态
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_updatesubstat/
     */
    String UPDATE_ORDER_SUB_STATUS = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/update/sub/status";

    /**
     * 导入 / 更新订单物流信息
     * https://smartprogram.baidu.com/docs/develop/serverapi/order_importupdate/
     */
    String ADD_ORDER_LOGISTICS = SmartAppConstants.OPEN_API_SMART_APP_URL + "ordercenter/app/add/main/logistics";


    /**
     *导入订单信息
     * @param accessToken
     * @param queryparam 查询参数
     * @param orderData  订单数据
     * @return
     */
    OperationReulst[] addOrderInfo(String accessToken, OrderQuery queryparam,
                                 MainOrderData[] orderData) throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新订单状态
     * @param accessToken
     * @param queryparam
     * @param orderData
     * @return
     * @throws SmartAppErrorException
     */
    OperationReulst[] updateOrderStatus(String accessToken,  OrderQuery queryparam, MainOrderData[] orderData )
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新订单信息
     * @param accessToken
     * @param queryparam 查询类参数
     * @param orderData
     * @return
     */
    OperationReulst[] updateOrderInfo(String accessToken, OrderQuery queryparam, MainOrderData[] orderData)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 导入售后订单信息
     * @param accessToken
     * @param queryParam
     * @param data
     * @return
     * @throws SmartAppErrorException
     */
    OperationReulst[] addSubOrderInfo(String accessToken, OrderQuery queryParam, SubsOrderData[] data)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新售后订单信息
     * @param accessToken
     * @param queryParam
     * @param data
     * @return
     * @throws SmartAppErrorException
     */
    OperationReulst[] updateSubOrderInfo(String accessToken, OrderQuery queryParam, SubsOrderData[] data)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 更新售后订单状态
     * @param accessToken
     * @param queryParam
     * @param data
     * @return
     * @throws SmartAppErrorException
     */
    OperationReulst[] updateSubOrderStatus(String accessToken, OrderQuery queryParam, SubsOrderData[] data)
            throws SmartAppErrorException, OpenAPIErrorException;

    /**
     * 导入 / 更新订单物流信息
     * @param accessToken
     * @param querParam
     * @param data
     * @return
     * @throws SmartAppErrorException
     */
    OperationReulst[] submitLogisticsOrder(String accessToken, OrderQuery querParam, MainOrderData[] data)
            throws SmartAppErrorException, OpenAPIErrorException;

}
