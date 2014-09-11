package RomanToInteger;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 2:44 PM
 */
public class Solution {
    public int romanToInt(String s) {
        String[] tokens = {"CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I"};
        int[] weights =   {900,  400,  90,  40,     9,     4,   1000,  500, 100, 50, 10, 5, 1};

        int result = 0;
        while (s.length() > 0) {
            for (int i = 0; i < tokens.length; i++) {
                if (s.startsWith(tokens[i])) {
                    result += weights[i];
                    s = s.substring(tokens[i].length());
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt(""));
    }
}
