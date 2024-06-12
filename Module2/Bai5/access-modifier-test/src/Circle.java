public class Circle {
    private double radius;
    private String coler;

    public Circle(){
        this.radius = 1.0;
        this.coler = "red";
    }

    public Circle(double radius){
        this.radius = radius;
        this.coler = "red";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
}
