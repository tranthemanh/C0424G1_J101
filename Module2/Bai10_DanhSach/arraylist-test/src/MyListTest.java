public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Size: " + list.size()); // Output: Size: 3
        System.out.println("Element at index 1: " + list.get(1)); // Output: Element at index 1: 2

        list.add(1, 4);
        System.out.println("Element at index 1 after insertion: " + list.get(1)); // Output: Element at index 1 after insertion: 4

        list.remove(1);
        System.out.println("Element at index 1 after removal: " + list.get(1)); // Output: Element at index 1 after removal: 2

        System.out.println("List contains 3: " + list.contains(3)); // Output: List contains 3: true
        System.out.println("Index of 3: " + list.indexOf(3)); // Output: Index of 3: 2

        list.clear();
        System.out.println("Size after clear: " + list.size()); // Output: Size after clear: 0
    }
}
