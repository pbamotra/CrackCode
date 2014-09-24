package SingleNumberII;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/24/14
 * Time: 9:54 AM
 */
public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos = twos | ones & A[i];
            ones = ones ^ A[i];
            threes = ones & twos;
            ones = ones & ~threes;
            twos = twos & ~threes;
        }

        return ones;
    }

    public int singleNumber2(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        for (int i = 0; i < A.length; i++) {
            twos = twos | ones & A[i];
            ones ^= A[i];
            threes = threes | ones & twos;
            ones = ones & ~threes;
            twos = twos & ~threes;
            fours = fours | ones & threes;
            ones = ones & ~fours;
        }

        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1, 2, 2, 2}));
        System.out.println(new Solution().singleNumber2(new int[]{1, 2, 2, 2, 2}));

    }
}
