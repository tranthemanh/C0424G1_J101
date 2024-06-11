import java.util.Arrays;
import java.util.Scanner;

public class QLSV {
    protected Scanner scanner = new Scanner(System.in);
    protected SinhVien[] danhSachSinhVien;
    protected int limit;
    protected int size;

    public QLSV(int limit) {
        this.danhSachSinhVien = new SinhVien[limit];
        this.limit = limit;
        this.size = 0;
    }

    public void themSinhVien(){
        if(this.size == this.limit){
            System.out.println("Danh sach sinh vien da day.");
        }else {
            System.out.println("Nhap ma sinh vien: ");
            int maSV = scanner.nextInt();
            scanner.nextLine();

            //Kiem tra ma sinh vien co ton tai chua
            int vt = -1;
            for (int i = 0; i < this.size; i++) {
                if (danhSachSinhVien[i].getMaSV() == maSV){
                    vt = i;
                }
            }
            if(vt == -1){
                System.out.println("Nhap ten sinh vien: ");
                String tenSV = scanner.nextLine();
                System.out.println("Nhap email sinh vien: ");
                String emailSV = scanner.nextLine();
                System.out.println("Nhap so dien thoai sinh vien: ");
                String soDienThoai = scanner.nextLine();
                System.out.println("Nhap GPA sinh vien: ");
                double gpaSV = scanner.nextDouble();
                SinhVien sinhVien = new SinhVien(maSV, tenSV, emailSV, soDienThoai, gpaSV);
                danhSachSinhVien[this.size] = sinhVien;
                this.size++;
            }else {
                System.out.println("Ma sinh vien da ton tai.");
                System.out.println("Yeu cau chon them lai.");
            }

        }
    }

    public void hienThiDanhSachSinhVien(){
        if (size == 0){
            System.out.println("Khong co hoc sinh nao trong danh sach.");
        }else {
            System.out.println("Danh sach sinh vien: ");
            for (SinhVien sinhVien : danhSachSinhVien) {
                if (sinhVien != null){
                    System.out.println(sinhVien);
                }
            }
        }
    }

    public void xoaSinhVien(){
        int vt = -1;
        System.out.println("Nhap ma sinh vien can xoa: ");
        int maSV = scanner.nextInt();
        for (int i = 0; i < this.size; i++) {
            if (danhSachSinhVien[i].maSV == maSV){
                vt = i;
            }
        }
        if(vt == -1){
            System.out.println("Khong co sinh vien nao phu hop.");
        }else {
            for (int j = vt; j < this.size - 1; j++) {
                danhSachSinhVien[j] = danhSachSinhVien[j+1];
            }
            danhSachSinhVien[this.size-1] = null;
            this.size--;
            System.out.println("Xoa sinh vien thanh cong. ");
        }
    }

    public void suaSinhVien(){
        int vt = -1;
        System.out.println("Nhap ma sinh vien can sua: ");
        int maSV = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < this.size; i++)
            if (danhSachSinhVien[i].getMaSV() == maSV) {
                vt = i;
            }
        if (vt == -1){
            System.out.println("Khong co sinh vien nao phu hop.");
        }else {
            System.out.println("Nhap ten sinh vien: ");
            String tenSV = scanner.nextLine();
            System.out.println("Nhap email sinh vien: ");
            String emailSV = scanner.nextLine();
            System.out.println("Nhap so dien thoai sinh vien: ");
            String soDienThoai = scanner.nextLine();
            System.out.println("Nhap diem GPA sinh vien: ");
            double gpaSV = scanner.nextDouble();

            SinhVien sinhVien = new SinhVien(maSV, tenSV, emailSV, soDienThoai, gpaSV);
            danhSachSinhVien[vt] = sinhVien;
            System.out.println("Sua sinh vien thanh cong. ");
        }
    }
}
