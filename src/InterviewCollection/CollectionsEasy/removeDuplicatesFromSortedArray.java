package InterviewCollection.CollectionsEasy;

public class removeDuplicatesFromSortedArray {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1, 1, 2};
        System.out.println("K: " + removeDuplicates(nums));
        for (var a : nums) System.out.print(a + " ");
    }

    /*
        Remove Duplicates from Sorted Array
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;

        int slow = 0;
        int counter = 1;

        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[slow] == nums[fast])
                continue;

            nums[++slow] = nums[fast];

            counter++;
        }

        return counter;
    }
}
