import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập x:");
        int x = sc.nextInt();
        System.out.println("Nhập y: ");
        int y = sc.nextInt();
        CalculationExample cal = new CalculationExample();
        cal.calculate(x,y);
    }
    public void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = "+a);
            System.out.println("Hiệu x - y = "+b);
            System.out.println("Tích x * y = "+c);
            System.out.println("Thương x / y = "+d);
        }catch (Exception e) {
            System.out.println("Xảy ra ngoại lệ: "+e.getMessage());
        }
    }
}
