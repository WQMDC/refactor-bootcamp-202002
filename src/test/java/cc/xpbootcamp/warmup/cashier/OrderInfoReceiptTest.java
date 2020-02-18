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
            add(new Goods("巧克力", 21.5, 2));
            add(new Goods("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new OrderInfo(goods), new Date());

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力，\t21.5x2，\t43.0\n"));
        assertThat(output, containsString("小白菜，\t10.0x1，\t10.0\n"));
        assertThat(output, containsString("税额：5.3"));
        assertThat(output, containsString("总价：58.3"));
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