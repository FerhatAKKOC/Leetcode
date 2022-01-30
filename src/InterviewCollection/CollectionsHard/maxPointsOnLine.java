package InterviewCollection.CollectionsHard;

import java.util.HashMap;

public class maxPointsOnLine {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};

        System.out.println("Output: " + maxPoints(points));
    }

    /*
        https://leetcode.com/explore/interview/card/top-interview-questions-hard/123/math/873/discuss/47113/A-java-solution-with-notes
     */
    private static int maxPoints(int[][] points) {

        if (points == null) return 0;
        int n = points.length;
        if (n <= 2) return n;

        int result = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.clear();

            int max = 0;

            for (int j = i + 1; j < n; j++) {

                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];

                int gcd = gcd(x, y); // gcd will never be zero.  y/x = slope. Greates Common Divisor
                x /= gcd;
                y /= gcd;

                String key = x + ":" + y;

                map.put(key, map.getOrDefault(key, 1) + 1); // Daha önce kayıtlı değilse, 2 nokta için 2 kaydediyoruz. Bundan dolayı default 1 geliyor.

                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max);
        }
        return result;
    }


    // greatest common divisor
    private static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
/*
 *  A line is determined by two factors,say y=ax+b
 *
 *  If two points(x1,y1) (x2,y2) are on the same line(Of course).

 *  Consider the gap between two points.

 *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

 *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

 *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

 *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

 *  So we can use y0&x0 to track a line;
 */