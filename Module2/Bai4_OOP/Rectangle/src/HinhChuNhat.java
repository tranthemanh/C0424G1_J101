public class HinhChuNhat {
    double width;
    double height;

    public HinhChuNhat() {
    }

    public HinhChuNhat(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width * this.height) * 2;
    }

    public String display() {
        return "HCN{width=" + this.width + ", height=" + this.height + "}";
    }
}
