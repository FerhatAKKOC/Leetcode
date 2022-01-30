package InterviewCollection.Array;

import java.util.HashSet;

public class ValidSuduko {

    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        isValidSudoku(board);

    }

    static boolean isValidSudoku(char[][] board) {

        if (board == null || doubleArraySize(board) < 81) return false;

        for (int i = 0; i < 1; i++) {   // rows

            for (int j = 0; j < board.length; j++) {  // columns

                  checkColumns(board,j);

                //System.out.printf(" %c ", board[i][j]);
            }
            System.out.println();
        }
        return false;
    }

    static boolean checkRows(char[][] board, int row) {

        HashSet<Character> set = new HashSet<>();
        for (int j = 0; j < board[row].length; j++) {  // columns
//            System.out.printf(" %c ", board[row][j]);
            char c = board[row][j];
            if (c != '.' && set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }

        return true;
    }


    static boolean checkColumns(char[][] board, int col) {

        HashSet<Character> set = new HashSet<>();

        System.out.println();
        for (int i = 0; i < board.length; i++) {   // rows

            char c = board[i][col];
            if (c != '.' && set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
//            System.out.print((char)board[i][col]);
//            System.out.print(" ");
        }
        return false;
    }

    static boolean checkBox(char[][] box, int dim) {


        return false;
    }


    static void print(char[][] board) {

        for (var rows : board) {
            for (var col : rows) {
                System.out.printf("'%c' ", col);

            }
            System.out.println();
        }
    }


    static long doubleArraySize(char[][] board) {

        long size = 0;

        for (var rows : board) {
            for (var col : rows) {
                size++;
            }
        }

        return size;
    }
}
