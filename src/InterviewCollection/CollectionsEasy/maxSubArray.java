package InterviewCollection.CollectionsEasy;

public class maxSubArray {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Output: " + maxSubArray(nums));
    }

    /*
        algorithm that operates on arrays: it starts at the left end (element A[1]) and scans through to the right end (element A[n]),
        keeping track of the maximum sum subvector seen so far. The maximum is initially A[0].
        Suppose we've solved the problem for A[1 .. i - 1]; how can we extend that to A[1 .. i]? The maximum
        sum in the first I elements is either the maximum sum in the first i - 1 elements (which we'll call MaxSoFar),
        or it is that of a subvector that ends in position i (which we'll call MaxEndingHere).

        MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just A[i], whichever is larger.
     */
    private static int maxSubArray(int[] nums) {

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            // System.out.println(maxEndingHere);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
    /*
    My thought process:
    Array: [-2,1,-3,4,-1,2,1,-5,4]

    If all elements were positive, the answer would be the total sum.

    But here we have negative numbers, so we should avoid them.
    So, we could have sums of positive numbers on left and right of each negative number. And maximum of these sums is the answer.

    But there is this hidden case when including a negative number helps: when the elements or sum of elements left or right to the negative element is greater than the negative element itself. **This is the key observation of this problem.**
    eg: [2 -1 3]: here including -1 would only help me in getting better answer by adding 2 and 3 while subtracting just -1.

    Now as I got an idea of the problem, i would start solving step by step considering 1 element at a time.

    Considered if the array had only 1 element: [-2]
    Since array now has only 1 element I could only choose -2.

    Considered if the array had 2 elements: [-2, 1]
    ans:

    is the new element (1) greater than the previous ans: YES
    is prev element (-2) + new element (1) greater than the new element (1): NO
    So since new element (1) is greater than than both the cumulative sum(new element, previous element) and prev ans -2, I would choose the new element 1. (Also I would update cumulative sum to be this new element 1, for future incoming elements. **This is the key lesson of this pattern**)
    [-2,1,-3]
    ans: I would use the previous logic:
    Is the new element (-3) greater than the previous ans (1): NO
    Is the new cumulative sum(prev cumulative sum, new element) > new element: NO
    So I choose prev ans: 1
    ..... so on
     */
}
