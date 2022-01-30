package InterviewCollection.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupShiftedStrings {
    public static void main(String[] args) {

        String[] strs = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};


        var groups = groupStrings(strs);
    }

    // Group Shifted Strings
    private static List<List<String>> groupStrings(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (var str : strs) {
            var pattern = getPattern(str);
            System.out.println(str + " => " + pattern);

            if (map.containsKey(pattern)) {
                map.get(pattern).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(pattern, list);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (var values : map.values()) {
            result.add(values);
        }
        return result;
    }

    private static String getPattern(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {

            int subs = (int) str.charAt(i) - (int) str.charAt(i - 1);  // if a-y = -24 in this case Math.abs(-24) = 24. and then 24-22 = 2;
            sb.append(subs >= 0 ? subs : Math.abs(subs) - 22);
        }

        return sb.toString();
    }
}
