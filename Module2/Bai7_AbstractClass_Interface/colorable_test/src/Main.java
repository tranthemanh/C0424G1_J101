public class Main {
    public static void main(String[] args) {
        // Tạo mảng các đối tượng hình học
        Shape[] shapes = {
                new Circle(3),
                new Rectangle(2, 3),
                new Square(2),
                new Square(3)
        };

        // Hiển thị diện tích và kiểm tra Colorable
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
