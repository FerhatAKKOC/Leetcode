package InterviewCollection.Amazon;

import java.util.ArrayList;
import java.util.List;

public class generateParentheses {

    public static void main(String[] args) {

        var output = generateParenthesis(3);

        output.forEach(s -> System.out.println(s + " "));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /*
        Generate Parentheses
     */
    private static void backtrack(List<String> ans, StringBuilder sb, int openCnt, int closeCnt, int n) {

        // base case
        if (sb.length() == n * 2) {
            ans.add(new String(sb.toString()));
            return;
        }

        if (openCnt < n) {
            sb.append("(");
            backtrack(ans, sb, openCnt + 1, closeCnt, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCnt < openCnt) {
            sb.append(")");
            backtrack(ans, sb, openCnt, closeCnt + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
