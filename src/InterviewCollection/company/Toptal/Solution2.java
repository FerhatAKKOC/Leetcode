package InterviewCollection.company.Toptal;

import java.util.PriorityQueue;

public class Solution2 {

    public static void main(String[] args) {
//        int[] nums = {10, -10, -1, -1, 10};
//        int[] nums = {-1, -1, -1, 1, 1, 1, 1};
        int[] nums = {5, -2, -3, 1};

        System.out.println("Output: " + solution(nums));
    }

    /*Codelity
     A company has a list of expected revenues and payments for the upcomming year in chronological year
     Minimum number of relocations
    * */
    private static int solution(int[] A) {

        int n = A.length;

        int relocationCount = 0;
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap

        for (int i = 0; i < n; i++) {

            sum += A[i];

            if (A[i] < 0)
                pq.offer(A[i]);

            if (sum < 0 && !pq.isEmpty()) {
                var minVal = pq.poll();
                sum -= minVal;
                relocationCount++;
            }
//            else if (sum < 0) {
//                break;
//            }
        }

        return relocationCount;
    }
}
