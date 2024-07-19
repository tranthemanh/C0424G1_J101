import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            StudentManager studentManager = new StudentManager();
            Scanner scanner = new Scanner(System.in);
            int studentID;
            while (true) {
                System.out.println("----Enter choice number----");
                System.out.println("1: Add student");
                System.out.println("2: Show list students");
                System.out.println("3: Delete students");
                System.out.println("4: Update students");
                System.out.println("5: Exit");
                System.out.println("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 5) {
                    break;
                }
                switch (choice) {
                    case 1:
                        studentManager.addStudent();
                        break;
                    case 2:
                        studentManager.showListStudent();
                        break;
                    case 3:
                        studentID = Integer.parseInt(scanner.nextLine());
                        studentManager.deleteStudent(studentID);
                        break;
                    case 4:
                        studentID = Integer.parseInt(scanner.nextLine());
                        studentManager.updateStudent(studentID);
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
