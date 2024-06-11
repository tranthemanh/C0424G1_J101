public class Fan {
    //Cac hang so bieu thi toc do quan
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    //Cac truong du lieu
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.color = "blue";
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public boolean isOn(){
        return on;
    }
    public void setOn(boolean on){
        this.on = on;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String toString(){
        if (on){
            return "Fan on"+speed+", color: "+color+", radius: "+radius;
        } else {
            return "Fan off"+speed+", color: "+color+", radius: "+radius;
        }
    }
}
