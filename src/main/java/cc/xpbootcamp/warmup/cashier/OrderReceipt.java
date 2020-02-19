package cc.xpbootcamp.warmup.cashier;

import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private static final String TITLE = "======老王超市，值得信赖======";
    private static final String TOTAL_AMOUNT = "总价";
    private static final String TOTAL_TAX = "税额";
    private static final String DISCOUNT = "折扣";
    private static final String DISCOUNT_DAY = "星期三";
    private OrderInfo orderInfo;
    private OrderReceiptDate orderReceiptDate;

    public OrderReceipt(OrderInfo orderInfo, OrderReceiptDate orderReceiptDate) {
        this.orderInfo = orderInfo;
        this.orderReceiptDate = orderReceiptDate;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(TITLE)
                .append("\n")
                .append(getDateString())
                .append("\n")
                .append(getGoodsLineString(orderInfo.getGoodsList()))
                .append(getTotalSalesTaxString());

        boolean isDiscountDay = orderReceiptDate.getWeek().equals(DISCOUNT_DAY);
        if (isDiscountDay) {
            output.append(getDiscountString());
        }

        output.append(getTotalAmountString());
        return output.toString();
    }

    private StringBuilder getDiscountString() {
        StringBuilder output = new StringBuilder();
        double distance = orderInfo.getDistance();
        output.append(DISCOUNT)
                .append("：")
                .append(String.format("%.2f", distance))
                .append("\n");
        return output;
    }

    private StringBuilder getTotalAmountString() {
        StringBuilder output = new StringBuilder();
        double totalAmount = orderInfo.getTotalAmount();
        boolean isDistanceDay = orderReceiptDate.getWeek().equals(DISCOUNT_DAY);
        totalAmount = isDistanceDay ? totalAmount - orderInfo.getDistance() : totalAmount;
        output.append(TOTAL_AMOUNT)
                .append("：")
                .append(String.format("%.2f", totalAmount))
                .append("\n");
        return output;
    }

    private StringBuilder getTotalSalesTaxString() {
        StringBuilder output = new StringBuilder();
        double totalSalesTax = orderInfo.getTotalSalesTax();
        output.append(TOTAL_TAX)
                .append("：")
                .append(totalSalesTax)
                .append("\n");
        return output;
    }

    public StringBuilder getGoodsLineString(List<Goods> goodsList) {
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

    public StringBuilder getDateString() {
        StringBuilder output = new StringBuilder();
        output.append(orderReceiptDate.getToday())
                .append("，")
                .append(orderReceiptDate.getWeek());
        return output;
    }
}