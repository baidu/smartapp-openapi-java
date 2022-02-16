package com.baidu.mapp.util;

import java.lang.reflect.Method;

import com.baidu.mapp.common.TimeIntervalContext;

import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeIntervalAspect extends SimpleAspect {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        TimeIntervalContext.clean();
        TimeIntervalContext timeIntervalContext = TimeIntervalContext.get();
        timeIntervalContext.setStart(DateUtil.current());
        timeIntervalContext.setEnd(DateUtil.current());
        timeIntervalContext.setMethod(target.getClass().getName() + "." + method.getName());
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args, Object returnVal) {
        TimeIntervalContext timeIntervalContext = TimeIntervalContext.get();
        timeIntervalContext.setEnd(DateUtil.current());
        timeIntervalContext.setReturnVal(returnVal);
        log.info(JSONUtil.toJsonStr(timeIntervalContext));
        return true;
    }

    @Override
    public boolean afterException(Object target, Method method, Object[] args, Throwable e) {
        TimeIntervalContext timeIntervalContext = TimeIntervalContext.get();
        timeIntervalContext.setEnd(DateUtil.current());
        timeIntervalContext.setThrowable(ExceptionUtil.getMessage(e));
        log.error(JSONUtil.toJsonStr(timeIntervalContext));
        return true;
    }
}
