package InterviewCollection.company;

import java.util.LinkedList;
import java.util.Queue;

public class TomTom2 {

    public static void main(String[] args) {

        int[][] A =
                {{0, 0, 0, 1},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 0}};

        int K = 4;

        System.out.println("Output :" + solution(K, A));
    }

    private static int solution(int K, int[][] A) {

        // I will try to use Breadth-Search for each slots one-by-one, or I push each cell cordinates to a queue(FIFO)

        int numOfHouses = 0;
        int numEmptySlot = 0;
        int row = A.length;
        int col = A[0].length;

        // Firstly I  will find the number of houses
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    numOfHouses++;   // When I come across one house, I decrease a temporary house number variable.
                }
            }
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // we travel to four directions.


        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                int length = 0;
                int tempNumOfHouses = numOfHouses;
                java.util.Queue<int[]> queue = new java.util.LinkedList<>();

                if (A[i][j] == 0) {

                    var matrix = duplicaMatrix(A); // Each time a create, because I wanna mark visited cells. I can use Set collection to hold visited cells.

                    queue.add(new int[]{i, j});
                    matrix[i][j] = 2;        // I don't wanna visit the same cells. So, I marked them.

                    while (!queue.isEmpty()) {

                        length++;
                        int size = queue.size();

                        if (length > K) {// we exceeds limits
                            break;
                        }

                        for (int k = 0; k < size; k++) {

                            var cur = queue.poll();

                            for (var dir : directions) {

                                int x = cur[1] + dir[1];
                                int y = cur[0] + dir[0];

                                if (y >= 0 && y < row && x >= 0 && x < col && (matrix[y][x] == 0 || matrix[y][x] == 1)) {
                                    queue.add(new int[]{y, x});
                                    if (matrix[y][x] == 0) matrix[y][x] = 2;
                                }

                                if (y >= 0 && y < row && x >= 0 && x < col && matrix[y][x] == 1) {
                                    matrix[y][x] = 2;
                                    if (--tempNumOfHouses == 0) {  // we visited all houses.
                                        queue.clear();
                                        k = ++size;
                                        numEmptySlot++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return numEmptySlot;
    }

    private static int[][] duplicaMatrix(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int[][] matrix = new int[row][col];

        // Firstly I  will find the number of houses
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = A[i][j];
            }
        }

        return matrix;
    }

}
