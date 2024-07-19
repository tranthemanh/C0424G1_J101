import java.util.Arrays;
import java.util.LinkedList;

public class LinkedlistMy {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.pollFirst();

        list.toArray();
    }
}
