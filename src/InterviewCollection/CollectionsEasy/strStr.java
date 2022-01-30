package InterviewCollection.CollectionsEasy;

public class strStr {
    public static void main(String[] args) {

        String haystack = "hello", needle = "ll";
        System.out.println("Output: " + strStr(haystack, needle));

    }

    private static int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
