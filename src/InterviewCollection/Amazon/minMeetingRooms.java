package InterviewCollection.Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minMeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {{8, 12}, {1, 10}, {3, 19}, {11, 30}, {2, 7}, {10, 20}};

        System.out.println("Output: " + minMeetingRooms(intervals));
    }

    /*
        Meeting Rooms II
     */
    private static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // ending time

        pq.offer(intervals[0][1]); // ilk başlayan toplantının ending time'ı eklendi.
        for (int i = 1; i < intervals.length; i++) {

            var nextStart = intervals[i][0];
            var nextEnd = intervals[i][1];

            if (nextStart > pq.peek())
                pq.poll();

            pq.add(nextEnd);
        }
        return pq.size();
    }
}
