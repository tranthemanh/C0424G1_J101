public class Main {
    public static void main(String[] args) {
        // Test Animal và các lớp con
        Animal tiger = new Tiger();
        System.out.println(tiger.makeSound());

        Animal chicken = new Chicken();
        System.out.println(chicken.makeSound());

        // Test Edible interface
        Edible edibleChicken = new Chicken();
        System.out.println(edibleChicken.howToEat());

        Edible orange = new Orange();
        System.out.println(orange.howToEat());

        Edible apple = new Apple();
        System.out.println(apple.howToEat());
    }
}
