//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//
//import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
//
//public class Bien {
//
//    public static void main(String[] args) {
//
////        LocalDateTime localDate = LocalDateTime.now();//For reference
////
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
////        String formattedString = LocalDateTime.now().format(formatter);
////
////
////        System.out.println(formattedString);
//
//        String lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
//        System.out.println(lastUpdate);
//
//        String date = "2016-08-16";
//
//        //default, ISO_LOCAL_DATE
//        LocalDate localDate = LocalDate.parse(date);
//
//        System.out.println(localDate);
//
//       class DateValidatorUsingDateTimeFormatter implements DateValidator {
//            private DateTimeFormatter dateFormatter;
//
//            public DateValidatorUsingDateTimeFormatter(DateTimeFormatter dateFormatter) {
//                this.dateFormatter = dateFormatter;
//            }
//
//            public boolean isValid(String dateStr) {
//                try {
//                    this.dateFormatter.parse(dateStr);
//                } catch (DateTimeParseException e) {
//                    return false;
//                }
//                return true;
//            }
//
//
//        }
//    }
//}