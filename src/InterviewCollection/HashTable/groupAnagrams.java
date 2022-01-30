package InterviewCollection.HashTable;

import java.util.*;

public class groupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        var output = groupAnagrams(strs);

        output.forEach(System.out::println);

    }

    /*
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    private static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        Map<String, List> map = new HashMap<String, List>();

        if (strs == null) {
            return result;
        } else if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        } else {

            for (String str : strs) {

                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String key = new String(ch);

                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList());
                }
                map.get(key).add(str);
            }
        }

        for (var a : map.values()) {
            result.add(a);
        }
        return result;
    }
}
