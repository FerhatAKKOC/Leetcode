package InterviewCollection.CollectionsMedium;

public class uniquePaths_II {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}};
        print(obstacleGrid);
        System.out.println("Output: " + uniquePaths(obstacleGrid));
    }

    /*
        https://www.youtube.com/watch?v=z6kelCB0ww4
    */
    private static int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Bir row yada column'da obstacle varsa, arkasındaki bütün cell'leri '0' ile dolduruyoruz.

        boolean obstacle = false;

        // Fill 1st row
        for (int i = 0; i < n; i++) {

            if (obstacle || grid[0][i] == 1) {
                dp[0][i] = 0;
                obstacle = true;
            } else {
                dp[0][i] = 1;
            }
        }


        // Fill 1st column
        obstacle = false;
        for (int i = 0; i < m; i++) {

            if (obstacle || grid[i][0] == 1) {
                dp[i][0] = 0;
                obstacle = true;
            } else {
                dp[i][0] = 1;
            }
        }

        // Dikkat edilmesi gereken tek şey  index'lerin 1'den başlaması

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (grid[i][j] == 1)     // obstacle'larıda burada '0' yapıyoruz.
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        print(dp);
        return dp[m - 1][n - 1];
    }

    private static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("------------------------------");

    }
}
