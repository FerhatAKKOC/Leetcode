package InterviewCollection.Array;

import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {
    public static void main(String[] args) {

//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        print(matrix);
        setZeroes(matrix);
        print(matrix);
    }

    /*
        Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
        You must do it in place.
     */
    private static void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }
//        queue.stream().forEach(ints -> System.out.println("{" + ints[0] + " " + ints[1] + "}"));

        while (!queue.isEmpty()){

            var cord = queue.poll();
            int i = cord[0];
            int j = cord[1];

            for (int k = 0; k < matrix.length; k++) {
                matrix[i][k] = 0;
                matrix[k][j] = 0;
            }
        }
    }

    private static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}
