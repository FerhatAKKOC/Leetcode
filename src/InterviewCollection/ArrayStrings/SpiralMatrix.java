package InterviewCollection.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {  {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10,11,12}};

        var output = spiralOrder(matrix);

//        for (var a : output)   System.out.print(a + " ");
    }

    private static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows * columns) {
            // Traverse from left to right.
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            // Traverse downwards.
            for (int i = top + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }

            if (top != down) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }

            if (left != right) {
                for (int i = down - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            down--;
        }

        return result;
    }
}
