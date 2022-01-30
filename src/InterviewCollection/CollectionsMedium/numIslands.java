package InterviewCollection.CollectionsMedium;

public class numIslands {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println("Output: " + numIslands(grid));
    }

    private static int numIslands(char[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        if (grid == null || N == 0) return 0;

        int numOfIsland = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    DFS(grid, i, j);
                    // print(grid);
                }
            }
        }

        return numOfIsland;
    }

    private static void DFS(char[][] grid, int i, int j) {

        int N = grid.length;
        int M = grid[0].length;

        grid[i][j] = '2';

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {

            int row = dir[0] + i;
            int col = dir[1] + j;

            if (0 <= row && row < N && 0 <= col && col < M && grid[row][col] == '1')
                DFS(grid, row, col);
        }


    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();

        }
        System.out.println("------------------------");
    }

}
