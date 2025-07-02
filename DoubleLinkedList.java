public class DoubleLinkedList<T> {
    public DoubleNode<T> head;
    public DoubleNode<T> tail;
    public int size;

    public DoubleNode<T> createLinkedList(T value) {
        DoubleNode<T> node = new DoubleNode<>(value);
        head = node;
        tail = node;
        size = 1;
        return node;
    }

    public void insertLinkedList(T value, int position) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (head == null) {
            createLinkedList(value);
            return;
        }
        if (position <= 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (position >= size) {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoubleNode<T> temp = head;
            int index = 0;
            while (index < position - 1) {
                temp = temp.next;
                index++;
            }
            newNode.previous = temp;
            newNode.next = temp.next;
            temp.next.previous = newNode;
            temp.next = newNode;
        }
        size++;
    }
}