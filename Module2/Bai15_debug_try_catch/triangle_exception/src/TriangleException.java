import java.util.Scanner;

public class TriangleException {
    private double side1, side2, side3;

    public TriangleException(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Cạnh tam giác không thể là số âm hoặc bằng 0.");
        }
        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side3 + side2 <= side1) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}
