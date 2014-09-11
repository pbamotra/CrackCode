package UniquePaths;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 9:52 PM
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = A[i - 1][j] + A[i][j - 1];
                }
            }
        }
        return A[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3,3));
    }
}