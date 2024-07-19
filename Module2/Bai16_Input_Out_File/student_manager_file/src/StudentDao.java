import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String filePath = "students.txt";

    public void writeStudent(List<Student> studentList) {
        try {
            FileOutputStream fow = new FileOutputStream(new File(filePath));
            ObjectOutputStream oow = new ObjectOutputStream(fow);
            oow.writeObject(studentList);

            if (oow == null){
                throw new Exception("File not found");
            }
            oow.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> readStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fir = new FileInputStream(new File(filePath));
            ObjectInputStream oir = new ObjectInputStream(fir);
            studentList = (List<Student>) oir.readObject();

            if (studentList == null){
                throw new Exception("List Student null.");
            }
            oir.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }
}
