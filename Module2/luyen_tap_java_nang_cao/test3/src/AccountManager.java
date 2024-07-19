import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    Scanner sc = new Scanner(System.in);
    List<Account> accounts = new ArrayList<Account>();

    public AccountManager() {
    }

    public void themTaiKhoan(){
        System.out.println("Nhap so tai khoan: ");
        long soTaiKhoan = sc.nextLong();
        sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        String tenTaiKhoan = sc.nextLine();
        double soTienHienCo = 50;
        Account account = new Account(soTaiKhoan, tenTaiKhoan, soTienHienCo);
        accounts.add(account);
    }

    public void napTien() {
        double nap;
        System.out.println("Nhap tai khoan nap tien: ");
        long taiKhoanNap = sc.nextLong();
        for (Account account : accounts) {
            if (account.getSoTK() == taiKhoanNap) {
                double soTienHienCo = account.getSoTienTrongTK();
                System.out.println("Enter the amount of nap: ");
                nap = sc.nextDouble();
                if (nap >= 0) {
                    soTienHienCo = soTienHienCo + nap;
                    account.setSoTienTrongTK(soTienHienCo);
                    System.out.println("Ban vua nap " + nap + " vao tai khoan.");
                    System.out.println("So tien hien tai co: " + account.getSoTienTrongTK());
                } else {
                    System.out.println("Nap tien ko hop le.");
                }
            }
        }
    }

    public void rutTien() {
        double rut;
        System.out.println("Nhap tai khoan rut: ");
        long taiKhoanRut = sc.nextLong();
        for (Account account : accounts) {
            if (account.getSoTK() == taiKhoanRut) {
                double soTienHienCo = account.getSoTienTrongTK();
                System.out.println("Nhap so tien can rut: ");
                rut = sc.nextDouble();

                if (soTienHienCo >= rut) {
                    soTienHienCo = soTienHienCo - rut;
                    account.setSoTienTrongTK(soTienHienCo);
                    System.out.println("Ban vua rut " + rut + " thanh cong.");
                    System.out.println("So tien hien tai la " + soTienHienCo);
                } else {
                    System.out.println("Ban khong du so du.");
                }
            }
        }

    }

    public void hienThiTaiKhoan() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void chuyenTien(){
        double soTienTKChuyen, soTienTKNhan, soTienChuyen;
        System.out.println("Nhap so tai khoan chuyen: ");
        long taiKhoanChuyen = sc.nextLong();
        System.out.println("Nhap so tai khoan nhan: ");
        long taiKhoanNhan = sc.nextLong();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getSoTK() == taiKhoanChuyen) {
                soTienTKChuyen = accounts.get(i).getSoTienTrongTK();
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getSoTK() == taiKhoanNhan) {
                        soTienTKNhan = accounts.get(j).getSoTienTrongTK();
                        System.out.println("Nhap so tien can chuyen: ");
                        soTienChuyen = sc.nextDouble();
                        if (soTienChuyen <= soTienTKChuyen){
                            soTienTKChuyen = soTienTKChuyen - soTienChuyen;
                            soTienTKNhan = soTienTKNhan + soTienChuyen;
                            accounts.get(j).setSoTienTrongTK(soTienTKNhan);
                            accounts.get(i).setSoTienTrongTK(soTienTKChuyen);
                            System.out.println("Tai khoan so "+ taiKhoanChuyen + " chuyen "+soTienChuyen+ " thanh cong.");
                            System.out.println("Tai khoan so "+ taiKhoanNhan + " nhan duoc "+soTienChuyen);
                        }else {
                            System.out.println("So tien khong hop le.");
                        }
                    }else {
                        System.out.println("Tai khoan nhan khong dung.");
                    }
                }
            }
        }
    }
}
