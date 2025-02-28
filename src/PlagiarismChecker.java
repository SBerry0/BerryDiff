/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Sohum Berry
 */
public class PlagiarismChecker {
    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    public static int longestSharedSubstring(String doc1, String doc2) {
        // Storing the lengths of the indices connecting text one to text two
        int[][] board = new int[doc1.length()+1][doc2.length()+1];
        for (int i = 1; i < doc1.length()+1; i++) {
            for (int j = 1; j < doc2.length()+1; j++) {
                if (doc1.charAt(i-1) == doc2.charAt(j-1) && i >= board[i][j] && j >= board[i][j]) {
                    board[i][j] = board[i-1][j-1] + 1;
                } else {
                    board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
                }
            }
        }

        String oneString = "";

        int i = doc1.length();
        int j = doc2.length();
        while (i != 0 && j != 0) {

        }

        return board[doc1.length()][doc2.length()];
    }
}
