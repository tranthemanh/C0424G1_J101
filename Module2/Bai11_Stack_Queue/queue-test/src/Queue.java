public class Queue implements Solution {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            this.rear.link = this.front;
        } else {
            this.rear.link = newNode;
            this.rear = newNode;
            rear.link = front;
        }
    }

    @Override
    public int deQueue() {
        if (this.front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value;
        if (this.front == this.rear) {
            value = this.front.data;
            this.front = null;
            this.rear = null;
        }else {
            Node temp = this.front;
            value = temp.data;
            this.front = this.front.link;
            this.rear.link = this.front;
        }

        return value;
    }

    @Override
    public void displayQueue() {
        if (this.front == null) {
            System.out.println("Hàng đợi trống!");
            return;
        }

        Node temp = this.front;
        System.out.println("Các phần tử trong hàng đợi là:");
        do {
            System.out.print(temp.data + " ");
            temp = temp.link;
        } while (temp != this.front);
        System.out.println();
    }
}
