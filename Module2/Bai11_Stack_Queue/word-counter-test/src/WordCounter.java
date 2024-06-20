import java.util.Map;
import java.util.TreeMap;

public class WordCounter {
    public static void countWords(String str) {
        str = str.toLowerCase();

        String[] words = str.split("\\W+");

        Map<String, Integer> wordMap = new TreeMap<>();

        for (String word : words) {
            if(word.isEmpty()) {
                continue;
            }
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            }else {
                wordMap.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        String str = "Xin chao, toi la manh day. Xin chao cac ban";
        countWords(str);
    }
}
