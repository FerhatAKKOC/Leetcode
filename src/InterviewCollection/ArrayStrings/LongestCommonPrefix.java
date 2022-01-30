package InterviewCollection.ArrayStrings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "floght", "flo"};

        System.out.println("Output : " + longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        int minLegth = Integer.MAX_VALUE;

        for (var str : strs) {
            if (str.length() < minLegth)
                minLegth = str.length();
        }

        boolean breakFlag = true;
        var prefix = strs[0];

        for (int i = 0; i < minLegth; i++) {

            for (var str : strs) {
                if (prefix.charAt(i) != str.charAt(i)) {
                    breakFlag = false;
                    break;
                }
            }
            if (breakFlag)
                sb.append(prefix.charAt(i));
            else {
                break;
            }
        }

        return sb.toString();

    }
}
