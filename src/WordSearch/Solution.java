package WordSearch;

import java.util.Stack;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/7/14
 * Time: 4:45 PM
 */
public class Solution {
    int xMax;
    int yMax;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        if (n == 0) return false;
        xMax = m;
        yMax = n;
        visited = new boolean[m][n];
        if (word == null || word.length() == 0) return false;
        char start = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (start == board[i][j] && visit(i, j, board, word)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }

        return false;
    }

    public boolean visit(int x, int y, char[][] board, String word) {
        if (board[x][y] != word.charAt(0)) return false;
        if (word.length() == 1 && board[x][y] == word.charAt(0)) {
            return true;
        }
        visited[x][y] = true;
        boolean[] result = new boolean[4];
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (newX >= 0 && newX < xMax && newY >= 0 && newY < yMax && !visited[newX][newY]) {
                result[i] = visit(newX, newY, board, word.substring(1));
                visited[newX][newY] = false;
                if (result[i] == true) return true;
            }
        }

        boolean finalResult = false;
        for (boolean b : result) {
            finalResult = finalResult || b;
        }
        return finalResult;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().exist(
//                new char[][]{"ABCE".toCharArray()
//                        , "SFCS".toCharArray()
//                        , "ADEE".toCharArray()}
//                , "ABCCED"));
//        System.out.println(new Solution().exist(
//                new char[][]{"ABCE".toCharArray()
//                        , "SFCS".toCharArray()
//                        , "ADEE".toCharArray()}
//                , "SEE"));
//        System.out.println(new Solution().exist(
//                new char[][]{"ABCE".toCharArray()
//                        , "SFCS".toCharArray()
//                        , "ADEE".toCharArray()}
//                , "ABCB"));
        System.out.println(new Solution().exist(
                new char[][]{"CAA".toCharArray()
                        , "AAA".toCharArray()
                        , "BCD".toCharArray()}
                , "AAB"));
    }
}
