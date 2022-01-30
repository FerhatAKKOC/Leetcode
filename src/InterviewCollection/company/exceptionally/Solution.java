package InterviewCollection.company.exceptionally;

import java.util.PriorityQueue;

public class Solution {


    public static void main(String[] args) {

        var out = solve("aba");
        System.out.println(out);
    }

    static String solve(String S) {

        if (S == null || S.length() == 1)
            return String.valueOf(-1);

        PriorityQueue<Character> pr = new PriorityQueue<Character>();

        for (char c : S.toCharArray())
            pr.offer(c);

        StringBuilder sb = new StringBuilder();

        while (!pr.isEmpty())
            sb.append(pr.poll());

        sb.reverse();
        if (isPolindrom(sb.toString()) == false)
            return sb.toString();
        else
            return String.valueOf(-1);

    }

    private static boolean isPolindrom(String s) {
        if (s.length() == 1) return true;
        if (s.length() == 2) return s.charAt(0) == s.charAt(1);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(s.length() - i))
                return false;
        }
        return true;
    }

}
