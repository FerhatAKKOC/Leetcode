package InterviewCollection.Recursions;

import java.util.HashSet;
import java.util.Set;

public class NQueens_II {

    public static void main(String[] args) {
        System.out.println("Output : " + totalNQueens(4));
    }

    private static int totalNQueens(int n) {
        int count = 0;
        int row = 0;
        return totalNQueensHelper(row, count, n);
    }

    private static Set<Integer> colum = new HashSet<>();
    private static Set<Integer> diag1 = new HashSet<>();
    private static Set<Integer> diag2 = new HashSet<>();

    private static int totalNQueensHelper(int row, int count, int N) {

        for (int col = 0; col < N; col++) {

            if (colum.contains(col)) continue;

            int subs1 = col - row;
            if (diag1.contains(subs1)) continue;

            int sum1 = col + row;
            if (diag2.contains(sum1)) continue;

            if (row == N - 1)
                return ++count;
            else {
                colum.add(col);
                diag1.add(subs1);
                diag2.add(sum1);

                count = totalNQueensHelper(row + 1, count, N);

                colum.remove(col);
                diag1.remove(subs1);
                diag2.remove(sum1);
            }
        }
        return count;
    }

}
