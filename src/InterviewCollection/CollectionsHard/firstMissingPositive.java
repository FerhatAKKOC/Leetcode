package InterviewCollection.CollectionsHard;

public class firstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 3, -2};
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {7, 8, 9, 11, 12};
        System.out.println("Output: " + firstMissingPositive(nums));
    }

    /*
        https://www.youtube.com/watch?v=2QugZILS_Q8
        https://www.youtube.com/watch?v=9SnkdYXNIzM

        First Missing Positive

        Temel mantık Space O(1) yapmak için set'i taklit ediyoruz.
     */
    private static int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) return 1;

        int n = nums.length;
        int containsOne = 0;

        // step 1. Check '1' exists?
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                containsOne = 1;
            else if (nums[i] < 0 || nums[i] > n) { // 0'dan küçük sayıları ve n'den büyük sayıları "1" yapıyoruz. "1" yapmamızın nedeni aslında daha önceden dizide "1" olduğunu biliyoruz.
                nums[i] = 1;
            }
        }
        if (containsOne == 0) return 1;

        // step 2
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // daha önce negatif yapılmış olabilir.

            if (nums[index] > 0)  // daha önce negatif yapılmamış ise
                nums[index] *= -1;
        }

        // step 3

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;  // first pozitif number'u alıyoruz.
        }

        // all value in array are pozitive
        return n + 1;
    }


    //***************************************************
    //***************************************************
    private static int firstMissingPositive2(int[] nums) {

        int n = nums.length;

        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1

        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;  // ignore (n+1) values
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];  // daha önce negative yaptığımız birşeyi tekrardan pozitive yapmıyoruz.
            }
        }

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }

}
