package InterviewCollection.CollectionsMedium;

import java.util.Arrays;

public class searchRange {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
//        int[] nums = {5, 7, 7, 8, 8, 10}; int target = 6;

        var outputs = searchRange(nums, target);
        Arrays.stream(outputs).forEach(System.out::print);

        double left = target - 0.5, right = target + 0.5;

        System.out.println("\n" + left + "   " + right);
    }

    private static int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        if (nums.length == 0)
            return res;


        boolean isFound = false;
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;    // int mid = l + (high - low)/2;

            if (nums[mid] == target) {


                while (nums[mid] == target) mid--; // low indice
                res[0] = ++mid;

                while (nums[mid] == target) mid++;  // high indice
                res[1] = --mid;

                return res;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }


        return res;
    }


//***************************************************
//***************************************************
//***************************************************
/*
    2 tane binary search algoritması kullanıyoruz.ç

 */

    public int[] searchRange2(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {

        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] >= target) {    // target'ı bulsak bile, hala 'end' i sola doğru kaydırıyoruz. Belki solda hala aynı elemandan var.
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (nums[mid] == target) idx = mid;
        }

        return idx;
    }

    private int findLast(int[] nums, int target) {

        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] <= target) {  // target'ı bulsak bile, hala 'start' ı sağa doğru kaydırıyoruz. Belki solda hala aynı elemandan var. Yoksa bile aşağıda bu değet 'idx' de tutulacaktır.
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (nums[mid] == target) idx = mid;
        }

        return idx;
    }

}



