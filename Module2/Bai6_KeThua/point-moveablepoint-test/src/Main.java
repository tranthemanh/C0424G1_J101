public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println("Point: " + point);
        point.setXY(5.0f, 6.0f);
        System.out.println("Updated Point: " + point);

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println("MoveablePoint: " + moveablePoint);
        moveablePoint.move();
        System.out.println("Moved MoveablePoint: " + moveablePoint);
    }
}
