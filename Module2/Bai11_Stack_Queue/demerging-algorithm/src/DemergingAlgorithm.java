import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class DemergingAlgorithm  {
    public static void main(String[] args) {
        String inputFile = "D:\\Codegym\\C0424G1_J101\\Module2\\Bai11_Stack_Queue\\demerging-algorithm\\src\\employees.txt";
        String outputFile = "D:\\Codegym\\C0424G1_J101\\Module2\\Bai11_Stack_Queue\\demerging-algorithm\\src\\sorted_employees.txt";

        Queue<Employee> femaleQueue = new LinkedList<>();
        Queue<Employee> maleQueue = new LinkedList<>();

        // Đọc dữ liệu từ file input
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0];
                String gender = parts[1];
                String dob = parts[2];

                Employee employee = new Employee(name, gender, dob);

                if (gender.equalsIgnoreCase("female")) {
                    femaleQueue.add(employee);
                } else if (gender.equalsIgnoreCase("male")) {
                    maleQueue.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ghi dữ liệu ra file output
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (!femaleQueue.isEmpty()) {
                writer.write(femaleQueue.poll().toString());
                writer.newLine();
            }
            while (!maleQueue.isEmpty()) {
                writer.write(maleQueue.poll().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
