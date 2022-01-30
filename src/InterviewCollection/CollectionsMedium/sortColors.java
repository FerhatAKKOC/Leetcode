package InterviewCollection.CollectionsMedium;

import java.util.Arrays;

public class sortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }

    // Bu yöntemde '0' sola, '2' ler sağa atılır ve ortada '1' ler kalır
    private static void sortColors(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        for (int i = low; i <= high; ) {
            if (nums[i] == 0) {
                swap(nums,i,low);
                i++;
                low++;
            } else if (nums[i] == 2) {
                swap(nums,i,high);
                high--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

