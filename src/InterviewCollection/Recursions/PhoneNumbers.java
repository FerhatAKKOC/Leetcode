package InterviewCollection.Recursions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumbers {

    private static HashMap<Character, char[]> map = new HashMap<>();

    public static void main(String[] args) {


        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});


//        var result = letterCombinations("234");
    }

    private static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        letterCombinationsHelper(digits, result, sb, map);

        return result;

    }

    private static void letterCombinationsHelper(String digits, List<String> result, StringBuilder sb, HashMap<Character, char[]> map) {

        if (sb.length() == digits.length()) {
            result.add(new String(sb.toString()));
            return;
        }

        for (char c : map.get(sb.length())){
            sb.append(c);
            letterCombinationsHelper(digits,result,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
