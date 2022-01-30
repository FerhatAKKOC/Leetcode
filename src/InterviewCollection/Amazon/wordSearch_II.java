package InterviewCollection.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wordSearch_II {
    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        String[] words = {"oath", "pea", "eat", "rain"};

        var output = findWords(board, words);
    }

    private static List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    /*
        Önce matrix'de 4 direction'da da harfleri tarayıp, Trie daki o andaki node'un children'larında olup olmadığına bakıyoruz.
        Yani önce matrix'de ilerleme yapıyoruz. Sonra Trie'da kontrol yapıyoruz, daha sonra trie node'u ilerliyor.
        Aynı karakterleri tekrar tekrar taramamak için ise bulduğumuz word'ü siliyoruz.

        Matrix'de word karakterleri üzerinde ilerledikçe '#' koyuyoruz ki 4 directions tararken tekrar geriye dönmeyelim.
     */
    private static void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {

        char ch = board[i][j];

        if (ch == '#' || node.children[ch - 'a'] == null)  // aynı cell'i tekrar kullanamayız. Bu karakter Trie'da yoksa pass geçeriz.
            return;

        node = node.children[ch - 'a']; //

        if (node.word != null) {   // found one
            res.add(node.word);    //  Remove StringBuilder completely by storing word instead of boolean in TrieNode.
            node.word = null;      // de-duplicate, siliyoruz
        }

        board[i][j] = '#';  // Remove visited[m][n] completely by modifying board[i][j] = '#' directly.
        if (i > 0) dfs(board, i - 1, j, node, res);
        if (j > 0) dfs(board, i, j - 1, node, res);
        if (i < board.length - 1) dfs(board, i + 1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, res);
        board[i][j] = ch;
    }

    //****************************************
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];
        String word;

    }

    private static TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String w : words) {

            TrieNode p = root;

            for (char c : w.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.word = w; // son noda bu koyuluyor.
        }

        return root;
    }

}
