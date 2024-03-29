package BestTimeToBuyAndSellStock;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 1:01 PM
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                int delta = max - prices[i];
                if (delta > profit) {
                    profit = delta;
                }
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3}));
        System.out.println(new Solution().maxProfit(new int[]{3, 4, 1, 3}));
        System.out.println(new Solution().maxProfit(new int[]{3, 2, 1}));
        System.out.println(new Solution().maxProfit(new int[]{2, 1, 2, 0, 1}));
        System.out.println(new Solution().maxProfit(new int[]{7, 2, 4, 1}));


    }
}
