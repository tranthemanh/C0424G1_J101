import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(20, 30);
        shapes[2] = new Square(15);

        Random random = new Random();

        for (Resizeable shape : shapes) {
            System.out.println("Before resize: " + shape);
            double areaBefore = getArea(shape);
            System.out.println("Area before resize: " + areaBefore);

            double percent = 1 + random.nextInt(100);
            shape.resize(percent);

            System.out.println("After resize: " + shape);
            double areaAfter = getArea(shape);
            System.out.println("Area after resize: " + areaAfter);
            System.out.println("Resize percent: " + percent + "%\n");
        }
    }

    private static double getArea(Resizeable shape) {
        if (shape instanceof Circle) {
            return ((Circle) shape).getArea();
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getArea();
        }
        return 0;
    }
}
