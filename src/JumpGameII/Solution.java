package JumpGameII;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/20/14
 * Time: 11:06 PM
 */
public class Solution {
    public int jump(int[] A) {
        int maxReach = A[0];
        int edge = 0;
        int minstep = 0;

        for(int i = 1; i < A.length; i++) {
            if (i > edge) {
                minstep += 1;
                edge = maxReach;
                if(edge > A.length - 1)
                    return minstep;
            }
            maxReach = Math.max(maxReach, A[i] + i);
        }

        return minstep;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump(new int[]{5, 3, 1, 1, 4}));

    }
}
