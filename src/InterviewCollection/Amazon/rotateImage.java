package InterviewCollection.Amazon;

public class rotateImage {

    public static void main(String[] args) {

        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};

        print(matrix);
        rotate(matrix);
        print(matrix);
    }

    private static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int n = matrix[i].length - 1;
                int temp = matrix[i][n - j];
                matrix[i][n - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
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
