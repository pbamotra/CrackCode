package PalindromePartitioning;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 6:01 PM
 */
public class Solution {
    List<List<String>> results = new ArrayList<List<String>>();
    boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) isPalindrome[i][j] = true;
                else if (i + 1 == j) isPalindrome[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                else isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        find(new ArrayList<String>(), 0, n, s);

        return results;
    }

    public void find(List<String> result, int position, int n, String s) {
        if (position == n) {
            results.add(new ArrayList<String>(result));
            return;
        }
        for (int j = position; j < n; j++) {
            if (isPalindrome[position][j] == true) {
                result.add(s.substring(position, j + 1));
                find(result, j + 1, n, s);
                result.remove(result.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.partition("aab");
        ListTools.PrintStringListList(s.results);
    }
}
