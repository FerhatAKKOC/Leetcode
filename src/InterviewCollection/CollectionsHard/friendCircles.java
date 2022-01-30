package InterviewCollection.CollectionsHard;

public class friendCircles {

    public static void main(String[] args) {
//        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        System.out.println("Output: " + findCircleNum(isConnected));
    }

    private static int findCircleNum(int[][] isConnected) {

        int N = isConnected.length;
        int M = isConnected[0].length;

        int counter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isConnected[i][j] == 1) {
                    counter++;
                    DFS(isConnected, i, j);
                }

            }
        }
        return counter;
    }

    private static void DFS(int[][] isConnected, int i, int j) {
        int N = isConnected.length;
        int M = isConnected[0].length;

        isConnected[i][j] = 0;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {

            int row = i + dir[0];
            int col = j + dir[1];

            if (0 <= row && row < N && 0 <= col && col < M && isConnected[row][col] == 1)
                DFS(isConnected, row, col);
        }
    }
}
