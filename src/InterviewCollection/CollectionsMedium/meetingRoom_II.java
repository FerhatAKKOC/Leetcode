package InterviewCollection.CollectionsMedium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRoom_II {

    public static void main(String[] args) {

        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}, {21, 25}, {0, 15}};

        System.out.println("Output: " + minMeetingRooms(intervals));
    }

    /*

    https://www.youtube.com/watch?v=FdzJmTCVyJU


    Sort the intervals according to the starting time.
    Use a minHeap(pq) to save the endTime for all intervals according to the order of start time.
    Add end time to the pq.
    if cur start time < pq.peek() => means current start time is before first ending time, which means we must have a new room.
    if cur start time >= pq.peek() => means we can use this room for the meeting, we poll out the the original period and add current period to the pq(Means we update the room with the new meeting).
     */

    private static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return 0;

        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;

        for (int i = 0; i < intervals.length; i++) {

            pq.offer(end[i]);  // önce hep ending time'ı ekliyoruz.

            var peek = pq.peek();

            if (start[i] < peek)
                room++;
            else {
                pq.poll();
            }
        }
        return room;
    }
}