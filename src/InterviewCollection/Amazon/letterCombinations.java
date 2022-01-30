package InterviewCollection.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class letterCombinations {
    public static void main(String[] args) {

        var output = letterCombinations("23");
        output.stream().forEach(s -> System.out.print("[" + s + "]"));
    }

    private static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        String[] Phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        dfs(digits, 0, Phone, new StringBuilder(), list);

        return list;
    }

    private static void dfs(String digits, int i, String[] phone, StringBuilder sb, List<String> list) {

        if (i == digits.length()) {
            list.add(new String(sb.toString()));
            return;
        }

        var number = Integer.parseInt(String.valueOf(digits.charAt(i)));
        var str = phone[number];

        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            dfs(digits, i + 1, phone, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
