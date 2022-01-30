package InterviewCollection.CollectionsHard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class perfectSquares {

    public static void main(String[] args) {

        System.out.println("Output: " + numSquares(13));
    }

    private static int numSquares(int num) {

        if (num < 3) return num;


        Deque<Integer> deque = new ArrayDeque<>();

        deque.offerLast(num);


        int counter = 0;
        while (!deque.isEmpty()) {

            int size = deque.size();

            counter++;

            while (size-- > 0) {

                int n = deque.pop();
                for (int i = 1; i < n; i++) {

                    if (i * i < n)
                        deque.offerLast(n - i * i);
                    else if (i * i == n)
                        return counter;
                    else
                        break;
                }
            }
        }

        return counter;
    }
}
