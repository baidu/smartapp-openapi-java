package com.baidu.mapp.developer.bean.order;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class SubsOrderEXT {
    @Alias("SubsOrder")
    private SubsOrder subsOrder;

    @Data
    public  static  class  SubsOrder {
        @Alias("Status")
        private  int status;

        @Alias("Items")
        private  SubsOrderEXTItem[] items;

        @Data
        public  static  class  SubsOrderEXTItem {
            @Alias("SubOrderID")
            private String subOrderID;

            @Alias("SubStatus")
            private  int subStatus;

            @Alias("CTime")
            private int cTime;

            @Alias("MTime")
            private  int mTime;

            @Alias("OrderType")
            private  int orderType;

            @Alias("OrderDetail")
            private  OrderDetail orderDetail;

            @Alias("Refund")
            private  Refund refund;

        }

        @Data
        public  static  class  OrderDetail {
            @Alias("Status")
            private  String status;

            @Alias("SwanSchema")
            private String swanSchema;
        }

        @Data
        public  static  class   Refund {
            @Alias("Amount")
            private  String  amount;

            @Alias("Product")
            private Product[] product;

            @Data
            public  static  class  Product {
                @Alias("ID")
                private  String iD;

                @Alias("Quantity")
                private  int quantity;

                @Alias("Amount")
                private  int amount;
            }

        }
    }

}
