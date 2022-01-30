package InterviewCollection.Recursions;

public class SudokuSolver {


    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        print(board);
    }


    private static boolean isSafe(int[][] board, int row, int col, int num) {

        // row is unique
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return false;
        }

        // col is unique
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }

        // smaller matrix

        int sqrt = (int) Math.sqrt(board.length);  // 3x3  sqrt = 3;
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int i = boxColStart; i < boxRowStart + sqrt; i++) {
            for (int j = boxRowStart; j < boxRowStart + sqrt; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;

    }

    /*
    Soldan sağa, rowlarda her bir cell'e tek tek bakıyoruz. Bir boşluk varmı diye, varsa o cell'in (row,col) bilgisini alıyoruz.
    Daha sonra oraya 1-9 arası numara yerleştireceğiz, yerleştirmeden önce isSafe'mi diye condition'ları kontrol ediyoruz.
    Eğer yerleştirilebilirsek, bir sonraki boş cell için tekrar solveSudoku fonksiyonunu recursive bir şekilde çağırıyoruz.
    Bu fonksiyon true döndükçe recursive bir şekilde kendi kendini çağırmaya devam eder. Ne zaman false döner, o zaman en son yerleştirdiğimiz
    değeri board[row][col] = '.'; ile geri alıyoruz.
     */
    public static boolean solveSudoku(int[][] board, int n) {  // n: board.length

        int row = -1;
        int col = -1;

        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;  // determine which cell is missing
                    col = j;

                    isEmpty = false; // We still have some remaining, missing values in Sudoku
                    break;
                }
            }
            if (!isEmpty) { // 2. for loop'u kırmak için
                break;
            }
        }

        if (isEmpty)        // No empty space left
            return true;

        for (int num = 1; num <= n; num++) {

            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
//                    print(board);
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }

        return false;

    }


    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
