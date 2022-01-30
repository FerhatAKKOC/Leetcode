package InterviewCollection.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class groupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        var outputs = groupAnagrams(strs);

        for (var out : outputs)
            System.out.println(out);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();

        if (strs.length == 0) return list;
        if (strs.length == 1) {
            list.add(Arrays.asList(strs[0]));
            return list;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (var str : strs) {
            var temp = str.toCharArray();
            Arrays.sort(temp);
            var tempStr = String.valueOf(temp);
            var value = map.getOrDefault(tempStr, new ArrayList<>());
            value.add(str);
            map.put(tempStr, value);

        }

        return map.values().stream().collect(Collectors.toList());
    }

}
