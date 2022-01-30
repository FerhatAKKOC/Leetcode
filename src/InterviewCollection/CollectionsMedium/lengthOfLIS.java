package InterviewCollection.CollectionsMedium;

import java.util.Arrays;
import java.util.Collections;

public class lengthOfLIS {

    public static void main(String[] args) {

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println("Output: " + lengthOfLIS(arr));

    }

    /*
        https://www.youtube.com/watch?v=Ns4LCeeOFS4
        https://www.youtube.com/watch?v=cjWnW0hdF1Y
        Longest Increasing Subsequence
     */
    private static int lengthOfLIS(int[] arr) {

        int n = arr.length;

        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);

        int max = 0;

        for (int i = 1; i < n; i++) {   // 1'den başlıyor

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && (LIS[j] + 1) > LIS[i])
                    LIS[i] = LIS[j] + 1;
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
    }
}
