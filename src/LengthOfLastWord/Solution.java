package LengthOfLastWord;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 2:57 PM
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.trim().length() == 0) return 0;
        s = s.trim();
        int pos = s.lastIndexOf(" ");
        if (pos == -1)
            return s.length();
        else
            return s.length() - pos - 1;
    }

    public static void main(String[] args) {
        System.out.print(new Solution().lengthOfLastWord("Hello World"));
        System.out.print(new Solution().lengthOfLastWord("a   "));

    }
}
