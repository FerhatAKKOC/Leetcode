package InterviewCollection.CollectionsHard;

public class gameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        print(board);
        gameOfLife(board);
        print(board);
    }

    private static void gameOfLife(int[][] board) {

        int N = board.length;
        int M = board[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                decide(board, i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;  // -1 ve 2 yi original değerine dönüştürüyoruz.
            }
        }
    }

    /*
        https://www.youtube.com/watch?v=x1kRrOdcOAg

        0 ----> live : +2  (+: live,
        1 ----> dies : -1   : dies(-: dies  -1, previous cond. use absulote
     */
    private static void decide(int[][] board, int i, int j) {

        int N = board.length;
        int M = board[0].length;

        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        int lives = 0;

        if(i ==2 && j ==2)
            print(board);

        for (var dir : directions) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            if (0 <= row && row < N && 0 <= col && col < M && (1 == Math.abs(board[row][col]))) {
                lives++;
            }
        }
        System.out.println("[" + i + "," + j + "] : " + " lives: " + lives);

        if ((board[i][j] == 1) && (lives < 2 || lives > 3)) { //live
            board[i][j] = -1;   // lives to dies
        } else if (lives == 3)
            board[i][j] = 2;    // dies to lives
    }

    private static void print(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    //*********************************************************
    //*********************************************************
    private static void decide(int[][] board, int i, int j, int[][] res) {

        int N = board.length;
        int M = board[0].length;

        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        int lives = 0;
        int dies = 0;

        for (var dir : directions) {

            int row = dir[0] + i;
            int col = dir[1] + j;

            if (0 <= row && row < N && 0 <= col && col < M) {
                if (board[row][col] == 0)
                    dies++;
                else
                    lives++;
            }
        }

        // System.out.println("[" + i + "," + j + "] : " + " lives: " + lives + "  dies: " + dies);

        if (board[i][j] == 1) { //live
            res[i][j] = (lives < 2 || lives > 3) ? 0 : 1;
        } else {
            res[i][j] = (lives == 3) ? 1 : 0;
        }
    }

}
