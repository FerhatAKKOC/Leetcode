package InterviewCollection.CollectionsHard;

public class surroundedRegions {

    public static void main(String[] args) {

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        print(board);
        solve(board);
        print(board);
    }

    private static void solve(char[][] matrix) {

        int N = matrix.length;
        int M = matrix[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) // only borders
                    if (matrix[i][j] == 'O')
                        DFS(matrix, i, j);
            }
        }
        print(matrix);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '1') // only borders
                    matrix[i][j] = 'O';
                else
                    matrix[i][j] = 'X';
            }
        }
    }

    /*
        https://www.youtube.com/watch?v=0ZJViJEdtEc

        En dıştaki 'O' ları bulup, onları sırayya DFS'ile '1' yaparız.
     */
    private static void DFS(char[][] matrix, int i, int j) {

        int N = matrix.length;
        int M = matrix[0].length;

        matrix[i][j] = '1';

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (0 <= row && row < N && 0 <= col && col < M && matrix[row][col] == 'O')
                DFS(matrix, row, col);
        }
    }

    private static void print(char[][] matrix) {

        int N = matrix.length;
        int M = matrix[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
