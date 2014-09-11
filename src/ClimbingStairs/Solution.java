package ClimbingStairs;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 9:59 PM
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int one = 1;
        int two = 2;
        int three = one + two;
        for (int i = 0; i < n - 3; i++) {
            int four = two + three;
            two = three;
            three = four;
        }
        return three;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }
}
