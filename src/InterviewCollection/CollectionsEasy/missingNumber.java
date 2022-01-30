package InterviewCollection.CollectionsEasy;

public class missingNumber {

    public static void main(String[] args) {

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        int[] nums = {0, 1};
//        int[] nums = {0};

        System.out.println("Output: " + missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {

        int n = nums.length;
        int total = (n * (n + 1)) / 2;

        for (var num : nums) {
            total -= num;
        }

        return total;
    }
}
