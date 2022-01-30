package InterviewCollection.CollectionsEasy;

public class validPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println("Output: " + isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {

        if (s == null || s.length() == 1)
            return false;

        StringBuilder sb = new StringBuilder();

        for (var c : s.toCharArray()) {
            if (Character.isDigit(c)) continue;
            if (Character.isWhitespace(c)) continue;
            if (Character.isLetter(c)) sb.append(c);
        }
        String str = sb.toString().toLowerCase();

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
