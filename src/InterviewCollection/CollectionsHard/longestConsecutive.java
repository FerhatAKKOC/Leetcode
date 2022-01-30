package InterviewCollection.CollectionsHard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Output: " + longestConsecutive(nums));
    }

    /*
        Longest Consecutive Sequence
        https://www.youtube.com/watch?v=qgizvmgeyUM
        https://www.youtube.com/watch?v=P6RZZMu_maU
     */
    private static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        Arrays.stream(nums).forEach(set::add);

        int maxLCS = 0;

        for (var num : nums) {

            if (!set.contains(num - 1)) {  // en küçük değeri arayıp oradan itibaren taramaya başlıyoruz.

                int currNumber = num;
                int currLCS = 1;

                while (set.contains(currNumber + 1)) {
                    currLCS++;
                    currNumber++;
                }

                maxLCS = Math.max(maxLCS, currLCS);
            }
        }
        return maxLCS;
    }
}