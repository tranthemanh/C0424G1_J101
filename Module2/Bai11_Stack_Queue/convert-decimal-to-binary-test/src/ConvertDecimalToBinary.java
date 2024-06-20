import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static String decimalToBinary(int num) {
        Stack<Integer> stack = new Stack<Integer>();
        while (num > 0) {
            int remainder = num % 2;
            stack.push(remainder);
            num = num / 2;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int decimal = sc.nextInt();

        String binary = decimalToBinary(decimal);
        System.out.println("Số "+ decimal +" trong hệ nhị phân là: "+ binary);
    }
}
