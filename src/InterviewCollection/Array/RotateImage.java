package InterviewCollection.Array;

public class RotateImage {


    /*
        Input:  [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     */
    public static void main(String[] args) {

        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        printArray(matrix);
        rotate(matrix);


    }

    static void rotate(int[][] matrix) {
        transpoze(matrix);
        printArray(matrix);
        reflect(matrix);
    }

    private static void transpoze(int[][] matrix) {

        int n = matrix.length;
        System.out.println("---Transpose --- :" + n);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reflect(int[][] matrix) {
        int n = matrix.length;
        System.out.println("---Reflection --- :" + n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        printArray(matrix);
    }


    private static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
