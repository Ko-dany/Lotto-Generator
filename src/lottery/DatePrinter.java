package lottery;

import java.util.Calendar;

public class DatePrinter {
    public static void printDateTime(Calendar cal){
        // Retrieve the current time information

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
    }
}
