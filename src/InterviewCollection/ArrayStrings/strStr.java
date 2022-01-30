package InterviewCollection.ArrayStrings;

public class strStr {
    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
        String haystack = "aajkdhsbbbaaaa", needle = "bba";

        System.out.println("Output: " + strStr(haystack, needle));

//        String name = "Ferat";
//        System.out.println(name.substring(0,2));
    }

    private static int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0)
            return 0;

        int size = needle.length();

        for (int i = 0; i < haystack.length() - size; i++) {
            var temp = haystack.substring(i, i + size);
            if (temp.equals(needle))
                return i;
        }


        return -1;
    }
}
