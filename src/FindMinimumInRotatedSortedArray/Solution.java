package FindMinimumInRotatedSortedArray;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/17/14
 * Time: 11:20 AM
 */
public class Solution {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (num[mid] > num[end]) start = mid + 1;
            else end = mid;
        }

        return num[start];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{4, 5, 6,  0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{ 0, 1, 2}));

    }
}
