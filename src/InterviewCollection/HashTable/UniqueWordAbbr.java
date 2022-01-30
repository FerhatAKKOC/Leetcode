package InterviewCollection.HashTable;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordAbbr {

    public static void main(String[] args) {
        System.out.println("Output : " + isUnique("cart"));
    }

    private static boolean isUnique(String str) {

        String[] list = {"deer", "door", "cake", "card"};

        Set<String> set = new HashSet<>();

        for (var l : list)
            set.add(convertAbbreviation(l));

        if (set.contains(convertAbbreviation(str)))
            return false;

        return true;
    }

    /*
        a) it                      --> it    (no abbreviation)
        b) d|o|g                   --> d1g
        c) i|nternationalizatio|n  --> i18n
        d) l|ocalizatio|n          --> l10n
     */
    private static String convertAbbreviation(String str) {

        if (str.length() <= 2)
            return str;

        str.trim();

        var res = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(res[0]).append(res.length - 2).append(res[res.length - 1]);

        return sb.toString();
    }
}
