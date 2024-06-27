import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        List<Integer> list = copyFileText.readFile("src/numbers.txt");
        copyFileText.writeFile("src/target.txt", list);
    }
}
