package InterviewCollection.Recursions;

public class searchMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

//        for ( var a: matrix){
//            Arrays.stream(a).forEach(System.out::print);
//            System.out.println();
//        }

        System.out.println("Output : " + searchMatrix(matrix, 5));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {


        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ||
                target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] > target)
                --col;
            else
                ++row;
        }

        return false;
    }


}
