import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng các đối tượng hình học
        Circle[] circles = { new Circle(3), new Circle(2), new Circle(4) };
        Rectangle[] rectangles = { new Rectangle(2, 3), new Rectangle(1, 4), new Rectangle(3, 3) };
        Square[] squares = { new Square(2), new Square(1.5), new Square(3) };

        // Sắp xếp và hiển thị các đối tượng Circle
        Arrays.sort(circles);
        System.out.println("Sorted Circles:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        // Sắp xếp và hiển thị các đối tượng Rectangle
        Arrays.sort(rectangles);
        System.out.println("\nSorted Rectangles:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        // Sắp xếp và hiển thị các đối tượng Square
        Arrays.sort(squares);
        System.out.println("\nSorted Squares:");
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
