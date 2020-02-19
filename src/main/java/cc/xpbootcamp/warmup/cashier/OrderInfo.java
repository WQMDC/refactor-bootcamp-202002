package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class OrderInfo {
    List<Goods> goodsList;

    public OrderInfo(List<Goods> goodsList) {
        this.goodsList = goodsList;
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

    public StringBuilder getGoodsLineString() {
        StringBuilder output = new StringBuilder();
        for (Goods goods : goodsList) {
            output.append(goods.getName())
                    .append("，")
                    .append("\t")
                    .append(goods.getPrice())
                    .append("x")
                    .append(goods.getQuantity())
                    .append("，")
                    .append("\t")
                    .append(goods.getTotalAmount())
                    .append("\n");
        }
        return output;
    }
}
