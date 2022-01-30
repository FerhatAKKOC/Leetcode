package InterviewCollection.CollectionsHard;

public class productExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        var output = productExceptSelf(nums);

        for (var a : output)
            System.out.print(a + ", ");
    }

    /*
        https://www.youtube.com/watch?v=gREVHiZjXeQ
     */
    private static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int leftMulti = 1;
        for (int i = 0; i < n; i++) {   // left side
            leftMulti *= nums[i];
            res[i] = leftMulti;
        }

        int rightMulti = 1;
        for (int i = n - 1; 1 <= i; i--) {
            res[i] = res[i - 1] * rightMulti;
            rightMulti *= nums[i];
        }

        res[0] = rightMulti; // edge case'dir. Son elemanı dışarıda atıyoruz, loop içerisinde değil.

        return res;
    }
}
