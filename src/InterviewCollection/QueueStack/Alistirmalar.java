package InterviewCollection.QueueStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Alistirmalar {

    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        printImage(image);
        var output = floodFill(image, 1, 1, 2);
        printImage(image);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int source = image[sr][sc];
        floodFillDFS(image, sr, sc, source, newColor);

        return image;
    }

    private static void floodFillDFS(int[][] image, int sr, int sc, int source, int newColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != source)
            return;

        image[sr][sc] = newColor;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (var dir : directions) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            floodFillDFS(image, row, col, source, newColor);
        }
    }

    private static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}


















