package InterviewCollection.Amazon;

public class maxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Output: " + maxSubArray(nums));
    }

    /*
        Maximum Subarray
        https://www.youtube.com/watch?v=86CQq3pKSUw
        Kadane's Dynamic Programs
     */
    private static int maxSubArray(int[] nums) {

        int maxlocal = nums[0];
        int maxglobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxlocal = Math.max(nums[i], nums[i] + maxlocal);
            maxglobal = Math.max(maxglobal, maxlocal);
        }

        return maxglobal;
    }
    /*
        1. ilk durumda sub array -2'dir.
           Daha sonra -2+1 = -1'dir. Bu değer -1<1'dir. Dolayısıyla bu döngüyü devam ettirmenin bir anlamı yoktur. LocalMax için yeni br döngü başlatıyoruz.
           Burada temel mantık, previous sum benim şu anki index değerimi düşürüyor mu düşürmüyor mu? Düşürüyorsa önceki sum'a ihtiyaç duymuyoruz ve onu atuyoruz. Yeni bir sum'a başlıyoruz.
        2. Her localMax hesaplandığında onu globalMax ile karşılaştırıyoruz.


     */
}
