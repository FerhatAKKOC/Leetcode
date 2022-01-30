package InterviewCollection.Amazon;

public class strStr {

    public static void main(String[] args) {
        String haystack = "hell", needle = "ll";

        System.out.println("Output: " + strStr(haystack, needle));

    }


    private static int strStr(String haystack, String needle) {


        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        int n = needle.length();
        int h = haystack.length();

        for (int i = 0; i < h; i++) {
            if (i + n <= h && haystack.substring(i, i + n).equals(needle))
                return i;
        }

        return -1;
    }
}
