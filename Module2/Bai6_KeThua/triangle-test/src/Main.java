import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap side1: ");
        double side1 = sc.nextDouble();
        System.out.println("Nhap side2: ");
        double side2 = sc.nextDouble();
        System.out.println("Nhap side3: ");
        double side3 = sc.nextDouble();

        System.out.println("Nhap mau cua tam giac: ");
        sc.nextLine();
        String color = sc.nextLine();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);

        System.out.println("Triangulation color: " + triangle.getColor());
        System.out.println("Triangulation area: " + triangle.getArea());
        System.out.println("Triangulation perimeter: " + triangle.getPerimeter());
        System.out.println(triangle.toString());

    }
}
