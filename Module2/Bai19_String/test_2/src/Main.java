import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[_a-z0-9]{6,}$");
        Matcher matcher = pattern.matcher("abcde");
        boolean found = matcher.matches();
        System.out.println(found);
    }
}
