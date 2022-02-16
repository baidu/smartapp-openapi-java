package com.baidu.mapp.tp.bean.data;

import java.lang.reflect.Field;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 调用mtj获得结果后 对外API 参数
 * @author: chenhaonan02
 * @create: 2021-11-12 21:21
 **/
@Data
@Slf4j
public class Indicator {
    /**
     * 当日小程序数量
     */
    private String tpDayAppCount;
    /**
     * 近7日小程序数量
     */
    private String tpWeekAppCount;
    /**
     * 近30日小程序数量
     */
    private String tpMonthAppCount;
    /**
     * 当日启动用户数
     */
    private String tpDayUserCount;
    /**
     * 近7日启动用户数
     */
    private String tpWeekUserCount;
    /**
     * 近30日启动用户数
     */
    private String tpMonthUserCount;
    /**
     * 当日启动新用户数
     */
    private String tpDayNewUserCount;
    /**
     * 近7日启动新用户数
     */
    private String tpWeekNewUserCount;
    /**
     * 近30日启动新用户数
     */
    private String tpMonthNewUserCount;
    /**
     * 当日启动次数
     */
    private String tpDaySessionCount;
    /**
     * 近7日启动数
     */
    private String tpWeekSessionCount;
    /**
     * 近30日启动数
     */
    private String tpMonthSessionCount;
    /**
     * 当日页面访问次数
     */
    private String tpDayPageCount;
    /**
     * 小程序活跃度
     */
    private String tpActivityDegree;
    /**
     * 当日人均使用时长
     */
    private String tpSessionTimePerPerson;
    /**
     * 当日次均使用时长
     */
    private String tpSessionTimePerDay;
    /**
     * 分享次数
     */
    private String tpDayShareCount;
    /**
     * 回流次数
     */
    private String tpDayBackFlowCount;

    public void setParam(String paramKey, String paramValue, Indicator indicator) {
        try {
            paramKey = paramKey.replace("_", "");
            Field[] fields = indicator.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equalsIgnoreCase(paramKey)) {
                    field.set(indicator, paramValue);
                }
            }
        } catch (Exception e) {
            log.error("mtj response param Indicator set error paramKey:{} paramValue:{}", paramKey, paramValue);
        }
    }
}

