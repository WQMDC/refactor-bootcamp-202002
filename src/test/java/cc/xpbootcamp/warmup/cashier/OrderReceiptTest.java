package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        List<Goods> goods = new ArrayList<Goods>() {{
            add(new Goods("巧克力", 21.5, 2));
            add(new Goods("小白菜", 10.00, 1));
        }};

        Date today = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-18");
        OrderReceiptDate orderReceiptDate = new OrderReceiptDate(today);

        OrderReceipt receipt = new OrderReceipt(new Order(goods), orderReceiptDate);

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力，\t21.5x2，\t43.0\n"));
        assertThat(output, containsString("小白菜，\t10.0x1，\t10.0\n"));
        assertThat(output, containsString("税额：5.3\n"));
        assertThat(output, containsString("总价：58.30\n"));
    }

    @Test
    public void shouldPrintTodayInformation() throws ParseException {
        String today = "2020年02月18日，星期二";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        OrderReceiptDate orderReceiptDate = new OrderReceiptDate(format.parse("2020-02-18"));

        Order order = new Order(new ArrayList<Goods>());

        OrderReceipt orderReceipt = new OrderReceipt(order, orderReceiptDate);

        String output = orderReceipt.printReceipt();

        assertThat(output, containsString(today));
    }

    @Test
    public void shouldCalculateDiscount() throws ParseException {
        List<Goods> goods = new ArrayList<Goods>() {{
            add(new Goods("巧克力", 21.5, 2));
            add(new Goods("小白菜", 10.00, 1));
        }};

        Date today = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19");
        OrderReceiptDate orderReceiptDate = new OrderReceiptDate(today);

        OrderReceipt receipt = new OrderReceipt(new Order(goods), orderReceiptDate);

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力，\t21.5x2，\t43.0\n"));
        assertThat(output, containsString("小白菜，\t10.0x1，\t10.0\n"));
        assertThat(output, containsString("税额：5.3\n"));
        assertThat(output, containsString("折扣：1.17\n"));
        assertThat(output, containsString("总价：57.13\n"));
    }
}