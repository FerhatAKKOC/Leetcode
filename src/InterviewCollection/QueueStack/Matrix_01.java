package InterviewCollection.QueueStack;

import java.util.*;

public class Matrix_01 {

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        show(mat);
        var output = updateMatrix(mat);
        show(output);

    }

    private static int[][] updateMatrix(int[][] matrix) {

        int rows = matrix.length;
        if (rows == 0) return matrix;
        int cols = matrix[0].length;

        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j}); //Put all 0s in the queue.
                } else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {

            var curr = queue.poll();

            for (int i = 0; i < 4; i++) {

                int new_r = curr[0] + dir[i][0], new_c = curr[1] + dir[i][1];

                if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols) {
                    if (dist[new_r][new_c] > dist[curr[0]][curr[1]] + 1) {
                        dist[new_r][new_c] = dist[curr[0]][curr[1]] + 1;
                        queue.offer(new int[]{new_r, new_c});
                    }
                }
            }
        }


        return dist;
    }


    private static void show(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }
}
