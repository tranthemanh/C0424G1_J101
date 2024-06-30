import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static Scanner sc = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDao studentDao;


    public StudentManager() {
        studentDao = new StudentDao();
        studentList = studentDao.readStudents();
    }


    public void addStudent() {
        System.out.println("Enter student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student age: ");
        int age = Integer.parseInt(sc.nextLine());
        Student newStudent = new Student(id, name, age);
        studentList.add(newStudent);
        studentDao.writeStudents(studentList);
    }

    public void updateStudent() {
        boolean flag = false;
        System.out.println("Enter student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : studentList) {
            if (student.getId() == id) {
                flag = true;
                System.out.println("Enter student name: ");
                String name = sc.nextLine();
                System.out.println("Enter student age: ");
                int age = Integer.parseInt(sc.nextLine());
                student.setName(name);
                student.setAge(age);
                break;
            }
        }
        if (!flag) {
            System.out.println("ID does not exist");
        } else {
            studentDao.writeStudents(studentList);
        }
    }

    public void deleteStudent() {
        Student studentToDelete = null;
        System.out.println("Enter student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student1 : studentList) {
            if (student1.getId() == id) {
                studentToDelete = student1;
                break;
            }
        }
        if (studentToDelete != null) {
            studentList.remove(studentToDelete);
            studentDao.writeStudents(studentList);
        } else {
            System.out.println("ID does not exist");
        }
    }

    public void showStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void importStudents() {
        System.out.println("Enter file name to import from: ");
        String fileName = sc.nextLine();
        List<Student> importedStudents = studentDao.importStudentsFromFile(fileName);
        studentList.addAll(importedStudents);
        studentDao.writeStudents(studentList);
    }

    public void exportStudents() {
        System.out.println("Enter file name to export to: ");
        String fileName = sc.nextLine();
        studentDao.exportStudentsToFile(fileName, studentList);
    }

}
