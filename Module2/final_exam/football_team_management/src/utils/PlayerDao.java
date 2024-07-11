package utils;

import model.Player;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    private static final String PLAYER_FILE_NAME = "players.txt";

    public void write(List<Player> playerList) {
        try {
            FileWriter fileWriter = new FileWriter(PLAYER_FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Player player : playerList) {
                bufferedWriter.write(player.getId() + "," + player.getName() + "," + player.getDob() + "," + player.getHeight() + "," + player.getWeight() + "," + player.getShirtNumber() + "," + player.getPosition() + "," + player.getDaySign() + "," + player.getDayExpiration() + "," + player.getDailyWage() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Player> read() {
        List<Player> playerList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(PLAYER_FILE_NAME);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                LocalDate dob = LocalDate.parse(data[2]);
                double height = Double.parseDouble(data[3]);
                double weight = Double.parseDouble(data[4]);
                int shirtNumber = Integer.parseInt(data[5]);
                String position = data[6];
                LocalDate daySign = LocalDate.parse(data[7]);
                LocalDate dayExpiration = LocalDate.parse(data[8]);
                double dailyWage = Double.parseDouble(data[9]);
                Player player = new Player(id, name, dob, height, weight, shirtNumber, position, daySign, dayExpiration, dailyWage);
                playerList.add(player);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return playerList;
    }
}
