package BestTimeToBuyAndSellStockII;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 1:31 PM
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
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
