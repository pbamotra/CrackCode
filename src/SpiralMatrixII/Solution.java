package SpiralMatrixII;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/1/14
 * Time: 4:42 PM
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int a = 0;// row start index
        int b = n - 1; // row end index
        int c = 0; //column start index
        int d = n - 1;//column end index
        while (b >= a && c <= d) {
            for (int i = c; i <= d; i++) {
                result[a][i] = count++;
            }
            a++;
            for (int i = a; i <= b; i++) {
                result[i][d] = count++;
            }
            d--;
            for (int i = d; i >= c; i--) {
                result[b][i] = count++;
            }
            b--;
            for (int i = b; i >= a; i--) {
                result[i][c] = count++;
            }
            c++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().generateMatrix(10));
    }


}
