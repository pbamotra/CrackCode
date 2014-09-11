package IntegerToRoman;


/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/15/13
 * Time: 1:15 PM
 */
public class Solution {
    public String intToRoman(int num) {
        int[] weights = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] tokens = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < weights.length; i++) {
                int count = num / weights[i];
                num = num % weights[i];
                for (int j = 0; j < count; j++) {
                    sb.append(tokens[i]);
                }

            }
        }

        return sb.toString();

    }

    static public void main(String[] args) {
        System.out.println(new Solution().intToRoman(109));
    }
}
