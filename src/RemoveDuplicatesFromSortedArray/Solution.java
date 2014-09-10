package RemoveDuplicatesFromSortedArray;

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

        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] > 0) {
                len++;
            }
        }

        for (int i = 1; i < len; i++) {
            if (A[i] <= A[i - 1]) {

            }
        }
        return len;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 2, 2, 2}));
    }
}