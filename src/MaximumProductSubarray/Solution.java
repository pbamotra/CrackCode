package MaximumProductSubarray;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/14/14
 * Time: 8:53 PM
 */
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null) return 0;
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];

        int length = A.length;
        int[] maxSum = new int[length];
        int[] minSum = new int[length];
        maxSum[0] = A[0];
        minSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            maxSum[i] = Math.max(Math.max(maxSum[i - 1] * A[i], minSum[i - 1] * A[i]), A[i]);
            minSum[i] = Math.min(Math.min(minSum[i - 1] * A[i], maxSum[i - 1] * A[i]), A[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i : maxSum) max = i > max ? i : max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
