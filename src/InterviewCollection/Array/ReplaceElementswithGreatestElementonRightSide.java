package InterviewCollection.Array;

public class ReplaceElementswithGreatestElementonRightSide {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};

        replaceElements(arr);

        for (var a : arr)
            System.out.print(a + " ");
    }

    /*
    Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
    Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]
     */
    private static int[] replaceElements(int[] arr) {

        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int n = arr.length;
        int max = -1;   // sağ taraftan iterate ederek, max değerini her zaman tutuyoruz.
        int temp;

        for (int i = n - 1; i >= 0; --i) {
            temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}
