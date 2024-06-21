import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 4);
        System.out.println("Display entries in HashMap: ");
        System.out.println(hashMap+"\n");

        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(16, 0.75f, true);
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);
        linkedHashMap.put("D", 4);
        System.out.println("Display entries in LinkedHashMap: ");
        System.out.println(linkedHashMap.get("A"));

        Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
        System.out.println("Display entries in TreeMap: ");
        System.out.println(treeMap);
    }
}
