package InterviewCollection.CollectionsEasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParentheses {

    public static void main(String[] args) {
        System.out.println("Output: " + validParentheses("{[]}"));
    }

    // ()[]{}"
    private static boolean validParentheses(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (Character ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.pop() != map.get(ch))
                    return false;
            } else {
                stack.push(ch);
            }
        }
        return true;
    }
}
