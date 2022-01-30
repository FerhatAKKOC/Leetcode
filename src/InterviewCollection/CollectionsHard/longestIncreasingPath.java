package InterviewCollection.CollectionsHard;

public class longestIncreasingPath {

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};

        System.out.println("Output: " + longestIncreasingPath(matrix));
    }


    private static int longestIncreasingPath(int[][] matrix) {

        int N = matrix.length;
        int M = matrix[0].length;

        int[][] cache = new int[N][M];

        int maxPath = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = dfs(matrix, i, j, cache);

                if (val > maxPath)
                    maxPath = val;
            }
        }

        return maxPath;
    }

    /*
        Longest Increasing Path in a Matrix
        https://www.youtube.com/watch?v=uLjO2LUlLN4

        Cahce '0' ile initialize edilecek ve her bir ziyaret edilen hücre için cache'e +1 yazılacak
     */

    private static int dfs(int[][] matrix, int i, int j, int[][] cache) {

        int N = matrix.length;
        int M = matrix[0].length;

        if (cache[i][j] > 0)    // ziyaret edilmişse, 1'den büyüktür.
            return cache[i][j];

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int maxPath = 0;
        for (var dir : directions) {

            int row = i + dir[0];
            int col = j + dir[1];

            if (0 <= row && row < N && 0 <= col && col < M && matrix[row][col] > matrix[i][j])// bigger value
            {
                int temp = dfs(matrix, row, col, cache);
                maxPath = Math.max(maxPath, temp);
            }
        }
        cache[i][j] = maxPath + 1;

        return cache[i][j];
    }
}
