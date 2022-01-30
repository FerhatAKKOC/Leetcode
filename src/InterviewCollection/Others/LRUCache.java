package InterviewCollection.Others;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> node_map;
    int capacity;

    public LRUCache(int capacity) {

        node_map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;

        Node node = node_map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int val) {

        Node node = node_map.get(key);

        if (node != null) {
            remove(node);
            node.val = val;
            add(node);
        } else {

            if (node_map.size() == this.capacity) {
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, val);
            add(newNode);
            node_map.put(key, newNode);
        }
    }

    private void add(Node node) {

        Node head_next = head.next;
        node.next = head.next;
        node.prev = head;

        head_next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {

        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }


    private class Node {
        int key = 0;
        int val = 0;
        Node next = null;
        Node prev = null;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
