package InterviewCollection.Others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValidBrackets {


    public static void main(String[] args) {

        String s = "{[[]{}]}()()";
        System.out.println("Output: " + isValid(s));

    }


    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    private static boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){

            if(map.containsKey(c)){
                Character top = stack.empty() ? '#' : stack.pop();
                if(top != map.get(c))
                    return false;
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }

    public boolean isValid2(String s) {

        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
