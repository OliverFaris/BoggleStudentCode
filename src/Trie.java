public class Trie {
    // Instance variables
    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Methods
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (node.getNext()[index] != null)
                node = node.getNext()[index];
            else {
                TrieNode newNode = new TrieNode();
                node.setNext(index, newNode);
                node = newNode;
            }
        }
        node.setWord(true);
    }

    public TrieNode lookup(String word) {
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.getNext()[index] != null)
                node = node.getNext()[index];
            else
                break;

            if (i == word.length() -1 && node.isWord())
                return node;
        }
        // Not a word
        return null;
    }

    public boolean isValidPrefix(String word) {
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.getNext()[index] != null)
                node = node.getNext()[index];
            else
                break;

            if (i == word.length() -1)
                return true;
        }
        // Not a word
        return false;
    }
}