package InterviewCollection.Strings;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    // Aynı karakterleri içerecek fakat farlı bir sırada olabilir.
    public static void main(String[] args) {
        String s = "anagram", t = "margank"; //        Output: true
        //String s = "rat", t = "car"; //        Output: false

        System.out.println("Output : " + isAnagram(s, t));

    }


    // checking input params: null, empty, length
    // Map<> HashMap
    // for loop
    // sort and compare Arrays.equals

    static boolean isAnagram(String s, String t) {

        if (s == null || t == null) return false;
        if (s.isEmpty() || t.isEmpty()) return false;
        if (s.length() != t.length()) return false;

        var t1 = t.toCharArray();
        var s1 = s.toCharArray();

        Arrays.sort(t1);
        Arrays.sort(s1);

        return Arrays.equals(t1, s1);
    }

    static boolean isAnagram1(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> smap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (char c : smap.keySet()) {
            if (smap.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
}
