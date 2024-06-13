public class Rectangele extends Shape{
    private double width = 1.0;
    private double length = 1.0;

    public Rectangele(){}

    public Rectangele(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangele(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    public double getPerimeter(){
        return 2*width+2*length;
    }

    @Override
    public String toString() {
        return "Rectangele{" +
                "width=" + width +
                ", length=" + length +
                super.toString()+
                '}';
    }
}
