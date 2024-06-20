import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        // Chuyển đổi chuỗi thành chữ thường để so sánh không phân biệt hoa thường
        str = str.toLowerCase();

        // Khởi tạo Queue và Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Đưa từng ký tự của chuỗi vào Queue và Stack
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) { // chỉ xem xét các ký tự chữ cái
                queue.add(c);
                stack.push(c);
            }
        }

        // So sánh từng cặp ký tự từ Queue và Stack
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false; // Nếu có bất kỳ cặp nào không giống nhau, trả về false
            }
        }

        // Nếu tất cả các cặp đều giống nhau, trả về true
        return true;
    }

    public static void main(String[] args) {
        String str1 = "Able was I ere I saw Elba";
        String str2 = "Hello World";

        System.out.println("Chuỗi \"" + str1 + "\" là Palindrome: " + isPalindrome(str1));
        System.out.println("Chuỗi \"" + str2 + "\" là Palindrome: " + isPalindrome(str2));
    }
}
