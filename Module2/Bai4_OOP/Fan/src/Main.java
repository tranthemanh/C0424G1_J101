public class Main {


    public static void main(String[] args) {
        //Tao doi tuong Fan 1
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        //Tao doi tuong Fan 2
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        //Hien thi thong tin cua hai doi tuong Fan
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
