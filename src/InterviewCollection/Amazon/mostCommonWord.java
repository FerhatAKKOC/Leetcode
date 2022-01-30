package InterviewCollection.Amazon;

import java.util.*;
import java.util.stream.Collectors;

public class mostCommonWord {

    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println("Output: " + mostCommonWord(paragraph, banned));
    }

    private static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> setBanned = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String, Integer> map = new HashMap<>();

        var cleaned = paragraph
                        .replaceAll("[^a-zA-Z0-9 ]", " ")
                        .toLowerCase()
                        .split(" ");

        for (var str : cleaned) {
            if (!setBanned.contains(str))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // map max value
        return Collections.max(map.entrySet(), Map.Entry.comparingByKey()).getKey();
    }

}
