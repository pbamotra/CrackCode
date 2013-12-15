package ContainerWithMostWater;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/15/13
 * Time: 1:18 AM
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;

    }


    static public void main(String[] args) {

        System.out.println(new Solution().maxArea(new int[]{4, 3, 2, 1}));

    }
}
