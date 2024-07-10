import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    PlayerManager playerManager = new PlayerManager();

    public void manage() {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Add player");
            System.out.println("2. Update player");
            System.out.println("3. Delete player");
            System.out.println("4. Display player");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    playerManager.add();
                    break;
                case 2:
                    playerManager.update();
                    break;
                case 3:
                    playerManager.delete();
                    break;
                case 4:
                    playerManager.displayPlayer();
                    break;
                case 0:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
