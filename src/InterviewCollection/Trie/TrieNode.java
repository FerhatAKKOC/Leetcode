package InterviewCollection.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private char data;
    private int we;                                 // eğer 1 ise, leaf node olur. Root node'da her zaman '0' dır.
    private TrieNode[] children;

    public TrieNode(char data) {
        this.data = data;
        we = 0;
        children = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void put(char ch) {
        children[ch - 'a'] = new TrieNode(ch);
    }

    public TrieNode get(char ch) {
        return  children[ch - 'a'];
    }

    public void setEnd() {
        we = 1;
    }

    public boolean isEnd() {
        return we == 1;
    }
}
