import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {
        Trie trie = new Trie();
        ArrayList<String> words = new ArrayList<>();
        boolean[][] visited = new boolean [board.length][board[0].length];

        // Fill tst w/ dictionary
        for (String word : dictionary) {
            trie.insert(word);
        }

        // Dfs through each square
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i,j,"",board, visited, words, trie);
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[words.size()];
        words.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void dfs(int row, int col, String word, char[][] board, boolean[][] visited, ArrayList<String> words, Trie trie) {
        // If out of bounds, return
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;
        // If we have been here before, return
        if (visited[row][col])
            return;

        word+=board[row][col];
        // If this word is not a valid prefix, return
        boolean prefix = trie.isValidPrefix(word);
        if (!prefix) {
            return;
        }
        else if (trie.lookup(word) != null){
            words.add(word);
            trie.lookup(word).setWord(false);
        }

        // Mark this square as visited
        visited[row][col] = true;

        // Recurse up, down, left, right with updated word
        dfs(row +1, col, word, board, visited, words, trie);
        dfs(row -1, col, word, board, visited, words, trie);
        dfs(row, col -1, word, board, visited, words, trie);
        dfs(row, col +1, word, board, visited, words, trie);

        // Mark this square as not visited
        visited[row][col] = false;
    }
}
