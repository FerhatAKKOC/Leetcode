package InterviewCollection.CollectionsEasy;

import java.util.HashSet;
import java.util.Set;

public class validSudoku {

    public static void main(String[] args) {

        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println("Output: " + isValidSudoku(board));

    }


    private static boolean isValidSudoku(char[][] board) {


        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            Set<Character> setRows = new HashSet<>();
            Set<Character> setCols = new HashSet<>();
            for (int j = 0; j < cols; j++) {

                if (board[i][j] != '.' && setRows.contains(board[i][j]))
                    return false;
                else {
                    setRows.add(board[i][j]);
                }

                if (board[j][i] != '.' && setCols.contains(board[j][i]))
                    return false;
                else {
                    setCols.add(board[j][i]);
                }
            }

//            System.out.println("i/3: " + (i / 3) * 3 + "  i%3: " + (i % 3) * 3);

            if (isValidMatrix(board, (i / 3) * 3, (i % 3) * 3) == false)
                return false;
        }

        return true;
    }

    private static boolean isValidMatrix(char[][] board, int row, int col) {

        var len = Math.sqrt(board.length);

        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {

                if (board[i][j] != '.' && set.contains(board[i][j]))
                    return false;
                else {
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
