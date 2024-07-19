import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AccountManager accountManager = new AccountManager();

        int chonce;
        do {
            System.out.println("Menu");
            System.out.println("1. Them tai khoan.");
            System.out.println("2. Nap tien.");
            System.out.println("3. Rut tien.");
            System.out.println("4. Hien thi tai khoan.");
            System.out.println("5. Chuyen tien.");
            System.out.println("0. Thoat.");
            System.out.println("Nhap lua chon: ");
            chonce = sc.nextInt();
            switch (chonce) {
                case 1:
                    accountManager.themTaiKhoan();
                    break;
                case 2:
                    accountManager.napTien();
                    break;
                case 3:
                    accountManager.rutTien();
                    break;
                case 4:
                    accountManager.hienThiTaiKhoan();
                    break;
                case 5:
                    accountManager.chuyenTien();
                    break;
                case 0:
                    System.exit(0);
            }
        }while (chonce != 0);
    }
}
