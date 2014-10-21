package Candy;

import java.util.Arrays;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/13/14
 * Time: 12:00 PM
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        int[] leftCount = new int[ratings.length];
        int[] rightCount = new int[ratings.length];

        Arrays.fill(leftCount, 1);
        Arrays.fill(rightCount, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) leftCount[i + 1] = leftCount[i] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) rightCount[i] = rightCount[i + 1] + 1;
        }
        for (int i = 0; i < ratings.length; i++) {
            count[i] = leftCount[i] > rightCount[i] ? leftCount[i] : rightCount[i];
        }
        return getSum(count);

    }

    public int getSum(int[] count) {
        int sum = 0;
        for (int i : count) {
            sum += i;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 3, 1}));   //4
        System.out.println(new Solution().candy(new int[]{2, 1}));    //3
        System.out.println(new Solution().candy(new int[]{1, 2, 2}));  //4
        System.out.println(new Solution().candy(new int[]{2, 2}));  //2
        System.out.println(new Solution().candy(new int[]{2, 2, 1}));  //4
        System.out.println(new Solution().candy(new int[]{1, 3, 5}));  //6
        System.out.println(new Solution().candy(new int[]{3, 2, 1}));  //6
        System.out.println(new Solution().candy(new int[]{1, 3, 4, 3, 2, 1}));  //13
        System.out.println(new Solution().candy(new int[]{58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89, 54, 26, 54, 54, 99, 64, 71, 76, 63, 81, 82, 60, 64, 29, 51, 87, 87, 72, 12, 16, 20, 21, 54, 43, 41, 83, 77, 41, 61, 72, 82, 15, 50, 36, 69, 49, 53, 92, 77, 16, 73, 12, 28, 37, 41, 79, 25, 80, 3, 37, 48, 23, 10, 55, 19, 51, 38, 96, 92, 99, 68, 75, 14, 18, 63, 35, 19, 68, 28, 49, 36, 53, 61, 64, 91, 2, 43, 68, 34, 46, 57, 82, 22, 67, 89}));
        //208
    }
}
