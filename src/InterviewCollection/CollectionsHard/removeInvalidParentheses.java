package InterviewCollection.CollectionsHard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class removeInvalidParentheses {
    public static void main(String[] args) {
        var output = removeInvalidParentheses("())()");

        for(var out:output)
            System.out.println(out);
    }

    private static Set<String> validExpressions = new HashSet<String>();
    private static int minimumRemoved;

    private static void reset() {
        validExpressions.clear();
        minimumRemoved = Integer.MAX_VALUE;
    }

    private static void recurse(String s,
                                int index,
                                int leftCount,
                                int rightCount,
                                StringBuilder expression,
                                int removedCount) {

        // If we have reached the end of string.
        if (index == s.length()) {

            // If the current expression is valid.
            if (leftCount == rightCount) {

                // If the current count of removed parentheses is <= the current minimum count
                if (removedCount <= minimumRemoved) {

                    // Convert StringBuilder to a String. This is an expensive operation.
                    // So we only perform this when needed.
                    String possibleAnswer = expression.toString();

                    // If the current count beats the overall minimum we have till now
                    if (removedCount < minimumRemoved) {
                        validExpressions.clear();
                        minimumRemoved = removedCount;
                    }
                    validExpressions.add(possibleAnswer);
                }
            }
        } else {

            char currentCharacter = s.charAt(index);
            int length = expression.length();

            // If the current character is neither an opening bracket nor a closing one,
            // simply recurse further by adding it to the expression StringBuilder
            if (currentCharacter != '(' && currentCharacter != ')') {
                expression.append(currentCharacter);
                recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            } else {

                // Recursion where we delete the current character and move forward
                recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                expression.append(currentCharacter);

                // If it's an opening parenthesis, consider it and recurse
                if (currentCharacter == '(') {
                    recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    // For a closing parenthesis, only recurse if right < left
                    recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }

                // Undoing the append operation for other recursions.
                expression.deleteCharAt(length);
            }
        }
    }

    private static List<String> removeInvalidParentheses(String s) {

        reset();
        recurse(s, 0, 0, 0, new StringBuilder(), 0);

        return new ArrayList(validExpressions);

    }
}
