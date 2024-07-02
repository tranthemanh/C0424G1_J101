import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(C|A|P)+[0-9]{4,}+(G|H|I|K)+$");
        Matcher m = p.matcher("P0323A");
        boolean b = m.matches();
        System.out.println(b);
    }
}
