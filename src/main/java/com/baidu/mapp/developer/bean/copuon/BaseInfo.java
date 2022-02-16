package com.baidu.mapp.developer.bean.copuon;
import lombok.Data;

@Data
public class BaseInfo {
    private String title;
    private String color;
    private int getLimit;
    private int codeType;
    private  int quantity;
    private DateInfo dateInfo;
    private  String appRedirectPath;

    @Data
    public  static  class DateInfo {
        private int getStartTimestamp;
        private int getEndTimestamp;
        private int type;
        private int beginTimestamp;
        private int endTimestamp;
        private int timeUnit;
        private int timeValue;
    }
}

