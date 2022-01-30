package InterviewCollection.HashTable;

import java.util.*;

public class TwoSum_III {

    public static void main(String[] args) {

        TwoSum_III twoSumII = new TwoSum_III();
        twoSumII.add(6);
        twoSumII.add(6);
        twoSumII.add(3);
        twoSumII.add(4);
        twoSumII.add(5);
        twoSumII.add(6);
        System.out.println("Output : " + twoSumII.find(12));
    }

    /*
        Design and implement a TwoSum class. It should support the following operations: add and find.
        add - Add the number to an internal data structure.
        find - Find if there exists any pair of numbers which sum is equal to the value.

        add(1); add(3); add(5);
        find(4) -> true
        find(7) -> false
     */

    private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    public void add(int number) {

        var temp = elements.getOrDefault(number,0);
        elements.put(number, temp+1);
    }

    public boolean find(int value) {
        for (Integer i : elements.keySet()) {
            int target = value - i;
            if (elements.containsKey(target)) {
                if (i == target && elements.get(target) < 2) {  // Aynı elemendan en az 2 tane olacak ki true dönsün. [1,2,3,6,6] target =12 dersek true döner.
                    continue;
                }
                return true;
            }
        }
        return false;
    }


}
