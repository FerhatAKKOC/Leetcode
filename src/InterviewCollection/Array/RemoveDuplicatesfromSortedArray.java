package InterviewCollection.Array;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {

//        Input: nums = [0,0,1,1,1,2,2,3,3,4]
//        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        var output = removeDuplicates(nums);

        System.out.println("k = " + output);
        System.out.println();
        for (int a : nums)
            System.out.print(a + " ");
    }

    static int removeDuplicates(int[] nums) {

        int start = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                start++;
                nums[start] = nums[i];
            }
        }

        return start + 1;
    }
}
