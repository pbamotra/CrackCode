package PalindromePartitioningII;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/9/14
 * Time: 4:31 PM
 */
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n + 1];  // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) cut[i] = i - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) // odd length palindrome
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);

            for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++) // even length palindrome
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
        }
        return cut[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("ababababababababababababcbabababababababababababa"));
        System.out.println(new Solution().minCut("aab"));

    }
}
