package ValidSudoku;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/24/14
 * Time: 8:40 PM
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!goodPut(board, i, j, board[i][j]))
                    return false;
            }
        }
        return true;
    }

    public boolean goodPut(char[][] board, int i, int j, char k) {
        for (int z = 0; z < 9; z++) {
            if (board[i][z] == k && z != j) return false;
            if (board[z][j] == k && z != i) return false;
        }
        int row = (i / 3) * 3;
        int column = (j / 3) * 3;
        for (int x = row; x < row + 3; x++) {
            for (int y = column; y < column + 3; y++) {
                if (board[x][y] == k && !(x == i && y == j)) return false;
            }
        }

        return true;
    }
}
