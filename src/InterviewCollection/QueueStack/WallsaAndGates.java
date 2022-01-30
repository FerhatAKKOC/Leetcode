package InterviewCollection.QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class WallsaAndGates {

    public static void main(String[] args) {

        int[][] room = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};

        printRoom(room);
        WallsAndGates(room);
        printRoom(room);
    }

    // Walls and Gates
    private static void WallsAndGates(int[][] room) {

        int N = room.length;
        int M = room[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // determine gates ('0')
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            var cord = queue.poll();
            for (var dir : directions) {
                var row = dir[0] + cord[0];
                var col = dir[1] + cord[1];

                if (row >= 0 && row < N && col >= 0 && col < M && room[row][col] == Integer.MAX_VALUE) {
                    room[row][col] = room[cord[0]][cord[1]] + 1;
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }

    private static void printRoom(int[][] room) {

        System.out.println("--- ------------------------------");
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                System.out.print(room[i][j] + "\t\t\t");
            }
            System.out.println();
        }
    }
}













