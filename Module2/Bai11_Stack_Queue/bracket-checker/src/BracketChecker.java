import java.util.Stack;

public class BracketChecker {
    public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // Nếu là dấu ngoặc mở, đưa vào stack
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            }
            // Nếu là dấu ngoặc đóng, kiểm tra stack
            else if (current == ')' || current == ']' || current == '}') {
                // Nếu stack rỗng, biểu thức không hợp lệ
                if (stack.isEmpty()) {
                    return false;
                }

                // Lấy dấu ngoặc mở ra khỏi stack
                char top = stack.pop();

                // Kiểm tra dấu ngoặc có khớp không
                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // Nếu stack vẫn còn dấu ngoặc mở, biểu thức không hợp lệ
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] expressions = {
                "s * (s – a) * (s – b) * (s – c)",            // Well
                "(– b + (b2 – 4*a*c)^0.5) / 2*a",             // Well
                "s * (s – a) * (s – b * (s – c)",             // ???
                "s * (s – a) * s – b) * (s – c)",             // ???
                "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))"            // ???
        };

        for (String expression : expressions) {
            System.out.println("Biểu thức \"" + expression + "\" là: " +
                    (isValidExpression(expression) ? "Hợp lệ" : "Không hợp lệ"));
        }
    }
}
