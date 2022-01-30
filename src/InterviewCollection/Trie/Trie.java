package InterviewCollection.Trie;

public class Trie {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("aba");
        trie.insert("abacd");

        System.out.println(trie.search("abacd"));

    }


    TrieNode root;

    public Trie() {
        root = new TrieNode('/');
    }

    public void insert(String word) {

        TrieNode node = root;

        for (var ch : word.toCharArray()) {
            if (!node.containsKey(ch))
                node.put(ch, new TrieNode(ch));
            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {

        TrieNode node = root;

        for (var ch : word.toCharArray()) {
            if (!node.containsKey(ch))
                return false;

            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for (var ch : prefix.toCharArray()) {
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return true;    // node.isEnd(); kontrolü prefix'de yapılmıyor.
    }

    public TrieNode searchPrefix(String prefix) {

        TrieNode node = root;

        for (var ch : prefix.toCharArray()) {
            if (!node.containsKey(ch))
                return null;
            node = node.get(ch);
        }
        return node;
    }
}
