package ThreeSumClosest;

import java.util.Arrays;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 4:57 PM
 */
public class Solution {

    int minDelta = Integer.MAX_VALUE;
    int minSum = Integer.MAX_VALUE;

    public int threeSumClosest(int[] num, int target) {
        int length = num.length;
        Arrays.sort(num);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = num[i] + num[j] + num[k];
                    if (Math.abs(sum - target) < minDelta) {
                        minSum = sum;
                        minDelta = Math.abs(sum - target);
                    }
                    if (sum - target > 0) break;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
