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
                board[i][j] += Math.max(board[i-1][j], board[i][j-1]);
                if (doc1.charAt(i-1) == doc2.charAt(j-1) && i > board[i][j] && j > board[i][j]) {
                    board[i][j] += 1;
                }
            }
        }
        return board[doc1.length()][doc2.length()];
//        return recursive(doc2, doc1, 0, 0, memoizationBoard);
    }

    public static int recursive(String text1, String text2, int idx1, int idx2, int[][] memoizationBoard) {
        if (idx1 >= text1.length() || idx2 >= text2.length()) {
            return 1;
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = idx1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(idx2)) {
                int newLen;
                if (memoizationBoard[i][idx2] != 0) {
                    newLen = memoizationBoard[i][idx2];
                }
                else {
                    newLen = 1 + recursive(text1, text2, i + 1, idx2 + 1, memoizationBoard);
                    memoizationBoard[i][idx2] = newLen;
                }
                maxLen = Math.max(maxLen, newLen);
            }
        }

        return maxLen;
    }
}
