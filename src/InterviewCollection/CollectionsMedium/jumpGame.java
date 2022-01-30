package InterviewCollection.CollectionsMedium;

public class jumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};

        System.out.println("Output: " + canJump(nums));
    }

    /*
        Jump Game
     */
    /*
    Idea is to work backwards from the last index.    Keep track of the smallest index that can "jump" to the last index.
    Check whether the current index can jump to this smallest index.

    Note: steps, bize yapabileceğimiz max jump'ı verir.

        nums[1] = 2
        nums[1] = 3
        nums[2] = 1
        nums[3] = 1
        nums[4] = 4

        Mesala 3. index'ten 4. index'' ulaşabilmek için 3(index) + 1 > 4(index) olmalıdır. Bu şart sağlıyorsa
        artık son indekse değilde bir öncekine ılaşmamda yeterlidir.
     */

    private static boolean canJump(int A[]) {

        int n = A.length;

        int last = n - 1, i, j;

        for (i = n - 2; i >= 0; i--) {
            if (i + A[i] >= last) last = i;
        }

        return last <= 0;
    }

}
