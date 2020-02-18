package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderInfoReceiptTest {
    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<Goods> goods = new ArrayList<Goods>() {{
            add(new Goods("milk", 10.0, 2));
            add(new Goods("biscuits", 5.0, 5));
            add(new Goods("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new OrderInfo(goods), new Date());

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
    }

    @Test
    public void shouldPrintTodayInformation() throws ParseException {
        String today = "2020年02月19日，星期三";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        OrderInfo orderInfo = new OrderInfo(new ArrayList<Goods>());
        OrderReceipt orderReceipt = new OrderReceipt(orderInfo, format.parse("2020-02-19"));
        String output = orderReceipt.printReceipt();

        assertThat(output, containsString(today));
    }

}