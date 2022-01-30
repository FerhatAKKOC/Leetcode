package InterviewCollection.HashTable;

import java.util.*;

public class RandomizedSet {

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(67); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(99); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(15); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(23); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(53); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(75); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.remove(15); // Returns false as 2 does not exist in the set.
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.


    }

    /*
        The List is used to store numbers and serve the getRandom() method.
        The Map contains the mapping between the value and its index in the ArrayList.
        The Map helps to check whether a value is already inserted or not.
        The main trick is when you remove a value. ArrayList's remove method is O(n) if you remove from random location.
        To overcome that, we swap the values between (randomIndex, lastIndex) and always remove the entry from the end of the list.
        After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.
     */
    HashMap<Integer, Integer> valToInd;
    List<Integer> list;
    int ind = 0;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valToInd.containsKey(val)) return false;
        list.add(val);
        valToInd.put(val, list.size() - 1);
        System.out.println("insert : " + val + "   => " + list);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        int ind = valToInd.getOrDefault(val, -1);
        if (ind == -1) return false;
        Collections.swap(list, ind, list.size() - 1);
        int swappedWith = list.get(ind);
        valToInd.put(swappedWith, ind);   // son elemanı swap ettiğimiz için, bunun map'teki yeni indeksini güncellemeliyiz.
        list.remove(list.size() - 1);
        valToInd.remove(val);
        System.out.println("remove : " + val + "   => " + list);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int max = list.size();
        int min = 0;
        int ind = (int) (Math.random() * (max - min) + min);
        System.out.println("Random : " + list.get(ind) + "   => " + list);
        return list.get(ind);
    }
}


