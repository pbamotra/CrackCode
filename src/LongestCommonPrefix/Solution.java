package LongestCommonPrefix;

import java.util.Arrays;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/24/14
 * Time: 7:36 PM
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min = Integer.MAX_VALUE;
        int min_p = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                min_p = i;
            }
        }

        String prefix = strs[min_p];
        boolean[] same_prefix = new boolean[prefix.length()];
        Arrays.fill(same_prefix, false);

        for (int i = prefix.length() - 1; i >= 0; i--) {
            boolean isSame = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != prefix.charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                same_prefix[i] = true;
            }
        }
        int last_p = 0;
        boolean allTrue = true;
        for (int i = 0; i < same_prefix.length; i++) {
            allTrue &= same_prefix[i];
            if (same_prefix[i] == false) {
                last_p = i;
                break;
            }
        }
        if (last_p < 0)
            last_p = 0;
        if (allTrue)
            last_p = prefix.length();
        return prefix.substring(0, last_p);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"aabbb", "aab", "aavv"}));
    }
}
