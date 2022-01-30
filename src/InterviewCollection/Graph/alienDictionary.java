package InterviewCollection.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class alienDictionary {

    public static void main(String[] args) {

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        System.out.println("Output: " + alienOrder(words));

    }

    /*
        https://www.youtube.com/watch?v=tggiFvaxjrY
     */
    private static String alienOrder(String[] words) {

        // Step 0: Create data structures and find all unique letters.
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);  // indegree
            }
        }

        // Step 1: Find all edges.
        for (int i = 1; i < words.length; i++) {

            String word1 = words[i - 1];
            String word2 = words[i];

            // If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j), c2 = word2.charAt(j);
                if (c1 != c2) {  // c1->c2
                    var set = adjList.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        adjList.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Kahn's Algorithm, topological sorting
        Queue<Character> queue = new LinkedList<Character>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) queue.add(c);
        }

        List<Character> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            result.add(c);
            if (!adjList.containsKey(c))
                continue;
            for (char c2 : adjList.get(c)) { // c2: adjacent
                indegree.put(c2, indegree.get(c2) - 1);
                if (indegree.get(c2) == 0)
                    queue.offer(c2);
            }
        }

        if (result.size() != indegree.size()) return ""; // There is cycle. graph is not DAG

        return result.stream().map(c -> c.toString()).collect(Collectors.joining());
    }
}
