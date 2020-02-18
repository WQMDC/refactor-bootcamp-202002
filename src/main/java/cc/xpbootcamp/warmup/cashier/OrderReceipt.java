package cc.xpbootcamp.warmup.cashier;

import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private OrderInfo orderInfo;

    public OrderReceipt(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======老王超市，值得信赖======\n");

        printCustomerInfo(output);

        List<Goods> goodsList = orderInfo.getGoodsList();
        printGoodsInfo(output, goodsList);
        pintTotalSalesTax(output, goodsList);

        printTotalAmount(output, goodsList);
        return output.toString();
    }

    private void printGoodsInfo(StringBuilder output, List<Goods> goodsList) {
        for (Goods goods : goodsList) {
            output.append(goods.getDescription());
            output.append('\t');
            output.append(goods.getPrice());
            output.append('\t');
            output.append(goods.getQuantity());
            output.append('\t');
            output.append(goods.totalAmount());
            output.append('\n');
        }
    }

    private void printTotalAmount(StringBuilder output, List<Goods> goodsList) {
        double totalAmount = getTotalAmount(goodsList);
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private void pintTotalSalesTax(StringBuilder output, List<Goods> goodsList) {
        double totalSalesTax = getGoodsTotalSalesTax(goodsList);
        output.append("Sales Tax").append('\t').append(totalSalesTax);
    }

    private void printCustomerInfo(StringBuilder output) {
        output.append(orderInfo.getCustomerName());
        output.append(orderInfo.getCustomerAddress());
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