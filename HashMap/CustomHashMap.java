package HashMap;

class CustomHashMap {
    static class Node {
        int key, value;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets = new Node[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Node node = new Node(key, value);
        node.next = buckets[index];
        buckets[index] = node;
    }

    public Integer get(int key) {
        int index = hash(key);
        Node head = buckets[index];
        while (head != null) {
            if (head.key == key)
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        Node head = buckets[index];
        Node prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev == null)
                    buckets[index] = head.next;
                else
                    prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
