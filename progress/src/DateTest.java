

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main (String[] args){
        Calendar c1=Calendar.getInstance();
        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.get(Calendar.MONDAY));
        System.out.println(c1.get(Calendar.DATE));
        System.out.println(c1.get(Calendar.HOUR_OF_DAY));
        System.out.println(c1.get(Calendar.MINUTE));
        System.out.println(c1.get(Calendar.SECOND));

        //java8
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        //毫秒
        System.out.println(c1.getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());

        //某月的最后一天
        System.out.println(c1.getActualMaximum(Calendar.DAY_OF_MONTH));

        //格式化日期
        //老版格式化---java.text.DateFormat
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date d1 = new Date();
        System.out.println(oldFormatter.format(d1));

        //java8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime d2=LocalDateTime.now();
        System.out.println(d2.format(newFormatter));

        //打印昨天的当前时刻
        c1.add(Calendar.DATE,-1);
        System.out.println(c1.getTime());
        //java8
        System.out.println(d2.minusDays(1));
    }
}
