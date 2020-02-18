package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class OrderInfo {
    List<Goods> goodsList;

    public OrderInfo(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
}
