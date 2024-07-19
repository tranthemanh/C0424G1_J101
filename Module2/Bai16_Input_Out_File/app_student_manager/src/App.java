import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Import students from file:");
            System.out.println("6. Export students to file:");
            System.out.println("7. Exit");
            System.out.println("Nhap lua chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.updateStudent();
                    break;
                case 3:
                    studentManager.deleteStudent();
                    break;
                case 4:
                    studentManager.showStudents();
                    break;
                case 5:
                    studentManager.importStudents();
                    break;
                case 6:
                    studentManager.exportStudents();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }
}
