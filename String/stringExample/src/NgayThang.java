
public class NgayThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("Monday 12 December 2013,a, other fields");
        scanner.useDelimiter(",");

        String dateString = scanner.next();
        //System.out.println(dateString);

        DateFormat formatter = new SimpleDateFormat("EEEE dd MMM yyyy");
        Date date = formatter.parse(dateString);
        //System.out.println(date);
        sale.setDate(sc.next());
    }
}
