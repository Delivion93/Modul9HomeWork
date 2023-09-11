package Collections;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }


    public void clear() {
        Node<T> node = null;
        head = tail = node;
        size = 0;
    }

    public int size() {
        return size;
    }


    public T peek() {
        if (head == null) {
            throw new IndexOutOfBoundsException("collection is empty");
        }
        return head.value;
    }


    public T poll() {
        if (head == null) {
            throw new IndexOutOfBoundsException("collection is empty");
        }
        Node<T> node = head;
        head = head.next;
        node.next = null;
        size--;
        return node.value;
    }

    @Override
    public String toString() {
        int index = size();
        if (index == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            MyQueue.Node<T> node = head;
            while (index != 0) {
                sb.append(node.value);
                node = node.next;
                index--;
                if (index == 0) {
                    sb.append("]");
                } else {
                    sb.append(", ");
                }
            }
            return String.valueOf(sb);
        }
    }
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}