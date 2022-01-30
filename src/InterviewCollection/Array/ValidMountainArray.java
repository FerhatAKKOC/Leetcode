package InterviewCollection.Array;

public class ValidMountainArray {

    public static void main(String[] args) {

//        int[] arr = {0, 2, 3, 4, 5, 2, 1, 0};
//        int[] arr = {0, 2, 3, 3, 5, 2, 1, 0};
//        int[] arr = {0,3,2,1};
        int[] arr = {3, 5, 5};

        System.out.println("Output : " + validMountainArray(arr));
    }

    private static boolean validMountainArray(int[] arr) {


        if (arr == null || arr.length <= 2) return false;

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] >= arr[start + 1] || arr[end] >= arr[end - 1])
                if (arr[start] != arr[end - 1])
                    return false;

            start++;
            end--;
        }


        return true;

    }
}
