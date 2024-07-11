package manager;

import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    PlayerManager playerManager = new PlayerManager();

    public void manage() {
        while (true) {
            System.out.println("--------------------Menu---------------------");
            System.out.println("| 1. Add player                              |");
            System.out.println("| 2. Update player                           |");
            System.out.println("| 3. Delete player                           |");
            System.out.println("| 4. Display player                          |");
            System.out.println("| 5. Displays the player weekly salary       |");
            System.out.println("| 6. Display players with expired contracts  |");
            System.out.println("| 7. Search player by name                   |");
            System.out.println("| 8. Search player by position               |");
            System.out.println("| 0. Exit                                    |");
            System.out.println("---------------------------------------------");
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
                case 5:
                    playerManager.displayWeeklyWagesDescending();
                    break;
                case 6:
                    playerManager.displayExpiredContracts();
                    break;
                case 7:
                    playerManager.searchByName();
                    break;
                case 8:
                    playerManager.searchByPosition();
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
