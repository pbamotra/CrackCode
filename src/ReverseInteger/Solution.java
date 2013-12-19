package ReverseInteger;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 8:00 PM
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isNega = false;
        int result = 0;
        if (x < 0) {
            isNega = true;
            x = -x;
        }
        int len = String.valueOf(x).length();
        int i = 0;
        while (x != 0) {
            int a = x % 10;
            result += a * (int) Math.pow(10, len - i - 1);
            x = x / 10;
            i++;
        }

        if (isNega) {
            result = -result;
        }
        return result;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().reverse(-3210));
    }
}