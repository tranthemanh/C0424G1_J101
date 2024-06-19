public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        System.out.println("Size: " + list.size()); // Output: Size: 3
        list.printList(); // Output: 1 2 3

        list.addFirst(0);
        list.printList(); // Output: 0 1 2 3

        list.addLast(4);
        list.printList(); // Output: 0 1 2 3 4

        list.remove(2);
        list.printList(); // Output: 0 1 3 4

        System.out.println("Contains 3: " + list.contains(3)); // Output: Contains 3: true
        System.out.println("Index of 3: " + list.indexOf(3)); // Output: Index of 3: 2

        list.clear();
        System.out.println("Size after clear: " + list.size()); // Output: Size after clear: 0
    }
}
