package InterviewCollection.CollectionsHard;

import java.util.HashMap;
import java.util.Map;

public class minimumSubstringWindow {

    public static void main(String[] args) {

    }

    /*
        https://www.youtube.com/watch?v=eS6PZLjoaq8
     */
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";


        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        for (var ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int required = mapT.size();       // Number of unique characters in t (3), which need to be present in the desired window.


        int l = 0, r = 0;  // Left and Right pointer

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> mapWindow = new HashMap<Character, Integer>();

        // ans list of the form (length, left, right)
        int[] ans = {-1, 0, 0}; // 3 değeri ayrı ayrı tutmak varken bir arada tutuyoruz. o anki yakaladığımız en kısa window'un uzunluğu ile,başlangıç ve bitiş noktalarını tutuyoruz.

        while (r < s.length()) {

            char ch = s.charAt(r);
            mapWindow.put(ch, mapWindow.getOrDefault(ch, 0));  // Add one character from the right to the window

            // If the frequency of the current character added equals to the desired count in t then increment the formed count by 1.

            if (mapT.containsKey(ch) && mapWindow.get(ch).intValue() == mapT.get(ch).intValue()) { // Bu karakter sayısı sağlanmıştır.
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {  // Bütün karakterler sağlanmıştır.
                ch = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {  // ilk kayıt yada daha küçük bir window length yakalamışsak,onu kaydediyoruz.
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the `Left` pointer is no longer a part of the window.
                mapWindow.put(ch, mapWindow.get(ch) - 1);
                if (mapT.containsKey(ch) && mapWindow.get(ch).intValue() < mapT.get(ch).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
