package InterviewCollection.company;

import java.util.*;

public class Maze {

    public static void main(String[] args) {
        new Maze().app();
    }

    private Random random;
    private Scanner scanner;
    static private char pathChar = 'o';
    ;
    private int[] cordB;
    private int[] cordE;
    private char[][] board;
    private int N; // rows
    private int M; // cols

    public Maze() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    private void app() {

        while (true) {

            System.out.print("Press '1' to print to Maze. Press '0' to end the game: ");

            var intput = scanner.next();

            if (intput.equals("0"))
                break;
            else if (intput.equals("1")) {
                System.out.print("Enter number of rows:");
                N = scanner.nextInt();
                System.out.print("Enter number of columns:");
                M = scanner.nextInt();

                // Application Steps
                createBoard(N, M);
                create_BE_Points();
                print(board);
                createPath_B_E(cordB[0], cordB[1]); // 'B' is a beginning point
                print(board);
                fillInside();
                print(board);
                printMaze();


            } else {
                System.out.println("please enter '0' or '1'");
            }
        }

        System.out.println("Program is terminating...");
    }

    private void createBoard(int rows, int cols) {
        // check minimum values of rows and cols. Must they be double numbers?
        board = createEmptyMatrix(rows, cols);
        fillBorders(board);
    }

    private char[][] createEmptyMatrix(int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], ' ');
        }

        return matrix;
    }

    private void fillBorders(char[][] border) {

        for (int i = 0; i < M; i++) {
            border[0][i] = border[N - 1][i] = 'x';
        }
        for (int i = 0; i < N; i++) {
            border[i][M - 1] = border[i][0] = 'x';
        }
    }

    private void create_BE_Points() {

        int rowB, colB, rowE, colE;

        do {
            rowB = (random.nextInt(N - 2) + 1) % N;
            colB = (random.nextInt(M - 2) + 1) % M;
            rowE = (random.nextInt(N - 2) + 1) % N;
            colE = (random.nextInt(M - 2) + 1) % M;

        } while (rowB == rowE && colB == colE);  // E & B mustn't be same cell

        cordB = new int[]{rowB, colB};
        cordE = new int[]{rowE, colE};

        board[rowB][colB] = 'B';
        board[rowE][colE] = 'E';
    }


    // Draws a rondom path between 'B' and 'E'. Use DFS algorithms
    private boolean createPath_B_E(int i, int j) {

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // base case
        if (board[i][j] == 'E') {
            return true;
        } else {
            for (var dir : directions) {    // search neighbourghs
                int row = dir[0] + i;
                int col = dir[1] + j;
                if (board[row][col] == 'E') {
                    return true;
                }
            }
        }

        // choose a random direction at beginning.
        int startDirection = random.nextInt(directions.length);

        for (int k = startDirection; k < directions.length + startDirection; k++) {

            int ptr = k % directions.length;

            int row = directions[ptr][0] + i;
            int col = directions[ptr][1] + j;

            if (0 < row && row < N - 1 && 0 < col && col < M - 1 && board[row][col] == ' ' && openSpacePathCheck(row, col) == false) {
                board[row][col] = pathChar;
                if (createPath_B_E(row, col))
                    return true;
                board[row][col] = ' ';
            }
        }

        return false; // not created a path
    }

    // Before choose a maze path, check 2x2 open space conditions
    private boolean openSpacePathCheck(int i, int j) {

        if ((board[i - 1][j] != pathChar && board[i + 1][j] != pathChar) || (board[i][j + 1] != pathChar && board[i][j - 1] != pathChar))
            return false;

        if ((board[i - 1][j - 1] != pathChar) || (board[i + 1][j + 1] != pathChar) || (board[i + 1][j - 1] != pathChar) || (board[i - 1][j + 1] != pathChar))
            return true;

        return false;
    }

    private void fillInside() {

        // fill first raw randomly
        for (int i = 0; i < M; i++) {
            var c = (random.nextInt(2) % 2 == 1) ? 'x' : ' ';
            if (board[1][i] == ' ' && c == 'x') {
                board[1][i] = 'x';
            }
        }

        // fill remaining cells randomly and appropriately
        for (int i = 2; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {

                if (board[i][j] == ' ') {
                    var c = (random.nextInt(2) % 2 == 1) ? 'x' : ' ';
                    board[i][j] = (c == ' ' && !openSpaceCheck(i, j)) ? ' ' : 'x';
                }
            }
        }
    }

    private boolean openSpaceCheck(int i, int j) {

        // check ( left, left-up, up ) cells
        if ((board[i - 1][j] == pathChar || board[i - 1][j] == ' ') &&
                (board[i - 1][j - 1] == pathChar || board[i - 1][j - 1] == ' ') &&
                (board[i][j - 1] == pathChar || board[i][j - 1] == ' '))
            return true;


        // check ( right, right-up, up ) cells
        if ((board[i + 1][j] == pathChar) &&
                (board[i + 1][j - 1] == pathChar || board[i + 1][j - 1] == ' ') &&
                (board[i][j - 1] == pathChar || board[i][j - 1] == ' '))
            return true;

        // check ( left, left-bottom, bottom ) cells
        if ((board[i - 1][j] == pathChar || board[i - 1][j] == ' ') &&
                (board[i - 1][j + 1] == pathChar) && (board[i][j + 1] == pathChar))
            return true;


        // check ( right, right-bottom, bottom ) cells
        if ((board[i + 1][j] == pathChar) &&
                (board[i + 1][j + 1] == pathChar) && (board[i][j + 1] == pathChar))
            return true;

        return false;
    }


    private static void print(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printMaze() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                var c = (board[i][j] == pathChar) ? ' ' : board[i][j];
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }
}
