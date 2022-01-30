package InterviewCollection.QueueStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.println("Output : " + validParanthesis("([)]"));
    }


    private static boolean validParanthesis(String strs) {

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for (var ch : strs.toCharArray()) {

            if (map.containsKey(ch)) {

                if (stack.pop() != map.get(ch)) {
                    System.out.println(ch);
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return true;
    }


}
