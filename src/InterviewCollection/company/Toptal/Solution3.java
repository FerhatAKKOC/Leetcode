package InterviewCollection.company.Toptal;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
//        String[] R = {"....X..", "X......", ".....X.", "......." };
        String[] R = {"...X..", "....XX", "..X..." };
//        String[] R = {"...X.", ".X..X", "X...X", "..X.." };

        System.out.println("Output: " + solution(R));
    }

    /*
        Codelity
        Cleaning robot which is cleaning rectangular
     */
    private static int solution(String[] R) {

        int[][] matrix = buildMatrix(R);
        printArray(matrix);

        // define 4-way directions;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int direcIndex = 1; /// for rotate 90 right always

        int[] curr = new int[]{0, 0};
        int[] next = new int[]{0, 1};   //initialize starting point and way  we are {0,0} cell and going to {0,1} cell

        int index = 100;    // I can't find a algorithm how to find cycle, so for the time being, I iterate 100 times.

        Set<String> visited = new HashSet<>();
        while (true) { // when cycle is detected, this loop will break

            int row = curr[0] + next[0];
            int col = curr[1] + next[1];

            if (0 <= row && row < matrix.length && 0 <= col && col < matrix[0].length) { // not exceeds limits

                if (matrix[row][col] != 1) {
                    matrix[row][col] = 'C'; // cleaned
                    curr = new int[]{row, col}; // change current location one step

                    String cross = "" + curr[0] + curr[1] + next[0] + next[1];
                    if(visited.contains(cross))
                        break;
                    visited.add(cross);

                } else {
                    direcIndex = (++direcIndex) % 4;
                    next = directions[direcIndex];
                }
            } else {  // If we hit border, we rotate
                direcIndex = (++direcIndex) % 4;
                next = directions[direcIndex];
            }
        }

        matrix[0][0] = 'C';
        int numOfCleanRoom = 0;

        printArray(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'C')
                    numOfCleanRoom++;
            }
        }

        return numOfCleanRoom;
    }

    private static int[][] buildMatrix(String[] R) {

        int[][] matrix = new int[R.length][R[0].length()];

        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[0].length(); j++) {
                if (R[i].charAt(j) == '.') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }

        return matrix;
    }

    // Print matrix
    private static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("-------------------");
    }
}
