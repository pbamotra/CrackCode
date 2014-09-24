package TrappingRainWater;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/24/14
 * Time: 10:56 AM
 */
public class Solution {
    public int trap(int[] A) {
        if (A.length == 0) return 0;
        int left = 0;
        int right = A.length - 1;
        int height = 0;
        int area = 0;
        int shade = 0;
        while (left <= right) {
            if (Math.min(A[left], A[right]) > height) {
                area += (Math.min(A[left], A[right]) - height) * (right - left + 1);
                height = Math.min(A[left], A[right]);
            }

            if (A[left] < A[right]) {
                shade += A[left];
                left++;
            } else {
                shade += A[right];
                right--;
            }
        }
        return area - shade;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}