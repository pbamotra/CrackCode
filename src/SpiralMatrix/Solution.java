package SpiralMatrix;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/1/14
 * Time: 5:44 PM
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return new ArrayList<Integer>();
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        int a = 0;// row start index
        int b = m - 1; // row end index
        int c = 0; //column start index
        int d = n - 1;//column end index
        while (b >= a && c <= d) {
            for (int i = c; i <= d && b >= a && c <= d; i++) {
                result.add(matrix[a][i]);
            }
            a++;
            for (int i = a; i <= b && b >= a && c <= d; i++) {
                result.add(matrix[i][d]);
            }
            d--;
            for (int i = d; i >= c && b >= a && c <= d; i--) {
                result.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >= a && b >= a && c <= d; i--) {
                result.add(matrix[i][c]);
            }
            c++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListTools.PrintIntegerList(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        ListTools.PrintIntegerList(new Solution().spiralOrder(new int[][]{{2, 3}}));

    }
}