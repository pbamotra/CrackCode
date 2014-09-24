package SudokuSolver;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/17/14
 * Time: 10:11 AM
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        char[][] result = new char[9][9];
        put(board, 0, 0, 1, result);
        board = result.clone();
    }

    public void put(char[][] board, int i, int j, int k, char[][] result) {
        if (isFull(board)) {
            result = board.clone();
            return;
        }
        if (i > 8 || j > 8 || k > 9) return;

        if (board[i][j] == '.' && goodPut(board, i, j, k)) {
            board[i][j] = (char) (k + '0');
            if (j < 8)
                put(board, i, j + 1, 1, result);
            else if (j == 8)
                put(board, i + 1, 0, 1, result);
        } else if (board[i][j] == '.' && !goodPut(board, i, j, k)) {
            if (k < 9)
                put(board, i, j, k + 1, result);
            else if (k == 9)
                return;
        } else {
            if (j < 8)
                put(board, i, j + 1, 1, result);
            else if (j == 8)
                put(board, i + 1, 0, 1, result);
        }
    }

    public boolean isFull(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean goodPut(char[][] board, int i, int j, int k) {
        for (int z = 0; z < 9; z++) {
            if (board[i][z] == (char) (k + '0')) return false;
            if (board[z][j] == (char) (k + '0')) return false;
        }
        int row = i / 3;
        int column = j / 3;
        for (int x = row; x < row + 3; x++) {
            for (int y = column; y < column + 3; y++) {
                if (board[x][y] == (char) (k + '0')) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] A = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        ListTools.Print(A);
        System.out.println();
        new Solution().solveSudoku(A);
        ListTools.Print(A);
    }
}
