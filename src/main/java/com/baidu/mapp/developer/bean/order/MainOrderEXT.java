package com.baidu.mapp.developer.bean.order;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public  class MainOrderEXT {
    @Data
    public static class ExtMainOrder {
        @Alias("Products")
        private  Products[] products;
        @Alias("Payment")
        private  Payment payment;
        @Alias("Appraise")
        private  Appraise appraise;
        @Alias("OrderDetail")
        private  OrderDetail orderDetail;
        @Alias("Express")
        private  Express[] express;

        @Data
        public  static  class  Express {
            @Alias("ID")
            private  String iD;
            @Alias("Name")
            private  String name;
            @Alias("Code")
            private  String code;
            @Alias("Type")
            private  int type;
            @Alias("Status")
            private  int status;
        }
        @Data
        public  static  class Products {
            @Alias("ID")
            private String iD;
            @Alias("Name")
            private String name;
            @Alias("Desc")
            private String desc;
            @Alias("Quantity")
            private int quantity;
            @Alias("Price")
            private int price;
            @Alias("PayPrice")
            private int payPrice;
            @Alias("ImgList")
            private  String[] imgList;
            @Alias("DetailPage")
            private  DetailPage detailPage;
            @Alias("KuAttr")
            private  SkuAttr[] skuAttr;

            @Data
            public  static  class DetailPage {
                @Alias("Status")
                private String status;
                @Alias("SwanSchema")
                private String swanSchema;
            }

            @Data
            public  static  class SkuAttr {
                @Alias("Name")
                private String name;
                @Alias("Value")
                private String value;
            }
        }

        @Data
        public  static  class Payment {
            @Alias("Time")
            private int time;
            @Alias("Method")
            private int method;
            @Alias("Amount")
            private int amount;
            @Alias("IsPayment")
            private boolean isPayment;
            @Alias("PreferentialInfo")
            private  PreferentialInfo preferentialInfo;
            @Alias("PaymentInfo")
            private  PaymentInfo paymentInfo;

            @Data
            public  static  class PreferentialInfo {
                @Alias("Name")
                private String name;
                @Alias("Value")
                private int value;
                @Alias("Quantity")
                private int quantity;
            }

            @Data
            public  static  class PaymentInfo {
                @Alias("Name")
                private String name;
                @Alias("Value")
                private int value;
                @Alias("Quantity")
                private String quantity;
            }

        }

        @Data
        public  static  class Appraise {

            @Alias("Status")
            private int status;
            @Alias("SwanSchema")
            private String swanSchema;
        }

        @Data
        public  static  class OrderDetail {
            @Alias("Status")
            private int status;
            @Alias("SwanSchema")
            private String swanSchema;
        }
    }

    @Alias("MainOrder")
    private  ExtMainOrder mainOrder;
}
