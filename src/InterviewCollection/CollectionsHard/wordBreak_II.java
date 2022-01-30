package InterviewCollection.CollectionsHard;

import java.util.*;
import java.util.stream.Stream;

public class wordBreak_II {

    public static void main(String[] args) {

        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        var output = wordBreak(s, wordDict);

        for (var out : output)
            System.out.println(out);
    }

    /*
        Word Break II
     */
    private static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>(wordDict);

        helper(s, 0, set, sb, list);
        return list;
    }

    private static void helper(
            String s,
            int index,
            Set<String> set,
            StringBuilder sb,
            List<String> list) {

        if (index == s.length()) {
            list.add(new String(sb.toString()));
            sb.delete(0, sb.length());
            return;
        }


        StringBuilder builder = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            builder.append(ch);

            if (set.contains(builder.toString())) {
                sb.append(builder.toString() + " ");
                helper(s, i + 1, set, sb, list);
            }
        }
    }
}
