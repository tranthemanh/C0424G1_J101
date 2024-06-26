import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Nhập cạnh thứ nhất: ");
            double side1 = sc.nextDouble();

            System.out.println("Nhập cạnh thứ 2: ");
            double side2 = sc.nextDouble();

            System.out.println("Nhập cạnh thứ 3: ");
            double side3 = sc.nextDouble();

            TriangleException triangle = new TriangleException(side1,side2,side3);
            System.out.println("Tam giác hợp lệ với các cạnh: " +
                    triangle.getSide1() + ", " +
                    triangle.getSide2() + ", " +
                    triangle.getSide3());
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Vui lòng nhập số hợp lệ.");
        }
    }
}
