public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1,"Manh", 10, 10);
        Student student2 = new Student(2,"Quan", 10, 10);
        Student student3 = new Student(3,"Nguyen", 10, 10);

        System.out.printf("%6s %10s %20s %10s %10s \n","Mã sinh viên","Họ tên","Điểm lý thuyết","Điểm thực hành","Điểm trung bình");
        student1.showStudent();
        student2.showStudent();
        student3.showStudent();
    }
}
