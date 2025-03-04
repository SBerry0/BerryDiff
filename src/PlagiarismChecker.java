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
        // Storing the lengths of the indices connecting text one to text two with first row/column buffer of 0
        int[][] board = new int[doc1.length()+1][doc2.length()+1];

        for (int i = 1; i < doc1.length()+1; i++) {
            for (int j = 1; j < doc2.length()+1; j++) {
                // If the characters at the diagonal square are equal, add one to it and set it to this index
                if (doc1.charAt(i-1) == doc2.charAt(j-1)) {
                    board[i][j] = board[i-1][j-1] + 1;
                } else {
                    // Otherwise take the larger value of the neighbors for this index
                    board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
                }
            }
        }

        // Finding one of the shared longest subsequence
        String oneString = getSubsequence(doc1, doc2, board);
        System.out.println(oneString);

        // Return the value of the bottom right square
        return board[doc1.length()][doc2.length()];
    }

    private static String getSubsequence(String doc1, String doc2, int[][] board) {
        String oneString = "";
        int i = doc1.length();
        int j = doc2.length();
        while (i > 0 && j > 0) {
            // If chars are the same, add to string and continue to the diagonal square up and to the left
            if (doc1.charAt(i-1) == doc2.charAt(j-1)) {
                oneString += doc1.charAt(i-1);
                i--; j--;
            }
            else {
                // Follow the path of the largest value that Max would lead from
                if (board[i - 1][j] > board[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return oneString;
    }
}
