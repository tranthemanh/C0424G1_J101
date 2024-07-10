import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$");

    public LocalDate readDate(String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.println(prompt);
            String dateStr = scanner.nextLine();
            Matcher matcher = DATE_PATTERN.matcher(dateStr);
            boolean match = matcher.matches();
            if (match == true) {
                try {
                    date = LocalDate.parse(dateStr, DATE_FORMATTER);
                } catch (Exception e) {
                    System.out.println("Invalid date format1111");
                }
            } else {
                System.out.println("Invalid date format");
            }
        }
        return date;
    }
}
