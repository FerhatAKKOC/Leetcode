package InterviewCollection.Recursions;

import java.util.HashSet;
import java.util.Set;

public class robotRoomCleaner {

    public static void main(String[] args) {

        int[][] room = {{1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}};
        int row = 1;
        int col = 3;

    }

    private void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();

        cleanRoom(robot, 3, 1, 0, visited);
    }

    private void cleanRoom(Robot robot, int row, int col, int curDir, Set<String> visited) {

        String cordinate = row + "@" + col;
        robot.clean();
        visited.add(cordinate);

//        if (visited.contains(cordinate)) return;

        int[][] directions = {{-1, 0}, {0, 1}, {0, 1}, {0, -1}};

        for (int i = 0; i < 4; i++) {

            var dir = directions[(curDir + i) % 4]; // (curDir + i) % 4 belki ilk direction farklı bir noktada da gelebilirdi.

            row = row + dir[0];
            col = col + dir[0];

            cordinate = row + "@" + col;

            if (!visited.contains(cordinate) && robot.move()) {
                cleanRoom(robot, row, col, (curDir + i) % 4, visited);

                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
        }
    }
}


interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}
