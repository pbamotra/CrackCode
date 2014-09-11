package SearchInsertPosition;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 10:38 AM
 * <p/>
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return target > A[0] ? 1 : 0;
        int i = 0;
        while (true) {
            if (i == A.length - 1) return A.length;
            if (A[i] < target) i++;
            if (A[i] == target) return i;
            if (A[i] > target) return i;
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution().searchInsert(new int[]{1}, 1));
    }
}