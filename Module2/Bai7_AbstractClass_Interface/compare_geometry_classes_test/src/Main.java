import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng các đối tượng hình học
        Circle[] circles = { new Circle(3), new Circle(2), new Circle(4) };
        Rectangle[] rectangles = { new Rectangle(2, 3), new Rectangle(1, 4), new Rectangle(3, 3) };
        Square[] squares = { new Square(2), new Square(1.5), new Square(3) };

        // Sắp xếp và hiển thị các đối tượng Circle
        Arrays.sort(circles, new CircleComparator());
        System.out.println("Sorted Circles:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        // Triển khai Comparator cho Rectangle và Square và kiểm thử
        Comparator<Rectangle> rectangleComparator = new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle r1, Rectangle r2) {
                return Double.compare(r1.getArea(), r2.getArea());
            }
        };

        Comparator<Square> squareComparator = new Comparator<Square>() {
            @Override
            public int compare(Square s1, Square s2) {
                return Double.compare(s1.getArea(), s2.getArea());
            }
        };

        // Sắp xếp và hiển thị các đối tượng Rectangle
        Arrays.sort(rectangles, rectangleComparator);
        System.out.println("\nSorted Rectangles:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        // Sắp xếp và hiển thị các đối tượng Square
        Arrays.sort(squares, squareComparator);
        System.out.println("\nSorted Squares:");
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
