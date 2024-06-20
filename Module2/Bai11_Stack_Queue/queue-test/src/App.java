public class App {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);

        queue.displayQueue();

        System.out.println("Phần tử lấy ra: " + queue.deQueue());

        queue.displayQueue();


    }
}
