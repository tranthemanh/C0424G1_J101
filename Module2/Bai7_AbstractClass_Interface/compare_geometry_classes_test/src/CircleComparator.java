import java.util.Comparator;

public class CircleComparator implements Comparator<Circle>{
    public int compare(Circle c1, Circle c2) {
        return Double.compare(c1.getArea(), c2.getArea());
    }

}
