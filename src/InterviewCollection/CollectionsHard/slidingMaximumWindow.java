package InterviewCollection.CollectionsHard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class slidingMaximumWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        var output = maxSlidingWindow(nums, k);
        Arrays.stream(output).forEach(System.out::print);
    }

    /*
        https://www.youtube.com/watch?v=CZQGRp93K4k

        1. 'front' taraftaki elemanın index'ine bakıyoruz. Eğer k sayını aşacak şekle gelmişsek, yeni eleman için onu atmamız lazım.
            Zaten o artık, o anki window'un dışına çıkmıştır.
     */
    private static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int iter = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!deque.isEmpty() && (i - deque.peekFirst()) >= k) { // her zaman 'k' kadar bir pencere açıyoruz. Pencere limitini aşarsak, queue'dan bir eleman siliyoruz.
                deque.pollFirst();
            }

            while (!deque.isEmpty() && (nums[deque.peekLast()] < nums[i])) // ekleyeceğimiz eleman, kendinden soldaki küçük elemanları çıkardıktan sonra ekleniyor. Soldakilerin bir önemi yok çünkü, sonucu etkilemiyorlar.
                deque.pollLast();

            deque.offerLast(i);

            if (i >= k - 1)  // ilk initial anında, en az k kadar elemanın tarayıp, window'u tamamlamamız lazım. Tamamlanınca eklemeyte başlıyoruz
                res[iter++] = nums[deque.peekFirst()];  // Yani ilk 'k' iteration'da hiç birşey eklemiyoruz.
        }

        return res;

    }
}
