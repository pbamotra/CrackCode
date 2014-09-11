package SingleNumber;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 5:25 PM
 */
public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i : A) {
            result = result ^ i;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1, 2, 2, 3, 1}));
    }
}
