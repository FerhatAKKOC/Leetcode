package InterviewCollection.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class orangesRotting {

    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] grid = {{0, 2}};

        System.out.println("Output: " + orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        var isFresh = Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(value -> value == 1).findAny();
        if (isFresh.isPresent()) return 0; // there are already no fresh oranges


        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int minutes = -1;

        while (!queue.isEmpty()) {

            var size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {

                var cell = queue.poll();
                for (var dir : directions) {
                    var row = cell[0] + dir[0];
                    var col = cell[1] + dir[1];

                    if (0 <= row && row < N && 0 <= col && col < M && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }

        isFresh = Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(value -> value == 1).findAny();
        if (isFresh.isPresent()) return 0; // there is already one fresh orange

        return minutes;
    }
}
