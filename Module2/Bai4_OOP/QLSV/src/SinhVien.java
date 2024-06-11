public class SinhVien {
    protected int maSV;
    protected String tenSV;
    protected String email;
    protected String phone;
    protected double GPA;

    public SinhVien(int maSV, String tenSV, String email, String phone, double GPA) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.email = email;
        this.phone = phone;
        this.GPA = GPA;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV=" + maSV +
                ", tenSV='" + tenSV + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}
