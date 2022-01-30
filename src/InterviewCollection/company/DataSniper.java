package InterviewCollection.company;

import java.util.Arrays;

public class DataSniper {

    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 4, 3, 1};
//        int[] arr = {1,3,3,4};

        System.out.println(find_mistake(arr));
    }

    public static int find_mistake(int[] nums) {

        int n = nums.length;

        java.util.Arrays.sort(nums);

        int duplicate = -1;
        int missing = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == nums[i]) {
                duplicate = nums[i];
            }
            if (nums[i - 1] != i) {
                missing = i;
            }
        }

        return duplicate + missing;
    }


    private static int isPolindrom(String str) {

        int count = 0;
        if (str.length() == 1) return 0;
        if (str.length() == 2 && str.charAt(0) != str.charAt(1)) return 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(str.length() - i))
                count++;
        }
        if (str.length() % 2 != 0)
            count++;

        return count;
    }

    public static boolean can_reach_end(int[] nums) {

        for (int i = nums.length - 1; 1 < i; i--) {
            if(nums[i]-nums[i-1] < nums[i] )
                return false;
        }
        return true;
    }
}
