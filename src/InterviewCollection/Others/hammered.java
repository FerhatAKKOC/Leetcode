import java.util.Map;

/*
    https://www.chegg.com/homework-help/questions-and-answers/n-nails-hammered-block-wood-nail-sticks-wood-length-choose-k-nails-hammer-length-original--q55376767
 */

public class hammered {

    public static void main(String[] args) {

//        int[] A = {1, 1, 3, 3, 4, 4, 4, 5, 5};         int K = 2;
//        int[] A = {1, 1, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6};        int K = 2;
        int[] A = {1, 2};
        int K = 1;


//        System.out.println("Output: " + maxCount2(A, K));
    }

    /* nails hammered */
    private static int maxCount(final int[] A, final int K) {

        int best = 0;
        int start = 0;

        while (start < A.length) {

            int end = start;

            while (end < A.length && A[end] == A[start]) {
                ++end;
            }

            best = Math.max(best, end - start + Math.min(K, A.length - end));

            start = end;
        }
        return best;
    }

    private static int maxCount2(final int[] A, final int K) {

        int n = A.length;
        int best = 0;
        int count = 1;

//        if(n==K) return K; I can return early

        for (int i = 0; i < n - K - 1; i++) {

            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 1;  // count is the number of the same length nails. So, if it reset '0', I can't find the length truly.

            if (count > best)
                best = count;
        }

        //{1};  int K = 0; result = 1;
        //{1};  int K = 1; result = 1;  normally Math.max(best + K, K + 1), In this case it returns '0', therefore I limited with length of array Math.min(K+1, n)=>1

        //{1, 2};  int K = 0; result = 1;
        //{1, 1};  int K = 0; result = 2;

        //{1, 2};  int K = 1; result = 2;
        //{1, 2};  int K = 2; result = 2;

        //{1, 2, 3};  int K = 2; result = 3;
        //{1, 2, 3};  int K = 3; result = 3;

        //{1, 2};  int K = 1; result = 2; to return 2, I need K+1
        int result = Math.max(best + K, Math.min(K + 1, n)); // if n == K, I will return n.
//        int result = Math.max(best + K, K + 1);

        return result;
    }
}
