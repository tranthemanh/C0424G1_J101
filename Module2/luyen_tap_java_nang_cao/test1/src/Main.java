import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the width: ");
        rectangle.setWidth(sc.nextDouble());
        System.out.println("Enter the length: ");
        rectangle.setLength(sc.nextDouble());
        System.out.println("Area rectangle: " + rectangle.area());
        System.out.println("Perimeter rectangle: " + rectangle.perimeter());
    }
}
