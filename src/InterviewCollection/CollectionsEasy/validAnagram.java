package InterviewCollection.CollectionsEasy;

public class validAnagram {
    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";

        System.out.println("Output: " + isAnagram(s, t));

    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;

        for (int i : alphabet)
            if (i != 0)
                return false;

        return true;
    }
}
