package InterviewCollection.CollectionsMedium;

public class searchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; int target = 0;
//        int[] nums = {4, 5, 6, 7, 0, 1, 2}; int target = 3;
//        int[] nums = {1}; int target = 0;

        System.out.println("Output: " + search(nums, target));
    }

    /*
     Search in Rotated Sorted Array

     Bu yöntemde her zaman 'left' yada 'right' side'ın uniformly increasing olduğunu biliyoruz. Target o aralıkta ise o aralığı arıyoruz.
     Burada en önemli nokta, eğer 'mid'== target olup olmadığına her zaman bakmak.
     */
    private static int search(int[] nums, int target) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;


        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {  // 'left side' uniformly increasing

                if (nums[left] <= target && target <= nums[mid]) {   // 'target' is in the rigth side
                    right = mid - 1;
                } else {
                    left = mid + 1; // 'target' is not in the right side
                }
            } else {  // 'right side' strictly increasing

                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
