public class RectangeleTest {
    public static void main(String[] args) {
        Rectangele rectangele = new Rectangele();
        System.out.println(rectangele);

        rectangele= new Rectangele(2.0, 2.0);
        System.out.println(rectangele);

        rectangele = new Rectangele(2.0, 2.0, "orange", true);
        System.out.println(rectangele);
    }
}
