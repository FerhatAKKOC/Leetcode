package InterviewCollection.CollectionsMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class letterCombinations {

    public static void main(String[] args) {

        var output = letterCombinations("2");

        for(var out: output)
            System.out.print(out + ", ");

    }

    private static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
            return result;

        List<char[]> letters = new ArrayList<>();
        letters.add(new char[]{'0'});
        letters.add(new char[]{'1'});
        letters.add(new char[]{'a', 'b', 'c'});
        letters.add(new char[]{'d', 'e', 'f'});
        letters.add(new char[]{'g', 'h', 'i'});
        letters.add(new char[]{'j', 'k', 'l'});
        letters.add(new char[]{'m', 'n', 'o'});
        letters.add(new char[]{'p', 'q', 'r', 's'});
        letters.add(new char[]{'t', 'u', 'v'});
        letters.add(new char[]{'w', 'x', 'y', 'z'});

        letterCombinations(digits, letters, result, new StringBuilder());

        return result;
    }

    private static void letterCombinations(String digits, List<char[]> letters, List<String> result, StringBuilder sb) {

        // base case
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int index = Integer.valueOf(String.valueOf(digits.charAt(sb.length())));

        for (var ch : letters.get(index)) {
            sb.append(ch);
            letterCombinations(digits,letters,result,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
