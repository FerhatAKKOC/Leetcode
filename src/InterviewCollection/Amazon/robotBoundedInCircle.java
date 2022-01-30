package InterviewCollection.Amazon;

public class robotBoundedInCircle {

    public static void main(String[] args) {

        String instructions = "GGLLGG";

        System.out.println("Output: " + inCircle(instructions));
    }

    /*
        Robot Bounded In Circle
        https://www.youtube.com/watch?v=nKv2LnC_g6E
     */
    private static boolean inCircle(String str) {

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[] curr = {0, 0};
        int dir = 1;

        for (var ch : str.toCharArray()) {

            if (ch == 'G') {
                curr[0] += directions[dir][0];
                curr[1] += directions[dir][1];
            } else if (ch == 'L') {
                if (--dir < 0) dir = 3;
            } else if (ch == 'R') {
                if (++dir > 3) dir = 0;
            }
        }

        return curr[0] == 0 && curr[1] == 0;
    }
}
