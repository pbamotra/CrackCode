package PalindromeNumber;

import java.awt.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 3:26 PM
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int size = 0;
        int t = x;
        while (t > 0) {
            t = t / 10;
            size++;
        }
        int half = 0;
        t = x;
        for (int i = 0; i < size / 2; i++) {
            half = 10 * half + t % 10;
            t = t / 10;
        }

        if (size % 2 == 0) {
            return half == t ? true : false;
        } else {
            t = t / 10;
            return half == t ? true : false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(12321));
        System.out.println(new Solution().isPalindrome(1221));
        System.out.println(new Solution().isPalindrome(1321));

    }
}
