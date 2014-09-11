package UniquePathsII;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 9:52 PM
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    A[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    A[i][j] = 1;
                } else if (i == 0) {
                    A[i][j] = (1 - obstacleGrid[i][j - 1]) * A[i][j - 1];
                } else if (j == 0) {
                    A[i][j] = (1 - obstacleGrid[i - 1][j]) * A[i - 1][j];
                } else {
                    A[i][j] = (1 - obstacleGrid[i - 1][j]) * A[i - 1][j]
                            + (1 - obstacleGrid[i][j - 1]) * A[i][j - 1];
                }
            }
        }
        return A[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{1, 0}}));

    }
}