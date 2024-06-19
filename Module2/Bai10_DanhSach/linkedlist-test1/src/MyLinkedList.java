public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
        head = null;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        Node holder;
        if (index == 0) {
            addFirst(element);
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        if (temp == null) {
            addFirst(e);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(e);
            numNodes++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node toRemove = temp.next;
            temp.next = toRemove.next;
            numNodes--;
            return (E) toRemove.getData();
        }
    }

    public boolean remove(Object e) {
        if (head == null) return false;
        if (head.getData().equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.getData().equals(e)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public E getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (E) head.getData();
    }

    public E getLast() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public void ensureCapacity(int minCapacity) {
        // This method is irrelevant for linked list as it doesn't require capacity management.
    }

    @Override
    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            cloneList.addLast((E) temp.getData());
            temp = temp.next;
        }
        return cloneList;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
