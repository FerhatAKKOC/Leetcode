package InterviewCollection.CollectionsHard;

import javax.swing.text.Style;
import java.util.*;

public class wordLadder {

    /*
        https://www.youtube.com/watch?v=ZVJ3asMoZ18
        Brute Force Solution
     */
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // check whether endWord word does exist in list

        Set<String> set = new HashSet<>();

        boolean checkEndWords = false;
        for (var str : wordList) {
            set.add(str);
            if (str.equals(endWord))
                checkEndWords = true;
        }
        if (!checkEndWords)  // not found 'endword' in list
            return 0;


        Deque<String> deque = new ArrayDeque<>();
        deque.offerLast(wordList.get(0));

        int depth = 0;
        while (!deque.isEmpty()) {  // BFS solution

            depth++;
            int qsize = deque.size();

            while (qsize-- > 0) {
                var curr = deque.pollFirst();

                for (int i = 0; i < curr.length(); i++) {

                    var temp = new StringBuilder(curr);

                    for (char c = 'a'; c <= 'z'; c++) {  // Bütün karakterlerin her bir kombinasyonunu deniyoruz
                        temp.setCharAt(i, c);

                        if (temp.equals(curr)) continue;// aynı kelimeler denk gelirse almıyoruz.
                        if (temp.equals(endWord)) // aradığımız kelimeyi bulursak dönüyoruz
                            return depth + 1;

                        if (set.contains(temp.toString())) {
                            deque.offerLast(temp.toString());
                            set.remove(temp.toString());
                        }
                    }
                }
            }
        }
        return depth + 1;
    }

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("Output: " + ladderLength(beginWord, endWord, wordList));
    }
}
