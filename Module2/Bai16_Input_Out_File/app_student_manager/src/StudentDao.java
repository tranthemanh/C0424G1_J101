import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final File myFile = new File("students.txt");

    public List<Student> readStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                Student student = new Student(id, name, age);
                studentList.add(student);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }

    public void writeStudents(List<Student> studentList) {
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getAge() + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> importStudentsFromFile(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                Student student = new Student(id, name, age);
                studentList.add(student);
            }
            bufferedReader.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }

    public void exportStudentsToFile(String fileName, List<Student> studentList) {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getAge() + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
