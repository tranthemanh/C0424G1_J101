public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "M3");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Mercedes", "Maybach");
        System.out.println(Car.numberOfCars);
    }
}
