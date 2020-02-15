package cc.xpbootcamp.warmup.cashier;

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

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
        output.append(orderInfo.getCustomerName());
        output.append(orderInfo.getCustomerAddress());

        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (Goods goods : orderInfo.getGoodsList()) {
            output.append(goods.getDescription());
            output.append('\t');
            output.append(goods.getPrice());
            output.append('\t');
            output.append(goods.getQuantity());
            output.append('\t');
            output.append(goods.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = goods.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += goods.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
    }
}