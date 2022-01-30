package InterviewCollection.CollectionsMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class mergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        var outputs = mergeIntervals(intervals);

        for (var out : outputs) {
            System.out.println("[" + out[0] + ", " + out[1] + "]\t ");
        }
    }

    /*
        Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
        and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */
    private static int[][] mergeIntervals(int[][] inter) {

        int min = inter[0][0];
        int max = inter[0][1];

        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < inter.length; i++) {
            if (inter[i][0] <= max) {
                max = inter[i][1];
            } else {
                list.add(new int[]{min, max});

                if (i < inter.length) {
                    min = inter[i][0];
                    max = inter[i][1];
                }
            }
        }

        list.add(new int[]{min, max});

        int[][] arrays = list.stream().map(ints -> ints).toArray(int[][]::new); // list to 2D array

        return arrays;
    }
}
