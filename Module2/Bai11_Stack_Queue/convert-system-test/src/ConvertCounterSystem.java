import java.util.Stack;

public class ConvertCounterSystem implements ConvertSystem {
    @Override
    public String convertBinary(int number) {
        Stack<Integer> stack = new Stack<Integer>();
        while (number > 0) {
            int result = number % 2;
            stack.push(result);
            number /= 2;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    @Override
    public String convertOctal(int number) {
        Stack<Integer> stack = new Stack<Integer>();
        while (number > 0) {
            int result = number % 8;
            stack.push(result);
            number /= 8;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    @Override
    public String convertHexadecimal(int number) {
        Stack<Character> stack = new Stack<>();
        while (number > 0) {
            int result = number % 16;
            if (result > 10) {
                stack.push((char) (result + '0'));
            } else {
                stack.push((char) (result - 10 + 'A'));
            }
            number /= 16;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    @Override
    public int convertDecimal(String number) {
        Stack<Character> stack = new Stack<>();
        for (char ch : number.toCharArray()) {
            stack.push(ch);
        }
        int decimalValue = 0;
        int base = 1;

        while (!stack.isEmpty()) {
            char hexChar = stack.pop();
            int value;

            if (hexChar >= '0' && hexChar <= '9') {
                value = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                value = hexChar - 'A' + 10;
            } else if (hexChar >= 'a' && hexChar <= 'f') {
                value = hexChar - 'a' + 10;
            } else {
                throw new IllegalArgumentException("Invalid hex character: " + hexChar);
            }

            decimalValue += value * base;
            base *= 16;
        }
        return decimalValue;
    }
}
