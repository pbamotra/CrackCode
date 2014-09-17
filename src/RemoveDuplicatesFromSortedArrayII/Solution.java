package RemoveDuplicatesFromSortedArrayII;

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
        if (A.length == 2) return 2;
        int length = 2;
        int i = 2;
        while (i < A.length) {
            if (A[i] != A[length - 2]) {
                A[length++] = A[i];
            }
            i++;
        }
        return length;
    }

    static public void main(String[] args) {
        int[] A = new int[]{1, 1, 1, 2, 3, 3, 3};
        System.out.println(new Solution().removeDuplicates(A));
        new ListTools().Print(A);

        A = new int[]{1, 1, 1, 2};
        System.out.println(new Solution().removeDuplicates(A));
        new ListTools().Print(A);

        A = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new Solution().removeDuplicates(A));
        new ListTools().Print(A);
    }
}