package InterviewCollection.DynamicProgramming;

public class maxSubArray {

    public static void main(String[] args) {

        int arr[] = { -2,1,-3,4,-1,2,1,-5,4};

        System.out.println("Max : " + maxSubArray(arr));
    }

    private static int maxSubArray(int[] nums) {


        int maxEndingHere=nums[0];
        int maxSoFar=nums[0];

        for (int i = 1; i <nums.length ; i++) {
            maxEndingHere = Math.max(nums[i],nums[i] + maxEndingHere);
            maxSoFar = Math.max(maxEndingHere,maxSoFar);
        }

        return maxSoFar;
    }
}
