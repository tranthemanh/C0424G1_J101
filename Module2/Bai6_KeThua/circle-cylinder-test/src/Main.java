public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle2 = new Circle(2.5);
        System.out.println(circle2);

        Circle circle3 = new Circle(3.5, "blue");
        System.out.println(circle3);

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        Cylinder cylinder2 = new Cylinder(2.5);
        System.out.println(cylinder2);

        Cylinder cylinder3 = new Cylinder(3.5, 4.5);
        System.out.println(cylinder3);

        Cylinder cylinder4 = new Cylinder(4.5, 5.5, "green");
        System.out.println(cylinder4);
    }
}
