package InterviewCollection.Amazon;

import java.util.*;

public class partitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        var out = partitionLabels(s);
        out.forEach(System.out::println);
    }

    /*
        Partition Labels
        https://www.youtube.com/watch?v=kS4P0vXbGmc
     */
    private static List<Integer> partitionLabels(String s) {

        Map<Character, Integer> endIndex = new HashMap<>();  // Bir karakterin en son hangi indexte görüldüğünü tutar.
        for (int i = 0; i < s.length(); i++) {
            endIndex.put(s.charAt(i), i);
        }

        List<Integer> list = new ArrayList<>();

        int partitionStart = 0;
        int partitionEnd = 0;
        for (int i = 0; i < s.length(); i++) {

            partitionEnd = Math.max(partitionEnd, endIndex.get(s.charAt(i)));

            if (i == partitionEnd) {
                list.add(partitionEnd - partitionStart + 1);
                partitionStart = i + 1;
            }
        }

        return list;
    }
}
