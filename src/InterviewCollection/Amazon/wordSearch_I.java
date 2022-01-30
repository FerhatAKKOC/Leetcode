package InterviewCollection.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class wordSearch_I {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'E', 'D', 'E', 'E'}};

//        String word = "ABCCED";
        String word = "SEE";

        System.out.println("Output: " + exist(board, word));
    }

    /*
        Word Search
    */
    private static boolean exist(char[][] board, String word) {

        int N = board.length;
        int M = board[0].length;

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    DFS(board, i, j, visited, word, 1);
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private static void DFS(char[][] board, int i, int j, boolean[][] visited, String word, int i1) {

        int N = board.length;
        int M = board[0].length;

        // base case
        if (i1 >= word.length()) {
            System.out.println("*******True******");
            return;
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {
            int row = dir[0] + i;
            int col = dir[1] + j;

            if (0 <= row && row < N && 0 <= col && col < M && !visited[row][col] && board[row][col] == word.charAt(i1)) {
                visited[row][col] = true;
                DFS(board, row, col, visited, word, i1 + 1);
                visited[row][col] = false;
            }
        }
    }
}
