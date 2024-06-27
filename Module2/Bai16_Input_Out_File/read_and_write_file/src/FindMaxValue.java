import java.util.ArrayList;
import java.util.List;

public class FindMaxValue {
    public static int findMaxValue(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile rwf = new ReadAndWriteFile();
        List<Integer> list = rwf.readFile("src/numbers.txt");
        int maxValue = findMaxValue(list);
        rwf.writeFile("src/result.txt", maxValue);
    }
}
