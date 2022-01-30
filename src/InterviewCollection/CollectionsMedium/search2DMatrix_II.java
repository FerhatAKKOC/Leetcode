package InterviewCollection.CollectionsMedium;

public class search2DMatrix_II {

    public static void main(String[] args) {


        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 5;

        System.out.println("Output: " + search2DMatrix_II(matrix, target));

    }

    /*
        Search a 2D Matrix II
     */
    private static boolean search2DMatrix_II(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= matrix.length - 1) {

            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }

        return false;
    }
}
