import java.util.Arrays;
import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        Stack<String> wStack = new Stack<String>();
        String[] mWord = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] newWord = new String[mWord.length];
        for (int i = 0; i < mWord.length; i++) {
            wStack.push(mWord[i]);
        }
        for (int i = 0; i < newWord.length; i++) {
            newWord[i] = wStack.pop();
        }
        System.out.println(Arrays.toString(mWord));
        System.out.println(Arrays.toString(newWord));
    }
}
