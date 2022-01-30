package InterviewCollection.Amazon;

import java.util.*;

public class wordLadder_I {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit", endWord = "cog";

        System.out.println("Output: " + ladderLength(beginWord, endWord, wordList));
    }

    /*
        Word Letter I
        BFS solution
     */
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // endWord 'ün 'wordList' içerisinde olup olmadığına bakıyoruz.
        var res = wordList.stream().filter(s -> s.equals(endWord)).findFirst();
        if (res.isEmpty()) return 0;

        int L = beginWord.length();

        Map<String, List<String>> patternDict = new HashMap<>(); // Generic pattern'ler ve ona denk gelen word'leri bir arada tutuyoruz. hot: *ot  h*t  ho*
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, L); // *ot  h*t  ho*  *ot  d*t  do*  *og  d*g  do*  *ot  l*t  lo*  *og  l*g  lo*  *og  c*g  co*
                patternDict.putIfAbsent(pattern, new ArrayList<>());
                patternDict.get(pattern).add(word);
            }
        });

        // Queue for BFS
        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();  // word, level
        queue.add(new AbstractMap.SimpleEntry<>(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {

            var pair = queue.poll();
            var word = pair.getKey();
            var level = pair.getValue();

            for (int i = 0; i < L; i++) { // get pattern of current Node
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : patternDict.getOrDefault(pattern, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new AbstractMap.SimpleEntry<>(adjacentWord, level + 1));
                    }
                }
            }
        }
/*
    Her 'word'ü tek tek queue dan çıkartıyoruz.
    Çıkarttığımız word'ün tek tek patternlerine bakıyoruz.
    Bir pattern karşısında eğer bir word listesi varsa, o listedeki kelimelerin visited olup olmadığına da bakıyoruz.
    Visited olmamışsa, word'ün level'ını arttırıp tekrarda queue'ya pushluyoruz.
    Daha sonra diğer pattern'leride kontrol ediyoruz.
 */

        return 0;
    }
}
/*
For eg. While doing BFS if we have to find the adjacent nodes for Dug we can first find all the generic states for Dug.

Dug => *ug
Dug => D*g
Dug => Du*

hot: *ot  h*t  ho*
dot: *ot  d*t  do*
dog: *og  d*g  do*
lot: *ot  l*t  lo*
log: *og  l*g  lo*
cog: *og  c*g  co*

  Algorithm
    Do the pre-processing on the given wordList and find all the possible generic/intermediate states. Save these intermediate states in a dictionary with key as the intermediate word and value as the list of words which have the same intermediate word.
    Push a tuple containing the beginWord and 1 in a queue. The 1 represents the level number of a node. We have to return the level of the endNode as that would represent the shortest sequence/distance from the beginWord.
    To prevent cycles, use a visited dictionary.
    While the queue has elements, get the front element of the queue. Let's call this word as current_word.
    Find all the generic transformations of the current_word and find out if any of these transformations is also a transformation of other words in the word list. This is achieved by checking the all_combo_dict.
    The list of words we get from all_combo_dict are all the words which have a common intermediate state with the current_word. These new set of words will be the adjacent nodes/words to current_word and hence added to the queue.
    Hence, for each word in this list of intermediate words, append (word, level + 1) into the queue where level is the level for the current_word.
    Eventually if you reach the desired word, its level would represent the shortest transformation sequence length.

 */
