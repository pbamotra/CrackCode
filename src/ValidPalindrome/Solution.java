package ValidPalindrome;

import java.util.regex.Pattern;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 7:52 PM
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]", "");
        int i = 0;
        int j = s.length() - 1;
        while (j >= i) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
