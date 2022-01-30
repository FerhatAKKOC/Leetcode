package InterviewCollection.QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '}'},
                {'0', '0', '1', '0', '}'},
                {'0', '0', '0', '1', '}'}};

        System.out.println("Output : " + numIslands(grid));

    }
    /*****************************************************************/
    /************            BFS Solution    *************************/
    /*****************************************************************/

    private static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1') {
                    count++;

                    queue.add(new int[]{i, j});
                    grid[i][j] = '2';

                    while (!queue.isEmpty()) {
                        var cur = queue.poll();
                        for (var dir : directions) {

                            int x = cur[1] + dir[1];
                            int y = cur[0] + dir[0];

                            if (y >= 0 && y < row && x >= 0 && x < col && grid[y][x] == '1') {
                                queue.add(new int[]{y, x});
                                grid[y][x] = '2';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }


    /*****************************************************************/
    /************            DFS Solution    *************************/
    /*****************************************************************/
    private static int numIslands2(char[][] grid) {

        if (grid == null || grid.length == 0) // empty matrix
            return 0;

        int counter = 0;
        int n = grid.length;    // row length
        int m = grid[0].length; // col length


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    counter++;
                    DFSMarking(grid, i, j);
                }
            }
        }
        return counter;
    }

    private static void DFSMarking(char[][] grid, int i, int j) {

        int n = grid.length;    // row length
        int m = grid[0].length; // col length

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';

        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    //*********************************************************
    //*********************************************************
    //*********************************************************
    private static int numIslands3(char[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        boolean[][] visited = new boolean[N][M]; // false

        int Islands = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    helper(grid, visited, i, j);
                    Islands++;

                }
            }
        }
        return Islands;
    }

    private static void helper(char[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == true)
            return;

        visited[i][j] = true;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {
            helper(grid, visited, dir[0] + i, dir[1] + j);
        }
    }
}
