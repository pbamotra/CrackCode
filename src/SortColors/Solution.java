package SortColors;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 5:57 PM
 */
public class Solution {
    public void sortColors(int[] A) {
        int l = -1;
        int m = -1;
        int n = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                l++;
                m++;
                n++;
                A[n] = 2;
                A[m] = 1;
                A[l] = 0;
            } else if (A[i] == 1) {
                m++;
                n++;
                A[n] = 2;
                A[m] = 1;
            } else if (A[i] == 2) {
                n++;
                A[n] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 0, 2, 1, 2, 0};
        new Solution().sortColors(A);
        ListTools.Print(A);
    }
}
