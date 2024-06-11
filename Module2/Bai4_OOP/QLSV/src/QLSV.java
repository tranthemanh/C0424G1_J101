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

    /*
     * Ý Tưởng:
     * Lấy ra vị trí của sinh vien có mã SV tương ứng với mã SV
     * Nếu có vị trí tương ứng thì sẽ thông báo là đã có mã sinh viên
     * Nếu chưa có vị trí tương ứng thì khai bao 1 sinh viên mới với mã sinh vien, tên, email, sdt, pga mới
     * Them sinh vien mới tạo vào danh sách
     */
    public void themSinhVien(){
        if(this.size == this.limit){
            System.out.println("Danh sach sinh vien da day.");
        }else {
            System.out.println("Nhap ma sinh vien: ");
            int maSV = scanner.nextInt();
            scanner.nextLine();
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

    /*
     * Ý Tưởng:
     * Lấy ra vị trí của sinh vien có mã SV tương ứng với mã SV
     * chuyển sinh viên tương ứng xuống cuối mảng
     * Cho sinh vien đó bằng null
     * */
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
            int chon;
            do {
                System.out.println("Ban chac chan muon xoa khong!");
                System.out.println("Chac chan nhan 1");
                System.out.println("Khong muon xoa nhan 2");
                System.out.println("Nhap lua chon: ");
                chon = scanner.nextInt();
                switch (chon){
                    case 1:
                        for (int j = vt; j < this.size - 1; j++) {
                            danhSachSinhVien[j] = danhSachSinhVien[j+1];
                        }
                        danhSachSinhVien[this.size-1] = null;
                        this.size--;
                        System.out.println("Xoa sinh vien thanh cong. ");
                        break;
                }
            }while (chon != 2);

        }
    }

    /*
     * Ý Tưởng:
     * Lấy ra vị trí của sinh vien có mã SV tương ứng với mã SV
     * khai bao 1 sinh viên mới với tên, email, sdt, pga mới
     * Cho sinh vien tương ứng với vị trí bằng sinh viên mới tạo
     * */
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
