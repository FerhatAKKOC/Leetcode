package InterviewCollection.Others;/*
https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
 */


import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, Node> mapNode;
    Map<Integer, DLL> mapDLL;

    int capacity;
    int minFreq;
    int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.mapDLL = new HashMap<>();
        this.mapNode = new HashMap<>();
    }

    public int get(int key) {

        var node = mapNode.get(key);
        if (node == null) {
            return -1;
        } else {
            updateMapNode(node);
            return node.val;
        }
    }

    public void put(int key, int val) {

        if (capacity == 0) return;

        Node node = new Node(key, val);

        if (mapNode.containsKey(key)) {
            node = mapNode.get(key);
            node.val = val;
            updateMapNode(node);
        } else {

            if (size == capacity) { //cache is full, remove node from cache and maps
                mapNode.remove(key);
                mapDLL.get(minFreq).removeFromTail();
                size--;
            }

            size++;
            minFreq = 1;

            mapNode.put(key, node);
            var newDll = mapDLL.getOrDefault(node.freq, new DLL());
            newDll.addAtHead(node);
            mapDLL.put(node.freq, new DLL());
        }
    }

    private void updateMapNode(Node node) {

        var currDLL = mapDLL.get(node.freq);
        currDLL.remove(node);

        if (node.freq == minFreq && currDLL.size == 0) // if minFreq list is empty, update it
            minFreq++;

        node.freq++;

        DLL newDLL = mapDLL.getOrDefault(node.freq, new DLL());
        newDLL.addAtHead(node);
        mapDLL.put(node.freq, newDLL);
    }

    class Node {

        int key;
        int val;
        int freq;   // each pair keeps its own frequency separately

        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    /* Doubly Linked List */
    class DLL {

        Node head;
        Node tail;
        int size;

        public DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addAtHead(Node node) {

            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        void removeFromTail() { // To remove least recently used.
            if (size > 0) {
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                size--;
            }
        }
    }
}
