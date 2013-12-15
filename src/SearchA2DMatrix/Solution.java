/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/15/13
 * Time: 3:07 AM
 */

    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            boolean result = false;
            int max = matrix.length * matrix[0].length;
            int i = 0;
            int j = max - 1;
            if (0 == j) {
                if (matrix[0][0] == target) {
                    return true;
                } else {
                    return false;
                }
            }
            while (i <= j) {
                int mid = getValue((j + i) / 2, matrix);
                if (mid == target) return true;
                if (i == j) return false;
                else if (mid < target) {
                    i = (j + i) / 2 + 1;
                } else if (mid > target) {
                    j = (j + i) / 2;
                }
            }

            return result;
        }

        public int getValue(int i, int[][] matrix) {
            int len = matrix[0].length;
            int row = i / len;
            int col = i % len;
            return matrix[row][col];
        }

    }

