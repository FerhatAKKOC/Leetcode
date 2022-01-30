package InterviewCollection.Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParentheses {

    public static void main(String[] args) {

//        String s = "()[]{}";
        String s = "([)]";
        System.out.println("Output: " + valid(s));
    }

    /*
        Valid Parentheses
     */
    private static boolean valid(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (map.containsKey(ch)) {

                var pop = (stack.isEmpty()) ? '#' : stack.pop(); // stack'in boş olma durumu vardır.

                if (map.get(ch) != pop)
                    return false;

            } else {
                stack.push(ch);
            }

        }

        return stack.isEmpty();
    }
}
