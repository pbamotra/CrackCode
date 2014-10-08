package NQueensII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 1:44 PM
 */
public class Solution {
    int total = 0;

    public int totalNQueens(int n) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], '.');
        }
        visit(result, 0);

        return total;
    }

    public void visit(char[][] board, int count) {
        if (count == board.length) {
            total++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (board[count][j] == '.' && goodPut(count, j, board)) {
                board[count][j] = 'Q';
                visit(board, count + 1);
                board[count][j] = '.';
            }
        }

    }


    public boolean goodPut(int x, int y, char[][] board) {
        int n = board.length;
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == 'Q') return false;
            if (board[x][i] == 'Q') return false;
        }

        int i = x;
        int j = y;
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') return false;
        }
        i = x;
        j = y;
        while (i >= 0 && j < n) {
            if (board[i--][j++] == 'Q') return false;
        }
        i = x;
        j = y;
        while (i < n && j >= 0) {
            if (board[i++][j--] == 'Q') return false;
        }
        i = x;
        j = y;
        while (i < n && j < n) {
            if (board[i++][j++] == 'Q') return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(8));
    }
}
