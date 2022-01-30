package InterviewCollection.Others;

import java.util.HashMap;

/**
 * Custom implementation of MRU cache
 * NOTE : Only the eviction differs in LRU and MRU
 *
 * @author Deepak
 */
public class MRUCache<K, V> {

    private HashMap<K, Node<K, V>> cache = new HashMap<>();
    private Node<K, V> head, tail;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 100;
    public MRUCache() {
        setCapacity(DEFAULT_CAPACITY);
    }
    public MRUCache(int capacity) {
        setCapacity(capacity);
    }


    public V get(K key) {

        if (!cache.containsKey(key)) {
            return null;
        }
        /* If key exists, get the key and return the value */
        Node<K, V> node = cache.get(key);
        /* Since this node is least recently used now, move it to the end.
         * When eviction will happen, this will be the last entry to be removed.
         * Removal will happen at tail. */
        moveNodeToLast(node);
        return node.getValue();
    }

    public void put(K key, V value) {
        /* If cache contains the key, find that key value pair,
         * Since this is a map and only key is same. Value can be different.
         * Replace this current value and push this node to end as we have
         * accessed it already */
        if (cache.containsKey(key)) {
            Node<K, V> existing = cache.get(key);
            existing.setValue(value);
            moveNodeToLast(existing);
            return;
        }
        /* If cache has reached the capacity,
         * evict the MRU node and remove it from cache */
        Node<K, V> newNode;
        if (cache.size() == capacity) {
            newNode = evict();
            cache.remove(newNode.getKey());
        } else {
            newNode = new Node<>();
        }
        /* Create this new node, set key and values.
         * Add this node to appropriate place and put in cache */
        newNode.setKey(key);
        newNode.setValue(value);
        addNewNode(newNode);
        cache.put(key, newNode);
    }

    public void setCapacity(int capacity) {
        /* Check if capacity is valid */
        checkCapacity(capacity);
        /* Now, start from the end and begin evicting
         * until we meet the new capacity. Remove
         * entries from cache as well */
        for (int i = cache.size(); i > capacity; i--) {
            Node<K, V> evicted = evict();
            cache.remove(evicted.getKey());
        }
        this.capacity = capacity;
    }

    public int size() {
        return cache.size();
    }

    public int getCapacity() {
        return capacity;
    }


    private void addNewNode(Node<K, V> node) {
        /* If cache is empty, both head and tail
         * points to same new node */
        if (cache.isEmpty()) {
            head = tail = node;
            return;
        }
        /* Else, append the new node to tail and
         * update the position of tail */
        tail.setNext(node);
        node.setPrev(tail);
        node.setNext(null);
        tail = node;
    }

    private Node<K, V> evict() {
        /* If cache is empty, nothing to evict */
        if (head == null) {
            throw new AssertionError("Cannot evict from an empty cache!!");
        }
        /* Evict the tail, update next and evicted node */
        Node<K, V> evicted = tail;
        tail = evicted.getPrev();
        tail.setNext(null);
        evicted.setNext(null);
        return evicted;
    }

    private void checkCapacity(int capacity) {
        /* Invalid capacity if less then 0 */
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid Capacity. Should be positive!!");
        }
    }

    private void moveNodeToLast(Node<K, V> node) {
        /* If node is already at last, nothing to process */
        if (tail == node) {
            return;
        }
        /* Update previous and next nodes */
        Node<K, V> prev = node.getPrev();
        Node<K, V> next = node.getNext();
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
        /* Update head and tail position */
        if (head == node) {
            head = next;
        }
        tail.setNext(node);
        node.setPrev(tail);
        node.setNext(null);
        tail = node;
    }


    public static class Node<T, U> {

        /* Variables to store key, value and pointers to next and previous nodes */
        private Node<T, U> prev;
        private Node<T, U> next;
        private T key;
        private U value;

        public Node() {}

        public Node(Node<T, U> prev, Node<T, U> next, T key, U value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public Node<T, U> getPrev() {
            return prev;
        }
        public void setPrev(Node<T, U> prev) {
            this.prev = prev;
        }

        public Node<T, U> getNext() {
            return next;
        }
        public void setNext(Node<T, U> next) {
            this.next = next;
        }

        public T getKey() {
            return key;
        }
        public void setKey(T key) {
            this.key = key;
        }

        public U getValue() {
            return value;
        }
        public void setValue(U value) {
            this.value = value;
        }
    }
}