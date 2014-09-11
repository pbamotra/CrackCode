package MaximumSubarray;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 4:07 PM
 */
public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int f = 0;
        for (int i = 0; i < A.length; i++) {
            f = Math.max(A[i], f + A[i]);
            if (f > max) {
                max = f;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.print(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
