package com.baidu.mapp.common;

import java.util.Map;

import lombok.Data;

/**
 * 切面上下文
 *
 * @author maduo
 */
@Data
public class TimeIntervalContext {

    private static final ThreadLocal<TimeIntervalContext> CURRENT_TIME_INTERVAL_CONTEXT =
            ThreadLocal.withInitial(TimeIntervalContext::new);

    private Long start;

    private Long end;

    private Long cost;

    private String method;

    private Object returnVal;

    private String throwable;

    private RequestContext request = new RequestContext();

    private ResponseContext response = new ResponseContext();

    public Long getCost() {
        if (cost != null) {
            return cost;
        }
        if (end == null || start == null) {
            return 0L;
        }
        cost = end - start;
        return cost;
    }

    public static TimeIntervalContext get() {
        return CURRENT_TIME_INTERVAL_CONTEXT.get();
    }

    public static void set(TimeIntervalContext timeIntervalContext) {
        CURRENT_TIME_INTERVAL_CONTEXT.set(timeIntervalContext);
    }

    public static void clean() {
        CURRENT_TIME_INTERVAL_CONTEXT.remove();
    }

    @Data
    public static class RequestContext {

        private Map<String, String> headers;

        private Map<String, Object> params;

        private String body;

        private String method;
    }

    @Data
    public static class ResponseContext {
        private String body;

        private Integer httpStatus;

        private String traceId;
    }
}