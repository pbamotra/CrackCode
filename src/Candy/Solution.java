package Candy;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/13/14
 * Time: 12:00 PM
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                count[i + 1] = count[i] + 1;
            } else if (ratings[i + 1] <= ratings[i] && count[i] != 1) {
                count[i + 1] = 1;
            } else if (ratings[i + 1] == ratings[i] && count[i] == 1) {
                count[i + 1] = 1;
            } else if (ratings[i + 1] < ratings[i] && count[i] == 1) {
                count[i + 1] = 1;
                for (int j = 0; j <= i; j++) {
                    count[j]++;
                }
            }
        }

        int sum = 0;
        for (int i : count) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 3, 1}));
        System.out.println(new Solution().candy(new int[]{2, 1}));
        System.out.println(new Solution().candy(new int[]{1, 2, 2}));
        System.out.println(new Solution().candy(new int[]{2, 2}));


    }
}
