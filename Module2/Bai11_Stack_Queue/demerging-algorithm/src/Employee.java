public class Employee {
    String name;
    String gender;
    String dob; // date of birth

    public Employee(String name, String gender, String dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return name + ", " + gender + ", " + dob;
    }
}
