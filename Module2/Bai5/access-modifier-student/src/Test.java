public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.getName());
        System.out.println(s.getClasses());

        s.setName("Manh");
        s.setClasses("C02");
        System.out.println(s.getName());
        System.out.println(s.getClasses());
    }
}
