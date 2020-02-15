package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class OrderInfo {
    String customName;
    String customAddress;
    List<Goods> goodsList;

    public OrderInfo(String customerName, String customerAddress, List<Goods> goodsList) {
        this.customName = customerName;
        this.customAddress = customerAddress;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return customName;
    }

    public String getCustomerAddress() {
        return customAddress;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
}
