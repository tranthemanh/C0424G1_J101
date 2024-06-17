public class Main {
    public static void main(String[] args) {
        //Kiem tra lop Point2D
        Point2D point2D1 = new Point2D();
        System.out.println(point2D1);

        Point2D point2D2 = new Point2D(3.5f, 3.5f);
        System.out.println(point2D2);

        point2D2.setX(4.0f);
        point2D2.setY(5.0f);
        System.out.println(point2D2);

        point2D2.setXY( 1.0f, 2.0f);
        System.out.println(point2D2);

        float[] xy = point2D2.getXY();
        System.out.println("X: " + xy[0] + ", Y: " + xy[1]);

        //Kiem tra lop Point3D
        Point3D point3D1 = new Point3D();
        System.out.println(point3D1);

        Point3D point3D2 = new Point3D(3.5f, 3.5f, 3.5f);
        System.out.println(point3D2);

        point3D2.setX(4.0f);
        point3D2.setY(5.0f);
        point3D2.setZ(6.0f);
        System.out.println(point3D2);

        point3D2.setXYZ( 1.0f, 2.0f, 3.0f);
        System.out.println(point3D2);

        float[] xyz = point3D2.getXYZ();
        System.out.println("X: " + xy[0] + ", Y: " + xy[1]+ ", Z: " + xyz[2]);
    }
}
