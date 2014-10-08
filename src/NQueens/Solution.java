package NQueens;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/7/14
 * Time: 5:56 PM
 */
public class Solution {

    List<String[]> results = new ArrayList<String[]>();

    public List<String[]> solveNQueens(int n) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], '.');
        }
        visit(result, 0);

        return results;
    }

    public void visit(char[][] board, int count) {
        if (count == board.length) {
            ListTools.Print(board);
            System.out.println();
            add(board);
        }
        for (int i = 0; i < board.length; i++) {
            if (i < count) continue;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.' && goodPut(i, j, board)) {
                    board[i][j] = 'Q';
                    visit(board, count + 1);
                    board[i][j] = '.';
                }
            }
        }
    }

    public void add(char[][] board) {
        int n = board.length;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = board[i].toString();
        }
        results.add(result);
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
        new Solution().solveNQueens(4);
    }
}
