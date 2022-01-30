package InterviewCollection.CollectionsMedium;

import java.util.*;

public class groupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        var outputs = groupAnagrams(strs);

        for (var out : outputs)
            System.out.print(out);
    }

    /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (var str : strs) {

            char[] ch = str.toCharArray(); // Converting input string to character array and sort it.
            Arrays.sort(ch);
            String sortedStr = new String(ch);

            var temp = map.getOrDefault(sortedStr, new ArrayList<>());
            temp.add(str);
            map.put(sortedStr, temp);
        }

        List<List<String>> result = new ArrayList<>();

        for (var a : map.values()) {
            result.add(a);
        }

        return result;
    }
}
