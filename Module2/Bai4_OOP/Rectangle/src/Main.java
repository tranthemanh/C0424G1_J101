import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chieu dai: ");
        double width = sc.nextDouble();
        System.out.println("Nhap chieu rong: ");
        double height = sc.nextDouble();

        HinhChuNhat hinhChuNhat = new HinhChuNhat(width,height);

        System.out.println(hinhChuNhat.display());
        System.out.println(hinhChuNhat.getPerimeter());
        System.out.println(hinhChuNhat.getArea());
    }
}