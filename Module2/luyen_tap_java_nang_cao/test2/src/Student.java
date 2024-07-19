public class Student {
    private int id;
    private String name;
    private float pointTL, pointTH;

    public Student(){}

    public Student(int id, String name, float pointTL, float pointTH) {
        this.id = id;
        this.name = name;
        this.pointTL = pointTL;
        this.pointTH = pointTH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPointTL() {
        return pointTL;
    }

    public void setPointTL(float pointTL) {
        this.pointTL = pointTL;
    }

    public float getPointTH() {
        return pointTH;
    }

    public void setPointTH(float pointTH) {
        this.pointTH = pointTH;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pointTL=" + pointTL +
                ", pointTH=" + pointTH +
                '}';
    }

    public float calculateAverageScore(){
        return (pointTL + pointTH) / 2;
    }

    public void showStudent(){
        System.out.printf("%6d %-18s %10.2f %12.2f %12.2f \n", id, name, pointTL, pointTH, calculateAverageScore());
    }
}
