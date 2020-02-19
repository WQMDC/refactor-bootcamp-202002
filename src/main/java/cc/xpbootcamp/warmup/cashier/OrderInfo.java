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

    public double getTotalAmount() {
        double goodsTotalAmount = getGoodsTotalAmount();

        double totalSalesTax = getTotalSalesTax();

        return goodsTotalAmount + totalSalesTax;
    }

    private double getGoodsTotalAmount() {
        double goodsTotalAmount = 0d;
        for (Goods goods : goodsList) {
            goodsTotalAmount += goods.getTotalAmount();
        }
        return goodsTotalAmount;
    }

    double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (Goods goods : goodsList) {
            totalSalesTax += this.getGoodsSalesTax(goods.getTotalAmount());
        }
        return totalSalesTax;
    }

    double getGoodsSalesTax(double totalAmount) {
        return totalAmount * .10;
    }

    double getDistance() {
        double totalAmount = getTotalAmount();
        return totalAmount - totalAmount * 0.98;
    }
}
