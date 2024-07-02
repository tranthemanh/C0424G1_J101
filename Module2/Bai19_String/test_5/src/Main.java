import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(\\([0-9]{2,}\\))+(\\-\\(0[0-9]{9}\\))+$");
        Matcher m = p.matcher("(84)-(9978489648)");
        boolean b = m.matches();
        System.out.println(b);
    }
}
