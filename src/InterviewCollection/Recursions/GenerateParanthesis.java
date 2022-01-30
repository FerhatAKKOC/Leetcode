package InterviewCollection.Recursions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        var output = generateParenthesis(3);

        for (var out : output)
            System.out.println(out);

    }

    private static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesisHelper(0, 0, n, new StringBuilder(), result);

        return result;

    }

    // Note: closed+1 ve open+1 şeklinde yaz. ++open, open++ yazmak doğru sonuç çıkarmayacaktır.
    private static void generateParenthesisHelper(int open, int closed, int n, StringBuilder sb, List<String> result) {

        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            generateParenthesisHelper(open + 1, closed, n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closed < open) {
            sb.append(")");
            generateParenthesisHelper(open, closed + 1, n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
