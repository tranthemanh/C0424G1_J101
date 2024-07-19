import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("src/data.txt");
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten: ");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);
        String dataStudent = student.getId() + "," + student.getName() + "," + student.getAge();

        try {
            FileWriter fw = new FileWriter("src/data.txt");
            fw.write(dataStudent);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("src/data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int idStudent = Integer.parseInt(data[0]);
                String nameStudent = data[1];
                int ageStudent = Integer.parseInt(data[2]);
                Student s1 = new Student(idStudent, nameStudent, ageStudent);
                System.out.println(s1);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
