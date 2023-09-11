package Collections;
import java.util.Objects;

public class MyStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;



    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (size == 1) {
            head = tail = null;
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
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
        return tail.value;
    }

    public T pop() {
        T lastValue;
        if (size == 1) {
            lastValue = head.value;
            head = tail = null;
        } else {
            Node<T> prev = getNodeByIndex(size() - 2);
            lastValue = tail.value;
            prev.next = prev.next.next;
            tail = prev;
        }
        size--;
        return lastValue;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        int index = size();
        if (index == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            MyStack.Node<T> node = head;
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
    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

}