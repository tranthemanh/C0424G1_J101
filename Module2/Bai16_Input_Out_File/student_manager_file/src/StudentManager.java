import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDao studentDao;

    public StudentManager(){
        studentDao = new StudentDao();
        studentList = studentDao.readStudent();
    }

    public void addStudent() {
        System.out.println("----------Enter student information------");
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " + id);
        System.out.println("Enter name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        Student s = new Student(id, name, age);
        studentList.add(s);
        studentDao.writeStudent(studentList);
    }

    public void showListStudent() {
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    public void deleteStudent(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++){
            if (studentList.get(i).getId() == id){
                student = studentList.get(i);
                break;
            }
        }
        if (student != null){
            studentList.remove(student);
            studentDao.writeStudent(studentList);
        }else {
            System.out.println("Student not found");
        }
    }

    public void updateStudent(int id) {
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++){
            if (studentList.get(i).getId() == id){
                isExisted = true;
                studentList.get(i).setName(nameStudent());
                studentList.get(i).setAge(ageStudent());
                break;
            }
        }
        if (!isExisted){
            System.out.println("Student not found");
        }else {
            studentDao.writeStudent(studentList);
        }
    }

    private int ageStudent() {
        System.out.println("Enter age: ");
        return scanner.nextInt();
    }

    private String nameStudent() {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }
}
