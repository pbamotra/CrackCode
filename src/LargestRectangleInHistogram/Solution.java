package LargestRectangleInHistogram;

import java.util.Stack;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/27/14
 * Time: 9:02 PM
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()) {
                if (height[stack.peek()] > height[i]) {
                    int top = stack.pop();
                    max = Math.max(max, height[top] * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
                } else break;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            max = Math.max(max, height[top] * (height.length - 1 - (stack.isEmpty() ? -1 : stack.peek())));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
