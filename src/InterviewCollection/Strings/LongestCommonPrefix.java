package InterviewCollection.Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    /*
    Input: strs = ["flower","flow","flight"]
        Output: "fl"
     */

    public static void main(String[] args) {
        var strs = new String[]{"flower", "flow", "flight", "fsda"};    //Output: "fl"
        //   var strs = new String[]{"dog","racecar","car"};         //Output: ""

//        var Output = longestCommonPrefix1(strs);
//
//        System.out.println("Output : " + Output);

    }


    // empty or null string
    // element which has min length .Java streams
    // two nested for loop
    // startwith
    static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        var min = Arrays.stream(strs).min((a, b) -> Integer.compare(a.length(), b.length()));


        StringBuilder sb = new StringBuilder(min.get());

        while (sb.length() > 0) {

            var checking = sb.toString();

            for (String str : strs) {

                if (str.startsWith(checking)) {
                    if (str.equals(strs[strs.length - 1]))
                        return checking;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                    if (sb.length() == 0) return "";
                    break;
                }
            }
        }

        return "";
    }

    static String longestCommonPrefix1(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        //String prefix =  Arrays.stream(strs).min((a, b) -> Integer.compare(a.length(), b.length())).get();

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix == "") return "";
            }
        }
        return prefix;
    }

    static String CommonPrefix(String left, String right) {

        var min = Integer.min(left.length(), right.length());

        for (int i = 0; i <min ; i++) {
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return "";
    }
}
