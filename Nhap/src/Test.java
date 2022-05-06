import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ParseException {
//        System.out.println(LocalDate.now());
//        System.out.println(LocalDate.now());
//        String str = toTodayISO(LocalDate.now().toString());
//        System.out.println((str));


//DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
//String strDate = ""
//LocalDateTime localDateTime = LocalDateTime.parse(strDate, df);


        System.out.println(calculateDays("13-05-2022"));
//        Duration duration = Duration.between(now, LocalDate.of(2022,1,12));
////        System.out.println(duration);
//        System.out.println(duration);
    }
public static long calculateDays(String strDate){
    LocalDate now = LocalDate.now();
  String[] str = strDate.split("-");
    LocalDate myDate = LocalDate.of(Integer.parseInt(str[2]),Integer.parseInt(str[1]),Integer.parseInt(str[0]));
    return ChronoUnit.DAYS.between(now,myDate );
}
    public static String toTodayISO(String dateStr){
        String[] todayISOArray = LocalDate.now().toString().split("-");
        String todayISO ="";
        for(int i = 0; i <= todayISOArray.length -1; i++){
            todayISO += todayISOArray[i];
        }
        return todayISO;
    }
}
