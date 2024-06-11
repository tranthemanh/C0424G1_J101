import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        double a = sc.nextDouble();
        System.out.print("Nhap b: ");
        double b = sc.nextDouble();
        System.out.print("Nhap c: ");
        double c = sc.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        double delta = quadraticEquation.getDiscriminant();

        if(delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co hai nghiem: "+x1+" va "+x2);
        }else if(delta == 0){
            double x1 = -b / (2 * a);
            System.out.println("Phuong trinh co nghiem kep: "+x1);
        }else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }
}