package ReverseWordsInAString;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 1:51 PM
 * <p/>
 * Given an input string, reverse the string word by word.
 * <p/>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();// kill the white space
        s = " " + s;
        StringBuilder stringBuilder = new StringBuilder();
        int p = s.length() - 2;
        int q = s.length() - 1;

        for (; p >= 0; p--) {
            if (s.charAt(p) != ' ' && s.charAt(p + 1) == ' ') {
                q = p;
            } else if (s.charAt(p) == ' ' && s.charAt(p + 1) != ' ') {
                stringBuilder.append(s.substring(p + 1, q + 1));
                stringBuilder.append(" ");
            }

        }


        String result = stringBuilder.toString().trim();
        return result;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("   the sky is blue"));
        System.out.println(new Solution().reverseWords("the    sky is blue"));
        System.out.println(new Solution().reverseWords("  the   sky   is   blue  "));
        System.out.println("blue is sky the");

        System.out.println(new Solution().reverseWords("a"));
        System.out.println("a");

        System.out.println(new Solution().reverseWords("   a   b "));
        System.out.println("b a");


    }
}
