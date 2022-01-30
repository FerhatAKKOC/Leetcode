package InterviewCollection.CollectionsHard;

import InterviewCollection.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(5);

    }

    private ListNode head;
    private ListNode tail;
    private int capacity;

    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }

    private int get(int key) {

        if (map.containsKey(key)) {
            var node = map.get(key);
            removeFromDLL(node);
            addToDLL(node);
            return node.val;
        }
        return -1;
    }

    private void put(int key, int value) {

        if (map.containsKey(key)) {
            var node = map.get(key);
            removeFromDLL(node);
            addToDLL(node);

        } else if (map.size() >= capacity) {
            // remove last used item.
            var node = tail.prev;
            removeFromDLL(node);
            map.remove(node.val);
        }
        // add new one
        var node = new ListNode(value);
        map.put(value, node);
        addToDLL(node);
    }

    private void removeFromDLL(ListNode node) {

        var next = node.next;
        var prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void addToDLL(ListNode node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

    }

    private void printDLL() {
        ListNode.print(head);
    }


}
