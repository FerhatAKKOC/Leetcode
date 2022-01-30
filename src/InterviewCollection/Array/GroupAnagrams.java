package InterviewCollection.Array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"}; //        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


        var output = groupAnagrams(strs);

        for (var str : output)
            System.out.println(str);

    }

    /*
        Given an array of strings strs, group the anagrams together. You can return the answer in any order.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    private static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<String, List>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }
}
