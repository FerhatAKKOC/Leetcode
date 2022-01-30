package InterviewCollection.Amazon;

public class TicTacToe {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println("Output: " + ticTacToe.move(0, 0, 1));
        System.out.println("Output: " + ticTacToe.move(0, 2, 2));
        System.out.println("Output: " + ticTacToe.move(2, 2, 1));
        System.out.println("Output: " + ticTacToe.move(1, 1, 2));
        System.out.println("Output: " + ticTacToe.move(2, 0, 1));
        System.out.println("Output: " + ticTacToe.move(1, 0, 2));
        System.out.println("Output: " + ticTacToe.move(2, 1, 1));
    }

    int[][] matrix;

    public TicTacToe(int n) {
        matrix = new int[n][n];
    }

    private int move(int row, int col, int player) {

        matrix[row][col] = player;

        if (checkRow(row, player) || checkCol(col, player) || checkDiagonel(player) || checkAntiDiagonel(player))
            return player;

        return 0;
    }

    private boolean checkRow(int row, int player) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[row][i] != player)
                return false;
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] != player)
                return false;
        }
        return true;
    }

    private boolean checkDiagonel(int player) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            if (matrix[row][row] != player)
                return false;
        }
        return true;
    }

    private boolean checkAntiDiagonel(int player) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            if (matrix[row][n - row - 1] != player)
                return false;
        }
        return true;
    }

    private static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}
