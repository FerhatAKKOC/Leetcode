package InterviewCollection.Array;

public class DuplicateZeros {

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

        duplicateZeros(arr);


        for (var a : arr)
            System.out.print(a + " ");
    }

    /*
        Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
        Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

        Input: arr = [1,0,2,3,0,4,5,0]
        Output: [1,0,0,2,3,0,0,4]

     */
    private static void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                carryZero(arr, i);
                i++;
            }
        }
    }

    private static void carryZero(int[] arr, int i) {

        arr[arr.length - 1] = 0;

        for (int j = arr.length - 1; i < j; j--) {
            var temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
        }
    }
}
