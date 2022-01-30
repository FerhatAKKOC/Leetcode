package InterviewCollection.Recursions;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {

    private static String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        var digits = "23";

        var outputs = letterCombinations(digits);

        for (var out : outputs)
            System.out.print(out + "  ");
    }

    private static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        letterCombinationsHelper(digits, 2, new StringBuilder(), result);
        return result;

    }

    private static void letterCombinationsHelper(String digits, int digitIndex, StringBuilder sb, List<String> result) {

        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        var number = numbers[digitIndex];

        for (int i = 0; i < number.length(); i++) {
            sb.append(number.charAt(i));
            letterCombinationsHelper(digits, digitIndex + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
