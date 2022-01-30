package InterviewCollection.HashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
/*        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.add(22);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)*/
    }

    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> buckets;  // 100 bucket ve her bucket'ta 10.000 data var. Bucket bir LinkedList barındıracak

    public MyHashSet() {
        this.buckets = new ArrayList(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            buckets.add(null);
        }
    }

    public void add(int key) {

        int index = key % ARRAY_SIZE;
        var childList = buckets.get(index);

        if (childList == null) {
            childList = new LinkedList<>();
            childList.add(key);
            buckets.set(index, childList);
        } else {
            if (!childList.contains(key))  // not contains
                childList.add(key);
        }
    }

    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        var childList = buckets.get(index);

        if (childList != null && childList.contains(key)) {
            childList.remove(key);
        }
    }

    public boolean contains(int key) {

        int index = key % ARRAY_SIZE;
        var childList = buckets.get(index);

        if (childList != null && childList.contains(key)) {
           return true;
        }

        return false;
    }
}

class MyHashSet2 {

    private boolean[] hashSet;

    public MyHashSet2() {
        this.hashSet = new boolean[10000001];
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    public boolean contains(int key) {
        return hashSet[key];
    }
}
