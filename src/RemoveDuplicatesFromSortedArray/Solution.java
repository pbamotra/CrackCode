package RemoveDuplicatesFromSortedArray;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 8:47 PM
 * Given input array A = [1,1,2],
 * <p/>
 * Your function should return length = 2, and A is now [1,2].
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) return 0;
        if (A.length == 0) return 0;
        if (A.length == 1) return 1;

        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                count++;
            } else {
                A[i - count + 1] = A[i + 1];

            }
        }

        return A.length - count;
    }

    static public void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 3};
        System.out.println(new Solution().removeDuplicates(A));
        new ListTools().Print(A);
    }
}