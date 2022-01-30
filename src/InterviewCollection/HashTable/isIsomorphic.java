package InterviewCollection.HashTable;

import java.util.HashMap;

public class isIsomorphic {


    public static void main(String[] args) {
        String s = "fee";
        String t = "egg";
//        String s = "paper";
//        String t = "title";

        System.out.println("Output : " + isIsomorphic(s, t));

    }

    public static boolean isIsomorphic2(String s, String t) {

        if (s.isEmpty() || t.isEmpty())
            return false;
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(i)) {
                if (map.get(map.containsKey(i)) != t.charAt(i))
                    return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }


        return true;

    }


    public static boolean isIsomorphic(String s, String t) {

        if (s.isEmpty() || t.isEmpty())
            return false;
        if (s.length() != t.length())
            return false;


        var s_arr = s.toCharArray();
        var t_arr = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            var s_ch = s_arr[i];
            var s_ch_count = (int) s.chars().filter(c -> c == s_ch).count();

            var t_ch = t_arr[i];
            var t_ch_count = (int) t.chars().filter(c -> c == t_ch).count();

            if (s_ch_count != t_ch_count)
                return false;
        }

        return true;

    }

}
