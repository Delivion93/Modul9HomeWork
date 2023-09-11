package Collections;
import java.util.Objects;

public class MyHashMap<K, V> {
    private final int DEFAULT_SIZE = 8;
    private int nodeNumber;
    private int bucketsNumber = DEFAULT_SIZE;
    private Entry<K, V>[] buckets = new Entry[bucketsNumber];

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        Entry<K, V> entry = new Entry<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = entry;
        } else {
            Entry<K, V> pointer = buckets[index];
            while (pointer.next != null && !entry.key.equals(pointer.next.key)) {
                pointer = pointer.next;
            }
            if (pointer.next == null && entry.key.equals(pointer.key)) {
                buckets[index] = entry;
            } else if (pointer.next == null) {
                pointer.next = entry;
            } else {
                entry.next = pointer.next.next;
                pointer.next.next = null;
                pointer.next = entry;
            }
        }
        nodeNumber++;
    }


    public void remove(K key) {
        int index = hashFunction(key);
        Entry<K, V> entry = buckets[index];
        if (entry == null) {
            throw new IndexOutOfBoundsException("This key: " + key + "doesn't exist");
        } else if (key.equals(entry.key)) {
            buckets[index] = entry.next;
            entry.next = null;
        } else {
            while (entry.next != null && !entry.next.key.equals(key)) {
                entry = entry.next;
            }
            if (entry.next == null) {
                throw new IndexOutOfBoundsException("This key: " + key + " doesn't exist");
            } else {
                entry.next = entry.next.next;
                entry.next.next = null;
            }
        }
        nodeNumber--;
    }


    public void clear() {
        buckets = null;
    }


    public int size() {
        return nodeNumber;
    }

    public V get(K key) {
        int index = hashFunction(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }
        if (entry == null) {
            throw new IndexOutOfBoundsException("This key: " + key + " doesn't exist");
        }
        return entry.value;
    }

    private int hashFunction(K key) {
        return Math.abs(Objects.hash(key) % bucketsNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> entry = buckets[i];
            while (entry != null) {
                sb.append(entry.value);
                if (entry.next == null) {
                    sb.append("\n");
                } else {
                    sb.append(", ");
                }
                entry = entry.next;
            }
        }
        return String.valueOf(sb);
    }
}