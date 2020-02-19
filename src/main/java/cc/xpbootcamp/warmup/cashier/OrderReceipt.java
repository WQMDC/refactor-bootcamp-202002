package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    private Date receiptDate;

    public OrderReceipt(OrderInfo orderInfo, Date receiptDate) {
        this.orderInfo = orderInfo;
        this.receiptDate = receiptDate;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(TITLE)
                .append("\n")
                .append(getDateString())
                .append("\n")
                .append(orderInfo.getGoodsLineString())
                .append(getTotalSalesTaxString());

        boolean isDiscountDay = getWeek().equals(DISCOUNT_DAY);
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

    private StringBuilder getDateString() {
        StringBuilder output = new StringBuilder();
        output.append(getToday())
                .append("，")
                .append(getWeek());
        return output;
    }

    private String getWeek() {
        return new SimpleDateFormat("EEEE", Locale.CHINA).format(receiptDate);
    }

    private String getToday() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(receiptDate);
    }

    private StringBuilder getTotalAmountString() {
        StringBuilder output = new StringBuilder();
        double totalAmount = orderInfo.getTotalAmount();
        boolean isDistanceDay = getWeek().equals(DISCOUNT_DAY);
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

}