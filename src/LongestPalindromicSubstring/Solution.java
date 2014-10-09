package LongestPalindromicSubstring;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/9/14
 * Time: 5:20 PM
 */
public class Solution {
    boolean[][] isPalindrome;
    int max = Integer.MIN_VALUE;
    int[] position = new int[2];

    public String longestPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) isPalindrome[i][j] = true;
                else if (i + 1 == j) isPalindrome[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                else isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j] && (j - i) > max) {
                    max = j - i;
                    position[0] = i;
                    position[1] = j;
                }
            }
        }

        return s.substring(position[0], position[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abaa"));
    }
}
