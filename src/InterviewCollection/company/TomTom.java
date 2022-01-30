package InterviewCollection.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TomTom {

    public static void main(String[] args) {
        //int[] A = {8, 8, 4, 3}; int K = 2;
//        int[] A = {5, 3, 6,1};        int K = 4;
        int[] A = {5, 3, 1, 3, 9, 8};        int K = 4;

        System.out.println("Output : " + solution(A, K));
    }

    // Space complexity => O(1)
    // Time complexity => O(n2) nested for loop
    private static int solution(int[] A, int K) {


        if(A.length == K) // if A = {5, 3, 6}; and K=3, in this case we return '0' early.
            return 0;

        if((K+1) == A.length) { // if A = {5, 3, 6}; and K=2, in this case we find min value.
            Arrays.sort(A);
            return A[0];
        }


        //  // I create a moving windows with size of K. ptr is a pointer which indicates the beginning of the window

        int minAmplitue = Integer.MAX_VALUE;

        for (int pStart = 0; pStart <= A.length - K; pStart++) { // with 'ptr', I shift this window one-by-one

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < A.length; i++) {

                if (pStart <= i && i < pStart + K) {
                    continue;                       // I ignore this window elements. Because, in the question, we remove consecutive elements.
                }
                if (A[i] < min) min = A[i];
                if (A[i] > max) max = A[i];
            }
            minAmplitue = Math.min(minAmplitue, max - min);  // Each pStart shifting, I found minimum value and store it. When the code hits here, we finish the whole iteration for one window shifting
            //System.out.println("pStart: " + pStart + "\tminAmplitue: " + minAmplitue);
        }
        return minAmplitue;
    }
}
