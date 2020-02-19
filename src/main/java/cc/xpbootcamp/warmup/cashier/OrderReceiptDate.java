package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OrderReceiptDate {
    private Date receiptDate;

    public OrderReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getWeek() {
        return new SimpleDateFormat("EEEE", Locale.CHINA).format(receiptDate);
    }

    public String getToday() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(receiptDate);
    }
}
