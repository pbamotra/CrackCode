package SurroundedRegions;

import Tools.ListTools;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/7/14
 * Time: 11:06 AM
 */
public class Solution {
    int xMax;
    int yMax;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;


    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        xMax = m;
        yMax = n;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                findO(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                findO(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                findO(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                findO(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void findO(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] start = new int[]{x, y};
        visited[x][y] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            board[point[0]][point[1]] = 'A';
            for (int i = 0; i < 4; i++) {
                int tx = point[0] + direction[i][0];
                int ty = point[1] + direction[i][1];
                if (tx >= 0 && tx < xMax
                        && ty >= 0 && ty < yMax
                        && board[tx][ty] == 'O'
                        && !visited[tx][ty]) {
                    queue.add(new int[]{tx, ty});
                    visited[tx][ty] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] A = new char[][]
                {"XXXX".toCharArray()
                        , "XXXX".toCharArray()
                        , "XOOX".toCharArray()
                        , "OOXX".toCharArray()};
        new Solution().solve(A);
        ListTools.Print(A);
    }
}
