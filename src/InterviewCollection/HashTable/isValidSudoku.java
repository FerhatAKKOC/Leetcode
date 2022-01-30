package InterviewCollection.HashTable;

import java.util.HashSet;

public class isValidSudoku {

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

//        System.out.println("Output : " + isValidSudoku(board));

        System.out.println(7/3);  // 2
        System.out.println(7%3);  // 1
        System.out.println(2/3);  // 0
        System.out.println(2%3);  // 2

    }

    private static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {

            HashSet<Character> rows = new HashSet<Character>();

            HashSet<Character> columns = new HashSet<Character>();

            HashSet<Character> cube = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i])) // i'yi sabit tutuyoruz ve row'ları arttıtıyoruz.
                    return false;

                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);

                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' &&

                        !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))

                    return false;

            }
        }
        return true;
    }

}
