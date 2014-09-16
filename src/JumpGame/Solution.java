package JumpGame;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 11:05 PM
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p/>
 * A = [3,2,1,0,4], return false.
 */
public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 1) return true;
        int reach = 0;
        for (int i = 0; i < A.length && i <= reach; i++) {
            if (i + A[i] > reach) reach = i + A[i];
            if (reach >= A.length - 1) return true;
        }

        return reach >= A.length-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Solution().canJump(new int[]{2, 0}));

    }
}
