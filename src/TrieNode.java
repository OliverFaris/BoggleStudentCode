public class TrieNode {
    // Instance variables
    private boolean isWord;
    private TrieNode[] next;

    // Constructor
    public TrieNode() {
        isWord = false;
        next = new TrieNode[26];
    }

    // Methods
    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean bool) {
        isWord = bool;
    }

    public TrieNode[] getNext() {
        return next;
    }

    public void setNext(int index, TrieNode node) {
        next[index] = node;
    }
}