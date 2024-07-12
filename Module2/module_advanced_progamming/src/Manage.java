import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    PhoneManager phoneManager = new PhoneManager();

    public void manager() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("|      CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI       |");
            System.out.println("| 1. Thêm mới                                |");
            System.out.println("| 2. Xóa                                     |");
            System.out.println("| 3. Xem danh sách điện thoại                |");
            System.out.println("| 4. Tim kiếm                                |");
            System.out.println("| 0. Exit                                    |");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    phoneManager.add();
                    break;
                case 2:
                    phoneManager.delete();
                    break;
                case 3:
                    phoneManager.displayPhone();
                    break;
                case 4:
                    phoneManager.searchByPhoneName();
                    break;
                case 0:
                    System.out.println("Exiting....");
                    return;
                default:
            }
        }
    }
}
