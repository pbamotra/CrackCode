package RotateImage;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 10:19 PM
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int half = 0;
        if (size % 2 == 0) {
            half = size / 2;
        } else {
            half = size / 2 + 1;
        }
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                if (size % 2 != 0 && i == half - 1) continue;
                int i2 = j;
                int j2 = size - i - 1;
                int i3 = j2;
                int j3 = size - i2 - 1;
                int i4 = j3;
                int j4 = size - i3 - 1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i4][j4];
                matrix[i4][j4] = matrix[i3][j3];
                matrix[i3][j3] = matrix[i2][j2];
                matrix[i2][j2] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] m = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        new ListTools().PrintListList(m);
        new Solution().rotate(m);
        new ListTools().PrintListList(m);
    }
}