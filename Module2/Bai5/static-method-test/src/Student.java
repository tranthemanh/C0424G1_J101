public class Student {
    private int id;
    private String name;
    private static String group = "Codegym";

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    static void change(){
        group = "CODEGYM";
    }

    void display(){
        System.out.println(id + " " + name + " " + group);
    }
}
