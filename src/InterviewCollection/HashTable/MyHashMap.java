package InterviewCollection.HashTable;

import java.util.LinkedList;

public class MyHashMap {

    private static final int SIZE = 769;  // more efficient

    LinkedList<Entry>[] map = null;

    public MyHashMap() {
        this.map = new LinkedList[SIZE];
    }

    private int getBucket(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {

        var index = key % SIZE;
        var bucket = map[index];

        Entry entry = new Entry(key, value);

        if (bucket == null) {
            map[index] = new LinkedList<>();
            map[index].add(entry);
        } else {
            for (var entries : bucket) {
                if (entries.key == key) {
                    entries.value = value;
                    return;
                }
            }

            bucket.add(entry);
        }
    }

    public int get(int key) {

        var index = key % SIZE;
        var bucket = map[index];

        if (bucket != null) {

            for (var entries : bucket) {
                if (entries.key == key) {
                    return entries.value;
                }
            }
        }

        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {

        var index = getBucket(key);

        Entry temp = null;
        if (map[index] != null) {
            for (var entry : map[index]) {
                if (entry.key == key) {
                    temp = entry;
                    break;
                }
            }
            if (temp != null) {
                map[index].remove(temp);
            }
        }
    }

    class Entry {
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
