package InterviewCollection.CollectionsHard;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class largestNumber {

    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};

        System.out.println("Output: " + largestNumber(nums));
    }

    /*
        Largest Number
        https://www.youtube.com/watch?v=q_biivSGbV0
        String'e çevirip, toplayıp karşılaştıracağız. (2+10).compare(10+2) => 120.compare(102). Büyük olan önce yazılacak.
     */
    private static String largestNumber(int[] nums) {

        var str = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String s = str.stream().collect(Collectors.joining());

        return s.startsWith("0") ? "0" : s;
    }
}
