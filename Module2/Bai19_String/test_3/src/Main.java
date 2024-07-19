import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/top100/top-100-nhac-tre.m3liaiy6vVsF.html");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
            httpURLConnection.connect();

            InputStreamReader input = new InputStreamReader(httpURLConnection.getInputStream());
            Scanner scanner = new Scanner(input);
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile("name_singer\"(.*?)>(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
