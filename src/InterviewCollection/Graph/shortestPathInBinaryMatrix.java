package InterviewCollection.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};

        System.out.println("Output: " + shortestPathBinaryMatrix(grid));
    }

    /*
        Shortest Path in Binary Matrix
     */
    private static int shortestPathBinaryMatrix(int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        if (grid[0][0] != 0 || grid[N - 1][M - 1] != 0)
            return -1;

        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            var cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            var distance = grid[row][col];
            if (row == N - 1 && col == M - 1)
                return distance;

            for (var neighbour : getNeighbours(row, col, grid)) {
                int r = neighbour[0];
                int c = neighbour[1];
                queue.add(new int[]{r, c});
                grid[r][c] = distance + 1;
            }
        }

        return -1;
    }

    private static List<int[]> getNeighbours(int row, int col, int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        List<int[]> list = new ArrayList<>();

        for (var dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (0 <= r && r < N && 0 <= c && c < M && grid[r][c] == 0)
                list.add(new int[]{r, c});
        }
        return list;
    }

}
