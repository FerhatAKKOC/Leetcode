package InterviewCollection.CollectionsHard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
    Find Median from Data Stream
    https://www.youtube.com/watch?v=1LkOrc-Le-Y
    https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
 */
public class medianFinder {

    public static void main(String[] args) {


    }

    PriorityQueue<Integer> minHeap; // right half
    PriorityQueue<Integer> maxHeap; // left half

//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));


    public medianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());      // left(2) right(3) olsun. left'de 7 eklersek bunun bir şekilde right'a atanıp daha sonra size kontrolü yapılmalıdır.

        if(minHeap.size()<maxHeap.size()){  // fazlalık her zaman left'de olmalıdır.
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
