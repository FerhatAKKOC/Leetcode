package InterviewCollection.QueueStack;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 3}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        show(image);

        var result = floodFill(image, sr, sc, newColor);

        show(image);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        return floodFill(image, sr, sc, image[sr][sc], newColor);

    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int currColor, int newColor) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != currColor)
            return image;

        image[sr][sc] = newColor;

        floodFill(image, sr + 1, sc, currColor, newColor);
        floodFill(image, sr - 1, sc, currColor, newColor);
        floodFill(image, sr, sc + 1, currColor, newColor);
        floodFill(image, sr, sc - 1, currColor, newColor);

        return image;
    }


    private static void show(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }


    //****************************************************************
    //****************************************************************
    //****************************************************************
    private static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int source = image[sr][sc];
        floodFillDFS2(image, sr, sc, source, newColor);

        return image;
    }

    private static void floodFillDFS2(int[][] image, int sr, int sc, int source, int newColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != source)
            return;

        image[sr][sc] = newColor;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            floodFillDFS2(image, row, col, source, newColor);
        }
    }
}
