package PlusOne;

import Tools.ListTools;

import java.util.Arrays;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 1:50 PM
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length - 1]++;

        if (digits[length - 1] != 10) {
            return digits;
        } else {
            int carry = 0;
            for (int i = length - 1; i >= 0; i--) {
                int sum = carry + digits[i];
                carry = sum / 10;
                digits[i] = sum % 10;
            }
            if (carry == 1) {
                int[] result = new int[length + 1];
                Arrays.fill(result, 0);
                result[0] = 1;
                return result;
            } else {
                return digits;
            }

        }
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().plusOne(new int[]{123}));
        ListTools.Print(new Solution().plusOne(new int[]{109}));
        ListTools.Print(new Solution().plusOne(new int[]{999}));

    }
}
