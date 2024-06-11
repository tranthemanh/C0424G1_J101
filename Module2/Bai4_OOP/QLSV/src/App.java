import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLSV qlsv = new QLSV(10);
        int chon;
        do {
            System.out.println("Menu");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Sua thong tin sinh vien");
            System.out.println("0. Exit");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    qlsv.themSinhVien();
                    break;
                case 2:
                    qlsv.hienThiDanhSachSinhVien();
                    break;
                case 3:
                    qlsv.xoaSinhVien();
                    break;
                case 4:
                    qlsv.suaSinhVien();
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true);
    }
}
