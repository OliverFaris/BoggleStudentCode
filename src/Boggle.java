import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    private boolean[][] visited;

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        TST tst = new TST();
        // Fill tst w/ dictionary
        for (String word : dictionary) {
            tst.insert(word,-1);
        }



        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public void dfs(int row, int col, String word, char[][] board) {
        // If out of bounds, return
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;
        // If we have been here before, return
        if (visited[row][col])
            return;
        // If this word is not a valid prefix, return

        word+=board[row][col];
        // Mark this square as visited
        visited[row][col] = true;

        // Recurse up, down, left, right with updated word
        dfs(row +1, col, word, board);
        dfs(row -1, col, word, board);
        dfs(row, col -1, word, board);
        dfs(row, col +1, word, board);

        // Mark this square as not visited
        visited[row][col] = false;
    }
}
