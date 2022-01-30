package InterviewCollection.Amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class findKthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println("Output: " + findKthLargest(nums, k));
    }

    /*
        Kth Largest Element in an Array
     */
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k)
                pq.poll();      // Kapasite doldukça, en küçük elemanı sürekli poll edersek, queue da largest elemanlar kalır.
        }

        // output
        return pq.poll();
    }
}
