package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private static final String TITLE = "======老王超市，值得信赖======";
    private static final String TOTAL_AMOUNT = "总价";
    private static final String TOTAL_TAX = "税额";
    private OrderInfo orderInfo;
    private Date receiptDate;

    public OrderReceipt(OrderInfo orderInfo, Date receiptDate) {
        this.orderInfo = orderInfo;
        this.receiptDate = receiptDate;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(TITLE + "\n");

        printTodayInformation(output);
        output.append("\n");

        List<Goods> goodsList = orderInfo.getGoodsList();
        printGoodsInfo(output, goodsList);

        pintTotalSalesTax(output, goodsList);

        printTotalAmount(output, goodsList);
        return output.toString();
    }

    private void printTodayInformation(StringBuilder output) {
        output.append(getToday() + "，" + getWeek());
    }

    private String getWeek() {
        return new SimpleDateFormat("EEEE").format(receiptDate);
    }

    private String getToday() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(receiptDate);
    }

    private void printGoodsInfo(StringBuilder output, List<Goods> goodsList) {
        for (Goods goods : goodsList) {
            output.append(goods.getName() + "，");
            output.append("\t");
            output.append(goods.getPrice() + "x" + goods.getQuantity() + "，");
            output.append("\t");
            output.append(goods.totalAmount());
            output.append('\n');
        }
    }

    private void printTotalAmount(StringBuilder output, List<Goods> goodsList) {
        double totalAmount = getTotalAmount(goodsList);
        output.append(TOTAL_AMOUNT + "：").append(totalAmount);
    }

    private void pintTotalSalesTax(StringBuilder output, List<Goods> goodsList) {
        double totalSalesTax = getGoodsTotalSalesTax(goodsList);
        output.append(TOTAL_TAX + "：").append(totalSalesTax);
    }

    private double getGoodsTotalSalesTax(List<Goods> goodsList) {
        double totalSalesTax = 0d;
        for (Goods goods : goodsList) {
            totalSalesTax += getGoodsSalesTax(goods.totalAmount());
        }
        return totalSalesTax;
    }

    private double getGoodsSalesTax(double totalAmount) {
        return totalAmount * .10;
    }

    private double getTotalAmount(List<Goods> goodsList) {
        double totalAmount = 0d;
        for (Goods goods : goodsList) {
            double salesTax = getGoodsSalesTax(goods.totalAmount());
            totalAmount += goods.totalAmount() +  salesTax;
        }
        return  totalAmount;
    }
}