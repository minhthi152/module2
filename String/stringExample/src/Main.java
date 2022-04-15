import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
//        String input = "0934825467";
//        String pattern = "^098\\d{7}"; //Sđt bắt đầu 098

//        String input = "75-H1 9999";
//        String pattern = "^75-[A-Z]\\d{1} \\d{4}"; //Biển số xe Huế

        String input = "https://facebook.com/ptmthi";
        String pattern = "^https://\w"; //link



        System.out.println(Pattern.matches(pattern, input));
    }
}
