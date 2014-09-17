package SearchForARange;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/16/14
 * Time: 2:51 PM
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A.length == 1) {
            if (A[0] != target) return new int[]{-1, -1};
        }
        int start = binarySearch(A, target - 0.5, 0, A.length);
        int end = binarySearch(A, target + 0.5, 0, A.length);
        if (start == -1 && end == -1) {
            return new int[]{-1, -1};
        } else if (start == -1 && end != -1) {
            return new int[]{0, end};
        } else if (start == end) {
            return new int[]{-1, -1};
        } else {
            return new int[]{start + 1, end};
        }
    }

    public int binarySearch(int[] A, double n, int start, int end) {
        if (start >= end) return -1;
        if (start + 1 == end && A[start] <= n) {
            return start;
        }
        int mid = (start + end) / 2;
        if (n < A[mid]) return binarySearch(A, n, start, mid);
        else return binarySearch(A, n, mid, end);

    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 5, 5};
        ListTools.Print(new Solution().searchRange(A, 5));
        A = new int[]{7, 7, 8, 8, 10};
        ListTools.Print(new Solution().searchRange(A, 7));
        A = new int[]{7};
        ListTools.Print(new Solution().searchRange(A, 8));
        A = new int[]{8};
        ListTools.Print(new Solution().searchRange(A, 8));
        A = new int[]{2, 2};
        ListTools.Print(new Solution().searchRange(A, 3));
    }
}
