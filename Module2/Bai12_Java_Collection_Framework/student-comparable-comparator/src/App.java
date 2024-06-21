import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Student student1 = new Student("Manh", 25, "HY");
        Student student2 = new Student("James", 30, "HY");
        Student student3 = new Student("Kohn", 35, "HY");
        Student student4 = new Student("Sames", 15, "HY");

        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(students,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for(Student st : students){
            System.out.println(st.toString());
        }

    }
}
