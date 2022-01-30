package InterviewCollection.CollectionsEasy;

public class longestCommonPrefix {

    public static void main(String[] args) {

//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(strs));
    }

    /*
        Input: strs = ["flower","flow","flight"]
        Output: "fl"
     */
    private static String longestCommonPrefix(String[] strs) {

        var lcp = strs[0];

        for (int i = 1; i < strs.length; i++) {
            lcp=longestCommonPrefix(lcp,strs[i]);
        }

        return lcp;
    }

    private static String longestCommonPrefix(String s1, String s2) {

        int ptr = 0;
        while (ptr < s1.length() && ptr < s2.length()) {

            if (s1.charAt(ptr) == s2.charAt(ptr))
                ptr++;
            else
                break;
        }

        return s1.substring(0, ptr);
    }
}
