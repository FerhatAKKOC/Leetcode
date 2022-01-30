package InterviewCollection.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeInterval {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        var outputs = merge(intervals);
        for (var output : outputs) {
            System.out.println(output[0] + " " + output[1]);
        }
    }

    private static int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return null;
        }

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (var interval : intervals) {

            if (end >= interval[0])
                end = interval[1];
            else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        list.add(new int[]{start, end});
        return list.stream().toArray(int[][]::new);
    }
}
