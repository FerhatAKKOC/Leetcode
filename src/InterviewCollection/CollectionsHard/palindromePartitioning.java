package InterviewCollection.CollectionsHard;

import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {

    public static void main(String[] args) {

        var output = partition("aabb");

        for (var out : output)
            System.out.println(out);

    }

    /*
        Palindrome Partitioning
        https://www.youtube.com/watch?v=WBgsABoClE0
     */
    private static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        func(s, 0, path, result);

        return result;
    }

    private static void func(String s, int index, List<String> path, List<List<String>> result) {

        int n = s.length();

        // base case
        if (index == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isPalind(s, index, i)) {
                path.add(s.substring(index, i + 1));
                func(s, i+1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalind(String s, int i, int j) {
        while (i <= j) {

            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
