package InterviewCollection.HashTable;

import java.util.Set;
import java.util.stream.Collectors;

public class numJewelsInStones {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";

        System.out.println("Output : " + numJewelsInStones(jewels, stones));
    }


    /*
        You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
        Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
        Letters are case sensitive, so "a" is considered a different type of stone from "A".
     */
    private static int numJewelsInStones(String jewels, String stones) {

        if (jewels == null || stones == null) return 0;

        Set<Character> set = jewels.chars().mapToObj(chr -> (char) chr).collect(Collectors.toSet());

        int res = 0;
        for (char ch : stones.toCharArray()) {

            if (set.contains(ch)) {
                res++;
            }
        }
        return res;
    }
}
