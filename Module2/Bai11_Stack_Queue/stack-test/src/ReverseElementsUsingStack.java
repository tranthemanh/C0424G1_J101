import java.util.Arrays;
import java.util.Stack;

public class ReverseElementsUsingStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
    }
}
