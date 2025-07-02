public class UndoRedoManager<T> {
    private DoubleLinkedList<T> list;
    private DoubleNode<T> current;

    public UndoRedoManager() {
        list = new DoubleLinkedList<>();
        current = null;
    }

    public void addState(T value) {
        if (list.head == null) {
            list.createLinkedList(value);
            current = list.head;
        } else {
            // Remove redo states beyond current
            if (current != null && current.next != null) {
                current.next = null;
                list.tail = current;
                list.size = getSizeUpTo(current);
            }
            // Insert new state
            list.insertLinkedList(value, list.size);
            current = list.tail;
        }
    }

    public T undo() {
        if (current != null && current.previous != null) {
            current = current.previous;
            return current.value;
        }
        return null; // no change
    }

    public T redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return current.value;
        }
        return null; // no change
    }

    public T getCurrent() {
        return (current != null) ? current.value : null;
    }

    private int getSizeUpTo(DoubleNode<T> node) {
        int count = 0;
        DoubleNode<T> temp = list.head;
        while (temp != null && temp != node.next) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}