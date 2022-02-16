package com.baidu.mapp.common;

public class SmartAppResultC<T> extends SmartAppResult<T> {
    /**
     * 响应消息
     */
    private String errmsg;

    @Override
    public String getMsg() {
        return errmsg;
    }

    @Override
    public void setMsg(String msg) {
        errmsg = msg;
    }
}