import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerManager {
    private static Scanner sc = new Scanner(System.in);
    private List<Player> playerList;
    private PlayerDao playerDao;
    private Utils utils = new Utils();

    public PlayerManager() {
        playerDao = new PlayerDao();
        playerList = playerDao.read();
    }

    public Player importPlayer() {
        System.out.println("Enter player name: ");
        String name = sc.nextLine();

        LocalDate dob = checkDateOfbirth();

        System.out.println("Enter player height: ");
        double height = Double.parseDouble(sc.nextLine());

        System.out.println("Enter player weight: ");
        double weight = Double.parseDouble(sc.nextLine());

        System.out.println("Enter player shirt number: ");
        int shirtNumber = Integer.parseInt(sc.nextLine());

        System.out.println("Enter player position: ");
        String position = sc.nextLine();

        LocalDate daySign = checkDateSign(dob);

        LocalDate dayExpiration = checkDayExpiration(daySign);

        System.out.println("Enter player daily wage: ");
        double wage = Double.parseDouble(sc.nextLine());

        return new Player(0, name, dob, height, weight, shirtNumber, position, daySign, dayExpiration, wage);
    }

    private LocalDate checkDayExpiration(LocalDate daySign) {
        LocalDate dayExpiration;
        do {
            dayExpiration = utils.readDate("Enter player contract expiration date (dd/MM/yyyy): ");
            if (dayExpiration.isBefore(daySign)) {
                System.out.println("Contract expiration date cannot be earlier than contract signing date. Please enter again.");
            }
        } while (dayExpiration.isBefore(daySign));
        return dayExpiration;
    }

    private LocalDate checkDateSign(LocalDate dob) {
        LocalDate daySign;
        do {
            daySign = utils.readDate("Enter player contract signing date (dd/MM/yyyy): ");
            if (daySign.isBefore(dob)) {
                System.out.println("Contract signing date cannot be earlier than date of birth. Please enter again.");
            } else if (ChronoUnit.YEARS.between(dob, daySign) < 10) {
                System.out.println("Players must be over 10 years old. Please enter again.");
            }
        } while (daySign.isBefore(dob) || ChronoUnit.YEARS.between(dob, daySign) < 10);
        return daySign;
    }

    private LocalDate checkDateOfbirth() {
        LocalDate dob;
        do {
            dob = utils.readDate("Enter player date of birth (dd/MM/yyyy): ");
            if (dob.isAfter(LocalDate.now())) {
                System.out.println("Date of birth cannot be earlier than current date. Please enter again.");
            }
        } while (dob.isAfter(LocalDate.now()));
        return dob;
    }

    public void add() {
        Player newPlayer = importPlayer();
        int id = (playerList.size() > 0) ? (playerList.get(playerList.size() - 1).getId() + 1) : 1;
        newPlayer.setId(id);
        playerList.add(newPlayer);
        playerDao.write(playerList);
    }

    public void update() {
        System.out.println("Enter player ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Player player = findPlayerById(id);

        if (player != null) {
            Player updatedPlayer = importPlayer();
            System.out.println("Do you want to update player information? (1 is yes, 0 is no): ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                updatedPlayer.setId(id);
                int index = playerList.indexOf(player);
                playerList.set(index, updatedPlayer);
                playerDao.write(playerList);
                System.out.println("Player updated successfully.");
            } else {
                System.out.println("Player not updated.");
            }
        } else {
            System.out.println("ID does not exist");
        }
    }

    public void delete() {
        System.out.println("Enter player ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Player player = findPlayerById(id);

        if (player != null) {
            System.out.println("Are you sure you want to delete? (1 is yes, 0 is no): ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                playerList.remove(player);
                updatePlayerIds();
                playerDao.write(playerList);
                System.out.println("Player delete successfully.");
            } else {
                System.out.println("Player not delete.");
            }
        } else {
            System.out.println("ID does not exist");
        }
    }

    public void displayPlayer() {
        if (playerList.isEmpty()) {
            System.out.println("No players to display.");
        } else {
            for (Player player : playerList) {
                System.out.println(player);
            }
        }
    }

    private Player findPlayerById(int id) {
        for (Player player : playerList) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    private void updatePlayerIds() {
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).setId(i + 1);
        }
    }

    public void displayWeeklyWagesDescending() {
        if (playerList.isEmpty()) {
            System.out.println("No players to display.");
        } else {
            sortWeeklyWagesDescending();
            for (Player player : playerList) {
                double weeklyWage = player.getDailyWage() * player.getDaysWorked() / 7.0;
                System.out.println(player.getName() + ": $" + weeklyWage);
            }
        }
    }

    private void sortWeeklyWagesDescending() {
        for (int i = 1; i < playerList.size(); i++) {
            Player key = playerList.get(i);
            double keyWeeklyWage = key.getDailyWage() * key.getDaysWorked() / 7.0;
            int j = i - 1;
            while (j >= 0 && (playerList.get(j).getDailyWage() * playerList.get(j).getDaysWorked() / 7.0) < keyWeeklyWage) {
                playerList.set(j + 1, playerList.get(j));
                j--;
            }
            playerList.set(j + 1, key);
        }
    }

    public void displayExpiredContracts() {
        List<Player> expiredPlayers = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Player player : playerList) {
            if (player.getDayExpiration().isBefore(currentDate)) {
                expiredPlayers.add(player);
            }
        }
        if (expiredPlayers.isEmpty()) {
            System.out.println("No players with expired contracts.");
        } else {
            System.out.println("Players with expired contracts:");
            for (Player player : expiredPlayers) {
                System.out.println(player);
            }
        }
    }

    public void searchByName() {
        System.out.println("Enter player name to search: ");
        String name = sc.nextLine();
        List<Player> results = new ArrayList<>();
        for (Player player : playerList) {
            if (player.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(player);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No players found with name '" + name + "'.");
        } else {
            System.out.println("Players found with name '" + name + "':");
            for (Player player : results) {
                System.out.println(player);
            }
        }
    }

    public void searchByPosition() {
        System.out.print("Enter player position to search: ");
        String position = sc.nextLine();
        List<Player> results = new ArrayList<>();
        for (Player player : playerList) {
            if (player.getPosition().equalsIgnoreCase(position)) {
                results.add(player);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No players found with position '" + position + "'.");
        } else {
            System.out.println("Players found with position '" + position + "':");
            for (Player player : results) {
                System.out.println(player);
            }
        }
    }


}
