package InterviewCollection.Recursions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        var outputs = combine(4, 2);

        for (var out : outputs) {
            for (var o : out)
                System.out.print(o + " ");
            System.out.println();
        }
    }

    private static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        combineHelper(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private static void combineHelper(int start, int end, int k, ArrayList<Integer> templist, List<List<Integer>> result) {

        if (templist.size() == k) {
            result.add((ArrayList<Integer>) templist.clone());
            return;
        }

        for (int j = start; j <= end; j++) {
            templist.add(j);
            combineHelper(j + 1, end, k, templist, result);
            templist.remove(templist.size() - 1);
        }
    }
}
