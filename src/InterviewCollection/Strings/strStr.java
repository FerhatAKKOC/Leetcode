package InterviewCollection.Strings;

import static java.lang.String.copyValueOf;

public class strStr {

    public static void main(String[] args) {

//        String haystack = "hello", needle = "ll";       //2
//        String haystack = "aaaaa", needle = "bba";    //-1
        String haystack = "aaaaabbafjhsdf", needle = "bba";    //-1
//        String haystack = "", needle = "";            //0

        System.out.println("Result : " + strStr(haystack, needle));

    }

    // Write security lines
    // create moving window which is size of needle
    static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) throw new NullPointerException("One of inputs is null");
        if (haystack == "" && needle == "") return 0;
        if (haystack == "" && needle != "") return -1;

        int count = needle.length();

        for (int i = 0; i < haystack.length() - count; i++) {

            var slicing = String.copyValueOf(haystack.toCharArray(), i, count);
            if (slicing.equals(needle)) {
//                System.out.println("slicing: " + slicing + "  index : " + i);
                return i;
            }
        }

        return -1;
    }
}
