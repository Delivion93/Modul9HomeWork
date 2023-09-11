package Collections;
import java.util.Objects;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {

        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }


    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> node = head;
            for (int i = 1; i < index - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            node = tail;
            for (int i = 1; i < size - index; i++) {
                node = node.prev;
            }
            node.prev = node.prev.prev;
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


    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node;
        if (index > size / 2) {
            node = tail;
            for (int i = 1; i < size - index; i++) {
                node = node.prev;
            }
        } else {
            node = head;
            for (int i = 1; i < index + 1; i++) {
                node = node.next;
            }
        }
        return node.value;
    }

    @Override
    public String toString() {
        int index = size();
        if (index == 0){
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            Node<T> node = head;
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
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }

}